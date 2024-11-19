<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html lang="ko"><head><meta charset="UTF-8">
<title> Ajax </title>
<script src="js/jquery.js"></script>
<script>
$(function(){
	var href="/members?callback=myFnc";
	$.ajax({
		url:href,
		dataType:"jsonp"
	    })
	    .done(myFnc)//사용자 정의 함수 호출
	    .fail(function(){
	    	alert("데이터를 가져오는 중 오류가 발생하였습니다.")}
	    );
});
//myFnc 함수 정의
function myFnc(data){
	var $ul = $("<ul />");
	$.each(data, function(index, member){
		var $li = $("<li />").
		         text(member.name + "("+member.email+")");
		 $ul.append($li); // <ul><li>회원명(이메일)</li>
	});
	$(".wrap").html($ul);
}
</script>
</head>
<body>
  <div class="wrap"></div>
</body>
</html>