package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0l;
    // 여기서 시퀀스는 0,1,2와 같은 키값을 생성해주는 역할

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
        // 스토어에 넣기 전에 이름은 넘어온상태이고
        // name은 고객이 회원가입때 적는 이름
        // 아이디는 시스템이 정해주는 것
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // 널이여도 감싸서 할 수 있다.
        // 널이 반환될 가능성이 있기에
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        // 루프를 돌리면서 getname이 파라미터로 들어온 name하고 같은지
        // 같은 경우에만 필터링 findAny는 하나라도 찾는 메서드
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());

    }
    public void clearStore(){
        store.clear();
    }
}

