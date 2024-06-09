package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.SocketOption;

@Controller
public class MemberController {
    // 스프링 컨테이너가 생성이 되는데
    // Controller 어노테이션이 있으면  이 객체를 생성을 해서 컨테이너에서 관리를 해준다.
    // 원래코드 private final MemberService memberService = new MemberService();

     // 필드 주입방식( 선호하는 방식은 아니다)
    private MemberService memberService;
// setter 주입방식(단점 : 접근제어자가 public으로 되어있어야한다.
               //  노출이 쉽기에 문제가 있다.
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    @Autowired
   public MemberController(MemberService memberService) {
        this.memberService = memberService;
        // 생성자에 Autowiredr가 있으면
        // 스프링이 스프링에 있는 멤버 서비스를 가져다가 연결을 시켜준다.


    }
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm form){
        //
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName());
        System.out.println("member = " + form.getName());

        memberService.join(member);
        return "redirect:/";
    }
}
