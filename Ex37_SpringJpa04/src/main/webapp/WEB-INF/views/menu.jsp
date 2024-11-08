<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>메뉴페이지</title>
</head>
<body>
 <%="Spring JPA #03" %>
 <br><p>
 
 <a href="/selectByNameLike?name=test&page=1">
  Name Like 조회 : 1페이지</a><br><p>
 <a href="/selectByNameLike?name=test&page=2">
  Name Like 조회 : 2페이지</a><br><p>
 <a href="/selectByNameLike?name=test&page=3">
  Name Like 조회 : 3페이지</a><br><p>
 <hr>
 <a href="/selectByNameLike?name=test&page=4">
  Name Like 조회 : 4페이지</a><br><p>
 
 
</body>
</html>