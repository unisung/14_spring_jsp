<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>이미지 버튼 </title>
	<style>
		table {
			border:0;
		}
		td {
			padding:5px 10px;
			border:0;
			vertical-align: middle;
		}
	</style>
</head>
<body>
	<form action="/test1" method="post">
		<table>
			<tr>
				<td><label>아이디 <input type="text" size="15" name="id"></label></td>
				<td><label>이름 <input type="text" size="15" name="name"></label></td>
				<td><input type="image" id="butt" src="images/login.jpg"  alt="login"></td>
			</tr>
		</table>	
	</form>
</body>
</html>