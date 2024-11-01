<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" 
           prefix="sec" %>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>Welcome-member</title>
</head>
<body>
Welcome : Admin

<hr>
<sec:authorize access="isAuthenticated()">
	<p> 로그인 </p>
	<sec:authentication property="name"/> 님 환영합니다.<br/>
	<a href="/logout">로그아웃</a>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
 <p> 로그아웃 </p>
</sec:authorize>


</body>
</html>