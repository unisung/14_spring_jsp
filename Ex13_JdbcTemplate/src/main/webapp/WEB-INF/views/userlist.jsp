<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.print("JdbccTemplate : Hello World");
%>
<br>
<c:forEach  var="dto" items="${users}" varStatus="stat">
${stat.first}-${stat.last}
-${stat.count} - ${stat.index} 
- ${dto.id} / ${dto.name } <br>
</c:forEach>

</body>
</html>