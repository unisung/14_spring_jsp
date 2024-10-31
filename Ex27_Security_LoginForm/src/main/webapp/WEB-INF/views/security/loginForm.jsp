<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core"  prefix="c"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>로그인 폼</title>
</head>
<body>
<h1>loginForm.jsp</h1>

<form action="<c:url value='j_spring_security_check'/>" 
                 method="post">
  ID:<input name="j_username"><br/>
  PW:<input name="j_password"><br/>
  <input type="submit" value="LOGIN">
</form>

</body>
</html>