package hello.jdbc.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.ConnectException;
import java.sql.SQLException;

@Slf4j
public class UnCheckedAppTest {

    @Test
    void unchecked_catch() {
        Service service = new Service();
        service.callCatch();

    }

    @Test
    void unchecked_throw() {
        Service service = new Service();
        service.callCatch();
        Assertions.assertThatThrownBy(() -> service.callThrow())
                .isInstanceOf(MyUnCheckedException.class);
    }

    /**
     * RuntimeException을 상속받은 예외는 언체크 예외가 된다.
     */
    static class MyUnCheckedException extends RuntimeException {
        public MyUnCheckedException(String message) {
            super(message);
        }
    }

    /**
     * UnChecked 에외는
     * 예외를 잡거나, 던지지 않아도 된다.
     * 예외를 잡지 않으면 자도응로 밖으로 던진다.
     */
    static class Service{
        Repository repository = new Repository();

        public void callCatch() {
            try {
                repository.call();
            } catch (MyUnCheckedException e) {
                //예외 로직 처리
                log.info("예외처리 , message = {}", e.getMessage(),e);
            }
        }

        /**
         * 예외를 잡지 않아도 된다. 자연스럽게 상위로 넘어간다.
         * 체크 예외와 다르게 throws 예외 선언을 하지 않아도 된다.
         */
        public void callThrow() {
            repository.call();

        }

    }

    static class NetworkClient{
        public void call() throws ConnectException {
            throw new RuntimeConnectionException("ex");
        }
    }

    static class Repository {
        public void call(){
            try {
                runSQL();
            } catch (SQLException e) {
                throw new RuntimeSQLException(e);
            }
        }

        public void runSQL() throws SQLException {
            throw new SQLException("ex");
        }
    }

    static class RuntimeConnectionException extends RuntimeException {
        public RuntimeConnectionException(String mesaage) {
            super(mesaage);
        }
    }


    static class RuntimeSQLException extends RuntimeException {
        public RuntimeSQLException(Throwable cause) {
            super(cause);
        }
    }

}

