package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class MemberRepositoryTest {

    MemberRepository memberRepository = new MemberRepository();

    @Test
    void crud() throws SQLException {
        Member member = new Member("memberVo", 10000);
        memberRepository.save(member);
    }

}