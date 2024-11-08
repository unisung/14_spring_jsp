<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>메뉴페이지</title>
</head>
<body>
 <%="Spring JPA #04" %>
 <br><p>
 
 <a href="/selectByNameLike1?name=test">
  Name Like 조회 : JPQL 1</a><br><p>
 <a href="/selectByNameLike2?name=test">
  Name Like 조회 : JPQL 1</a><br><p>
 <a href="/selectByNameLike3?name=test&page=2">
  Name Like 조회 : JPQL 3 - 2페이지</a><br><p>
 <hr>
 <a href="/selectByNameLike4?name=test">
  Name Like 조회 : Native SQL</a><br><p>
 
 
</body>
</html>