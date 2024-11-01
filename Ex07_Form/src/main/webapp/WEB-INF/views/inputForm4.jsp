<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>filedset과 legend 태그</title>
		<style>
			ul {
				list-style:none;
			}
			li {
				margin:20px;
			}
			li label {
				width:80px;
				float:left;
			}
			fieldset {
				margin:15px;
			}
		</style>
</head>
<body>
	<form action="/test4Proc" method="post">
		<fieldset>
			<legend>개인 정보</legend>
			<ul>
				<li>
					<label for="name">이름</label>
					<input type="text" id="name" name="name">
				</li>
				<li>
					<label for="mail">메일 주소</label>
					<input type="text" id="mail" name="mail">
				</li>
				<li>
					<label for="address">주소</label>
					<input type="text" id="address" name="address">
				</li>
			</ul>
		</fieldset>		
		<fieldset>
			<legend>로그인 정보</legend>
			<ul>
				<li>
					<label for="id">아이디</label>
					<input type="text" id="id" name="id">
				</li>
				<li>
					<label for="pwd">비밀번호</label>
					<input type="text" id="pwd" name="password">
				</li>
			</ul>
		</fieldset>
		<input type="submit" value="전송">
	</form>
</body>
</html>