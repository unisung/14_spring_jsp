<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>입력 결과</title></head><body>

<%="Spring JPA #03 - Name like Paging" %>
<br><p>
<hr>
총글의 갯수: ${totalEements}<br>
총 페이지 : ${totalPages}<br>
페이지당 글 갯수(size) : ${size}<br>
페이지번호:${pageNumber}<br>
nuberOfElements : ${numberOfElements}<br>
<hr>

<table border="1">
<tr>
 <th>순번</th><th> 아이디 </th><th> 이름 </th><th> email</th>
</tr>
<c:forEach var="member" items="${members}" varStatus="st">
  <tr>
    <td>${st.count}</td>
	<td><a href="/selectById?id=${member.id }">${member.id }</a></td>
	<td>${member.name }</td>
	<td>${member.email }</td>
  </tr>
</c:forEach>
</table>

</body>
</html>