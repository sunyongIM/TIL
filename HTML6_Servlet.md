> 자바 웹을 다루는 기술 - <저자 : 이병승>, <출판사 : 길벗>

# 5~8장 서블릿 관련

> 웹 브라우저에서 전송한 데이터를 java에서 다룰 수 있게 해주는 라이브러리

HTML의 form입력 양식 => (HTTPServlet) 서블릿 => DB Table



### 6.1.1 서블릿 기본기능 수행과정

1. 클라이언트로부터 요청을 받음
2. 데이터베이스 연동과 같은 비즈니스 로직을 처리
3. 처리된 결과를 클라이언트에 돌려줌



## HttpServlet을 상속받는 클래스

> client의 데이터를 DB에 입력
>
> client의 데이터를 처리하여 출력

```java
package mc.sn.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
        req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
        //resp= 싱커스트림, 스트림을 만드는 행위
		String id = req.getParameter("user_id");
		String pwd = req.getParameter("user_pwd");
		String name = req.getParameter("user_name");
		String email = req.getParameter("user_email");
		out.print("<h1>Hello! "+name+"</h1><br>");
		out.print("<h1>check id: "+id+"</h1><br>");
		out.print("<h1>check pwd: "+pwd+"</h1><br>");
		out.print("<h1>check email: "+email+"</h1><br>");
		
	}
}

```



## web.xml

> 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" id="WebApp_ID" version="4.0">
  <display-name>MVCBasic</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  <servlet>
	  <servlet-name>controller</servlet-name>
	  <servlet-class>mc.sn.controller.MemberController</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>controller</servlet-name>
  	<url-pattern>/CmdController</url-pattern>
  </servlet-mapping>
</web-app>
```



## client에서 server에 데이터를 보내는 세가지 방법

1. url에 데이터 입력

2. html태그 이용

   - a태그 hyperlink이용

   - form태그 이용

