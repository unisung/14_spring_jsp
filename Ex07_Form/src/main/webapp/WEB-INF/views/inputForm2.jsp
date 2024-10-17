<%@ page  pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>입력폼</title>
</head>
<body>
<div>
<form action="/test2" method="post">
 <fieldset>
 <legend>입력</legend>
  id: <input name="id"><br>
  name:<input name="name"><br>
  pwd:<input type="password" ><br>
  <input type="submit" value="전송">
 </fieldset>
</form>
</div>
</body>
</html>