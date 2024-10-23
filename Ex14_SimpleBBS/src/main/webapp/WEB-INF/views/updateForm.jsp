<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>글수정 페이지</title>
</head>
<body>
<br><p>
<table width="500" border="1" cellpadding="0"
          cellspacing="0">
<form action="update" method="post">
  <tr>
   <td>작성자</td>
   <td><input name="writer" size="20" value="${dto.writer }"></td>
  </tr>
  <tr>
   <td>제목</td>
   <td><input name="title" size="100" value="${dto.title}"></td>
  </tr>
  <tr>
   <td>내용</td>
   <td><input name="content" size="100" value="${dto.content}"></td>
  </tr>
  <tr>
   <td colspan="2">
   	<input type="submit" value="수정"> &nbsp;&nbsp;
   	<a href="list">목록보기</a>
   </td>
  </tr>
</form>
</table>
</body>
</html>