<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>사원 정보</title>
</head>
<body>
<%="MyBatis 사용하기 : Hello World" %>
<br>
<%-- 순번 / 사원번호 / 사원명 /  직무 / 부서명 / 부서위치       
 --%>
 <table border="1">
 <tr><th>순번</th><th>사원번호</th><th>사원명</th><th>직무</th><th>부서명</th><th>부서위치</th></tr>
<c:forEach var="emp" items="${employees}" varStatus="st">
 <tr>
   <td>${st.count}</td> 
   <td> ${emp.empno} </td>
   <td> ${emp.ename1} </td>
   <td>${emp.job}</td>
   <td> ${emp.dname1} </td>
   <td> ${emp.loc} </td>
</tr>
</c:forEach>
</table>
</body>
</html>