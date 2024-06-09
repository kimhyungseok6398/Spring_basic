package hello.hello_spring;

import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
        // 스프링이 뜰때 @Configuration를 읽고
        // 이에 해당하는 로직을 스프링 빈에 등록을 해준다.

    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
        }
    }

