<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html lang="ko"><head><meta charset="UTF-8">
<title> Ajax </title>
<script src="js/jquery.js"></script>
<script>
$(function(){
	var href="/members?callback=myFnc";
	$.ajax({
		url:,
		dataType:"jsonp"
	    }).done(function myFnc(data){
	    	console.log(data);
	    });
});
</script>
</head>
<body>
  <div class="wrap"></div>
</body>
</html>