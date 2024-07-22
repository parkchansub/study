package picasoo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import picasoo.spring.repository.MemberRepository;
import picasoo.spring.repository.MemoryMemberRepository;
import picasoo.spring.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
