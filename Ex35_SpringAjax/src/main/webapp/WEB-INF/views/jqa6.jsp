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
<%-- 
JSON vs JSONP 비교
     특징:		JSON	          	JSONP
주요 목적	: 데이터 교환		      교차 도메인 요청 (CORS 우회)
데이터 형식: 순수 데이터(JSON 객체) JSON 데이터를 함수 호출로 감싸 반환
CORS 제한: CORS 설정 필요		  제한 없음 (스크립트 태그 활용)
MIME 타입: application/json	  application/javascript
보안	:	  안전 (순수 데이터)	  XSS 공격에 취약
구현 복잡도: 간단			     서버에서 콜백 함수 감싸기 필요

--%>