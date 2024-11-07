<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>메뉴페이지</title>
</head>
<body>
 <%="Spring JPA #02" %>
 <br><p>
 
 <a href="/insert">데이터 추가</a><br><p>
 <a href="/selectById?id=1">개별 조회</a><br><p>
 <a href="/selectAll">전체 조회</a><br><p>
 <hr>
 <a href="/selectByName?name=을지문덕">개별조회 - byName</a><br><p>
 <a href="/selectByEmail?email=test7@test.com">개별조회 - byEamil</a><br><p>
 <hr>
 <a href="/selectByNameLike?name=김">리스트조회 - Name Like</a><br><p>
 <a href="/selectByNameLikeNameDesc?name=김">개별조회 - Name Like Name Desc</a><br><p>
 <hr>
 <a href="/selectByNameLikeOrder?name=김">리스트 조회 like Sort</a>
 <a href="/selectByNameLikeOrderSort?name=김&email=email">리스트 조회 like Sort</a>
 
</body>
</html>