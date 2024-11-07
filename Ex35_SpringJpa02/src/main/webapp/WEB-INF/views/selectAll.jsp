<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>입력 결과</title>
</head>
<body>

<%="Spring JPA #02 - select All" %>
<br>

<table border="1">
<tr>
 <th>순번</th><th> 아이디 </th><th> 이름 </th><th> email</th>
</tr>
<c:forEach var="member" items="${members}" varStatus="st">
  <tr>
    <td>${st.count}</td>
	<td><a href="/select?id=${member.id }">${member.id }</a></td>
	<td>${member.name }</td>
	<td>${member.email }</td>
  </tr>
</c:forEach>
</table>

</body>
</html>