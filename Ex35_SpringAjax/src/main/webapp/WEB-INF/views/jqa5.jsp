<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html lang="ko"><head><meta charset="UTF-8">
<title> Ajax </title>
<script src="js/jquery.js"></script>
<script>
$(function(){
	$.ajax({
		url:"/rss",//요청 url
		dataType:"xml", //응답파일타입
		success:function(data){//성공시처리
			var $items = $(data).find("item");
		if($items.length > 0){//응답받은 리스트의 객체가 존재하면
			$items = $items.slice(10,20);
			var $ulTag = $("<ul />");//<ul><li></li></ul>
			//$.each(처리할배열객체, 함수(인덱스,개별처리변수){});
			$.each($items, function(i,o){
				var $title = $(o).find("title").text();
				var $link = $(o).find("link").text();
				
				var $aTag = $("<a />").attr({
					"href":$link,
					"target":"_blank"
				}).text($title);
				//console.log($title, $link, $aTag);
				var $liTag = $("<li />").append($aTag);
				//console.log($liTag);
				
				$ulTag.append($liTag);
			});
			
			$(".wrap").append($ulTag);
		}
		}
	});
});
</script>
</head>
<body>
  <div class="wrap"></div>
</body>
</html>