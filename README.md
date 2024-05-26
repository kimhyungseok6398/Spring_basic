# 스프링 입문 

* * * 

## 필수 세팅 작업
* 빌드가  오래걸릴경우 File -> setting -> Gradle 인텔리 제이 변경

## model.attribute 란?
* 키와 벨류값으로 이루어져 있으며 모델에 데이터를 담아 키값을 통해 데이터를 전달 할 수 있다.          

            @GetMapping("hello")
              public String hello(Model model){
              model.addAttribute("data","hello!!");
              return "hello";

* 이런 식으로 데이터를 뷰로 넘겨주고 뷰에선 (타임리프 템플릿 이용)


        <!DOCTYPE HTML>
            <html xmlns:th="http://www.thymeleaf.org">
            <head>
                <title>Hello</title>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            </head>
            <body>
            <p th:text="'안녕하세요. ' + ${data}" >안녕하세요. 손님</p>
            </body>
            </html>

##  웹브라우저 작동원리
* Get방식으로 localhost:8080/hello로 url로 던지게 되면
* 스프링 부트는 톰켓을 내장하고 있다
* 스프링이 해당하는 컨트롤러를 찾아서 해당하는 메서드를 찾아 호출하고 실행 후 모델에 담긴 후 
* 원하는 뷰로 찾아서 렌더링을 해주는 역할 
* 컨트롤러에서 리턴값으로 반환하면 뷰 리졸터가 화면을 찾아서 처리


## 참고) spring-boot-devtool 라이브러리를 추가하면 html 파일을 컴파일만 해주면 서버 재시작 없이 view파일 변경이 가능하다.

## (강의 진행하면서 만났던 오류)
* cmd로 빌드시 자바버전으로 인해 빌드실패가 발생
* ex) C:\Program Files\Java\jdk-17.0.3.1'식으로 경로 변경
* 환경변수 -> JAVA_HOME -> 같은 방식으로 하되 경로가 bin 경로까지 설정
* C:\Program Files\Java\jdk-17.0.3.1\bin' -> 확인 
  
## 참고) 
* cmd로 빌드 방식
* 현재 프로젝트 경로 설정 -> gradlew.bat -> BUILD SUCCESSFUL 확인 ->
* gradlew build -> 다시한번 BUILD SUCCESSFUL 확인 ->cd build 이동 -> dir로 libs 파일이 있는지 확인 
* cd libs 경로 이동 -> 프로젝트 스냅샷.jar파일이 있는지 확인 
* ex)  hello-spring-0.0.1-SNAPSHOT.jar
* -> java -jar  프로젝트 스냅샷 실행
* ex) java -jar  hello-spring-0.0.1-SNAPSHOT.jar 실행이 되면 완료
* 서버 종료시에는 컨트롤 + c

## 배포시
* 참고) 배포시에도 이 파일만 복사해서 서버에 넣어주고 jar파일을 실행


