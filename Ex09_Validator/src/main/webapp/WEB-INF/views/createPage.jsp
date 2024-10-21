<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
createPage.jsp<br>
<%
	String conPath = request.getContextPath();
%>
<form action="<%=conPath%>/create">
	작성자: <input name="writer" value="${dto.writer}" ><br>
	내용:<input name="content" value="${dto.content}" ><br>
	<input type="submit" value="전송">
</form>
</body>
</html>