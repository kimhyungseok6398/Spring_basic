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


# 2.웹개발 기초 
## 정적컨텐츠
* 정적 컨텐츠 : 파일을 웹 브라우저에 그대로 내려주는것 
* 웹 브라우저에서 localhost:8080/hello-static.html -> 내장된 톰켓 서버를 요청을 받고 스프링한테 넘긴다 ->
* 스프링 컨테이너는 우선적으로 이와 관련된 컨트롤러를 찾는다
* 관련된 컨트롤러가 없다면 스프링 부트가 hello-static.html를 찾아서 있으면 해당되는 파일을 보여준다

## MVC와 템플릿 엔진( 가장 많이 선호)
* MVC와 템플릿 엔진 : JSP, PHP 등 서버에서 프로그래밍 하여 html을 동적으로 변경하여 보여주는 방식  
  * Model ,view, Controller로 구성 

        @GetMapping("hell-mvc")
        public String helloMvc(@RequestParam(value = "name",required = false) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
        }


        <html xmlns:th="http://www.thymeleaf.org">
          <body>
          <p th:text="'hello ' + ${name}">hello! empty</p>
          </body>
          </html>

* 이렇게 컨트롤러와 뷰를 생성한 다음 매개변수에 있는 name과 벨루값에 있는 name이
* url에 입력하는 값으로 대체가 된다
* ex) http://localhost:8080/hell-mvc?name=spring!!!!
* 이면 ?뒤에 입력한 값으로 뷰에선 치환 달러 표시내용에서 model에 키 값에서 내용을 꺼내서 그 값으로 치환 
## MVC에 웹 구조 
* 똑같이 localhost:8080/hello-mvc를 치면 
* 내장된 톰켓 서버를 거치고  hello-mvc이라는 것이 요청된것을 스프링한데 전달
* 스프링 컨테이너는 매핑된 컨트롤러를 찾고  
* 키는 name이고 값은 spring일때
* 뷰 리졸버가 뷰를 찾아서 연결시켜준다 
* 리졸버가 뷰를 찾아서 타임리프가 변환된 html를 웹브라우저에게 반환



## API
* API : 안드로이드, 클라이언트와 개발할떄 JSON 데이터 구조 포멧을 이용하여 클라이언트에게 데이터를 보여주는 방식 

