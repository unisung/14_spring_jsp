<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>메뉴페이지</title>
</head>
<body>
 <%="Spring JPA #01" %>
 <br><p>
 
 <a href="/insert?username=test1">데이터 추가</a><br><p>
 <a href="/select?id=1">개별 조회</a><br><p>
 <a href="/selectAll">전체 조회</a><br><p>
 <a href="/delete?id=2">데이터 삭제</a><br><p>
 <a href="/update?id=1&username=홍길동">데이터 수정</a><br><p>
</body>
</html>