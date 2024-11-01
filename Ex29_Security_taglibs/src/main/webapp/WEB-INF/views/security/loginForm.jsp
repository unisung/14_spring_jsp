<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core"  prefix="c"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>로그인 폼</title>
</head>
<body>
<h1>loginForm.jsp</h1>

<%-- String loginUrl ="j_spring_security_check" --%>
<c:url value="j_spring_security_check" var="loginUrl"/>

<form action="${loginUrl}" 
                 method="post">
  <c:if test="${param.error != null }">
	  <p>
	   Login Error!<br/>
	   ${error_message}
	  </p>
  </c:if>
                 
  ID:<input name="j_username" value="${username}"><br/>
  PW:<input name="j_password"><br/>
  <input type="submit" value="LOGIN">
</form>

</body>
</html>