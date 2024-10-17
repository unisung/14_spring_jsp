<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.print("01: Hello World");
%><br>
<br>
<!-- controller에서 member를 보냄, id와 name필드값이 전달  -->
당신의 아이디는 ${member.id}입니다.<br>
당신의 이름은 ${member.name }입니다<br>
</body>
</html>