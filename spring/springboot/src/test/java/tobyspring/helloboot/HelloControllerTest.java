package tobyspring.helloboot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HelloControllerTest {

    @Test
    void HelloController() {
        HelloController helloController = new HelloController(name -> name);

        String ret = helloController.hello("test");

        assertThat(ret).isEqualTo("test");
    }

    @Test
    void failHelloController() {
        HelloController helloController = new HelloController(name -> name);

        assertThatThrownBy(() -> {
            helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}