package hello.hello_spring.controller;

public class MemberForm {
    // create에 있는 name과 매칭이 되면서
    // 값이 넣어지게 된다.

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
