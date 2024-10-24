<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>사용자 리스트</title>
</head>
<body>
<%="Mybatis : Hello World" %>
<br>
<%-- 출력 형식 1. id명 / 이름 ,, id는 굵게 
   1.test1 / 홍길동1
 --%>
<c:forEach var="dto" items="${users}" varStatus="st">
  ${st.count}.<strong>${dto.id}</strong> / ${dto.name} <br>
</c:forEach>
 
</body>
</html>