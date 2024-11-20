<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> Ajax </title>
<script src="js/jquery.js"></script>
<script>
$(function() {
	var href = "/members";
	$.ajax({
		url: href,
		dataType: "jsonp",
		jsonp: "callback", //서버에서 사용할 콜백 파라미터이름
		jsonCallback: "myFnc" //콜백 함수 ?callaback=myFnc
	}).done(function(data){
		if(data.length > 0) {
			var $table = $("<table />");
			data.forEach(function(o){
				$id = o.id;
				$name = o.name;
				$email = o.email;

				var trTag = $("<tr />");
				trTag.append(
					$("<td/>").text($id),
					$("<td/>").text($name),
					$("<td/>").text($email)
				);

				$table.append(trTag);
			});

			$(".wrap").append($table);
		}
	});
});
</script>
</head>
<body>
	<div class="wrap"></div>
</body>
</html>