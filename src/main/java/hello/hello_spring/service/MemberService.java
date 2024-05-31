package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     *
     * @param member
     * @return
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복회원은 X
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
        // 중복회원 검증
        // 리펙토링 단축키

        // 자동 리턴 단축키 ctrl + alt + Enter

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                    // ifPresent Optional일 경우 널이 아니고 값이 있으면  로직이 동작
                });
    }

    /**
     * 전체회원 조회
     */
    public List<Member> findMember() {
       return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);    }
}
