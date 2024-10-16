<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title></head><body>

<%-- 표현식으로 함수를 호출하여 결과 출력 --%>
<%=helloWorld() %>

<%-- helloWorld함수 선언 --%>
<%!
  public String helloWorld(){
	Date now = new  Date();
	SimpleDateFormat sdf 
	   = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm:ss");
	
	return "Hello World, 현재시간은: " +sdf.format(now) ;
}
%>
</body>
</html>