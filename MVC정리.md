# MVC정리



## Servlet, ConnectionPool

### Servlet생성 및 연결

- web.xml : 태그로 Servlet 생성 및 연결

  - ```
    <servlet>
      	<servlet-name>controller</servlet-name>
      	<servlet-class>mc.sn.controller.MemberController</servlet-class>
      </servlet>	
      <servlet-mapping>
      	<servlet-name>controller</servlet-name>
      	<url-pattern>/CmdController</url-pattern>
      </servlet-mapping>
    ```

- Annotation : @를 통한 Servlet연결

  - ```
    @WebServlet("/LoginController")
    ```

  - ```
    @WebServlet(name="initParamServlet",
            urlPatterns = { "/sInit", "/sInit2" }, initParams = {
    		@WebInitParam(name = "email", value = "admin@jweb.com"), 
    		@WebInitParam(name = "tel", value = "010-1111-2222") })
    ```



### ConnectionPool

> **미리 데이터베이스와 연결시킨 상태를 유지하는 기술을 ConnectionPool이라 한다.**
>
> DataSource를 이용해 데이터베이스에 연동하는 방법.
>
> 웹 어플리케이션이 실행됨과 동시에 연동할 데이터베이스와의 연결을 미리 설정해 두고,
>
> 필요할 때 마다 미리 연결해 좋은 상태를 이용해 빠른 작업을 도와준다.





## 페이지 연결은 어떻게 할 것인가

- 요청(url)

  - 주소
  - `<a>`테그
  - form

  

## 컨트롤러에 작업요청은 어떻게 할 것인가

- 작업의 종류를 보낸다(url)
  - QueryString (?cmd=key)
  - jsp페이지



## 작업처리결과(데이터)를 어떻게 클라이언트에게 전달할 것인가

- 요청(request) 객체 또는 세션(session) 객체, 어플리케이션 객체에 저장해서

### WAS에서 이동 지시의 종류

1. SendRedirect

   - ```java
     resp.sendRedirect(url);
     ```

   - 가장 단순한 이동방법, 이동기록이 없다(데이터를 보낼 수 없음).

2. RequestDispatcher

   - ```java
     RequestDispatcher rd = request.getRequestDispatcher(url);
     rd.forward(request, response);
     ```

   - 이동기록이 있어서, 이동기록에 데이터를 포함시킬 수 있다.

   - request.getParameter("`setParameter의 key`");

     - key에 대응되는 value가 나온다.

3. 



## 컨트롤러, 서비스, DAO는 어떻게 구별하는가

- 컨트롤러
  - 클라이언트로부터의 요청과 데이터를 받고 처리결과를 전송
- 서비스
  - 컨트롤러에게 받은 데이터와 DAO에게서 받은 데이터를 가지고 비지니스 로직처리하여 컨트롤러에게 전달
- DAO
  - 데이터베이스에 연결하여 필요한 데이터를 가져와서 컨트롤러에게 전달



## 데이터클래스의 용법은 무엇인가

- 서로 관련있는 데이터를 하나로 묶는 역할
- 각 단계로 한 셋트의 데이터를 묶어서 전달한다



## 클라이언트의 역할에서 INPUT과 OUTPUT의 차이점은 무엇인가

- INPUT : 작업지시의 시작
- OUTPUT : 작업지시의 결과



## 서버로 이동없이 데이터 처리(서버사이드작업)를 할 수 없을까

- 자바스크립트의 XMLHttpRequest객체를 통해서
- Ajax 라이브러리 사용(jQuery)



## 클라이언트에서 데이터를 수집하는 방법은 어떤것이 있는가

- Form데이터 또는 QueryString



## DB에 CRUD 쿼리를 어떻게 전달하고 결과를 받을 수 있는가

- JDBC를 통해서
  - Create : Connection - Statement				  	(executeUpdate)
  - Read : Connection - Statement - ResultSet     (executeQuery)
  - Update : Connection - PreparedStatement    (executeUpdate)
  - Delete : Connection - PreparedStatement      (executeUpdate)

