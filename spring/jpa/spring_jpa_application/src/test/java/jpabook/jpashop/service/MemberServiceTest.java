package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;


    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("pcs");

        //when
        Long saveId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(saveId));

    }

     @Test(expected = IllegalStateException.class)
     public void 중복_회원_예외() throws Exception {
         //given
         Member member = new Member();
         member.setName("a");

         Member member2 = new Member();
         member.setName("a");
         //when
         memberService.join(member);
         memberService.join(member2);
         /*try {
             memberService.join(member2);
         } catch (IllegalStateException) {
             return;
         }*/

         //then
         fail("예외가 발생해야 한다.");
      }
}