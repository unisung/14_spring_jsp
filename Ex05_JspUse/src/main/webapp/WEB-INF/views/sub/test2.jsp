<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
<meta charset="UTF-8"><title>Insert title here</title>
</head>
<body>
<%-- <%
	out.print("Hello world (Sub)");
%> --%>
<%-- jsp 주석
 --%>
 <!-- 표현식 -->
 <h3>환영인사:<%="Hello world (Sub)"%></h3> <br>
 <p>1부터10까지 더한 결과:<%= 1+2+3+4+5+6+7+8+9+10 %></p><br>
<p>현재시간:<%=new Date() %><!-- 함수호출결과 -->
</body>
</html>