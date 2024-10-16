<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>myview 페이지</h1>
<!-- Controller로 부터 전달된 Model을 얻기 getAttribute(이름) -->
<%=request.getAttribute("name")%><br>
<%=request.getAttribute("ObjectTest")%><br>
<%=request.getAttribute("lists") %><br><br>

<%
List<String> list =(List<String>)request.getAttribute("lists");//Object ->(List)

for(String s:list){
	out.print(s+"<br>");
}
%>
<br>
<%
for(int i=0;i<list.size();i++){
	out.print(list.get(i) + "<br>");
}
%>
<hr>
<%
  List<String> list2 =(List<String>)request.getAttribute("lists");
  Iterator itor = list2.iterator();//반복자
  while(itor.hasNext()){
	 String s=(String)itor.next();
	 out.print(s+"<br>");
  }
%>
<hr>
<%
    Set<String> set = (Set<String>)request.getAttribute("sets");
	Iterator itor2 = set.iterator();//반복자
	while(itor2.hasNext()){
		 String s=(String)itor2.next();
		 out.print(s+"<br>");
}
%>

</body>
</html>