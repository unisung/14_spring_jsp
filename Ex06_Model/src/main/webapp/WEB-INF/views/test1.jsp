<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 Hello my test1 페이지<br><br>
 <!-- 스크립틀릿 - html파일에서 java코드를 쓰는 영역 -->
 <%
  /* out변수는 내장객체로 출력용객체 */
  out.println("이페이지는 test1.jsp페이지입니다.");
 %>
 <br><br>
 <img src="/image/SpringBoot.png">
 
</body>
</html>