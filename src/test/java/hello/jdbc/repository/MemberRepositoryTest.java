package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

@Slf4j
class MemberRepositoryTest {

    MemberRepositoryV0 memberRepository = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {
        //save
        Member member = new Member("memberVo", 10000);
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

    }

}