package hello.jdbc.repository;

import com.zaxxer.hikari.HikariDataSource;
import hello.jdbc.connection.ConnectionConst;
import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static hello.jdbc.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
class MemberRepositoryV1Test {

    MemberRepositoryV1 memberRepository;

    @BeforeEach
    void beforeEach() {
        /*DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);*/

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        memberRepository = new MemberRepositoryV1(dataSource);
    }

    @Test
    void crud() throws SQLException {
        //save
        Member member = new Member("memberVo2", 10000);
        memberRepository.save(member);

        //findById
        Member findMember = memberRepository.findById(member.getMemberId());
        log.info("findMember={}", findMember);
        log.info("member != findMember {} ", member == findMember);
        log.info("member equals findMember {} ", member.equals(findMember));

        assertThat(findMember).isEqualTo(member);

        //update: money: 10000 -> 20000
        memberRepository.update(member.getMemberId(), 20000);
        Member upddateMember = memberRepository.findById(member.getMemberId());
        assertThat(upddateMember.getMoney()).isEqualTo(20000);


        //delete:
        memberRepository.delete(member.getMemberId());
        assertThatThrownBy(() -> memberRepository.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}