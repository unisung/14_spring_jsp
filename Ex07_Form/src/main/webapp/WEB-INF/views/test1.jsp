<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("#01: hello world");
%>
<br>
<%="Hello World2" %>
<br>
<hr>
당신의 아이디는 ${id }입니다. <br>
당신의 이름은 ${name }입니다.<br>
</body>
</html>