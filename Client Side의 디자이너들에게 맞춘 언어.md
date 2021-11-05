# Client Side의 디자이너들에게 맞춰준 언어

> html, css, jsp를 사용하는 디자이너들



## JSTL (Java Standard Tag Library)

> jsp상에서 프로세스 역할을 하는 태그
>
> pro17/test2/listMembers.jsp

```jsp
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
```



## EL (Exepression Language)

```
<p class="cls1">회원정보</p>
   <table align="center" border="1" >
      <tr align="center" bgcolor="lightgreen">
         <td width="7%" ><b>아이디</b></td>
         <td width="7%" ><b>비밀번호</b></td>
         <td width="7%" ><b>이름</b></td>
         <td width="7%"><b>이메일</b></td>
         <td width="7%" ><b>가입일</b></td>
   </tr>
```

