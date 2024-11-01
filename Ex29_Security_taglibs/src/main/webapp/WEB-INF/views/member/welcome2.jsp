<%@ page pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sec" 
		uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>Welcome-member</title>
</head>
<body>
Welcome : Member

<hr>

<sec:authorize access="isAuthenticated()">
	<p> Log-In </p>
	USER ID : <sec:authentication property="name"/><br/>
	<sec:authentication property="name"/>님 환영합니다.<br>
	<a href="/logout"> Log out </a>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
<p> Log-Out </p>
</sec:authorize>


</body>
</html>