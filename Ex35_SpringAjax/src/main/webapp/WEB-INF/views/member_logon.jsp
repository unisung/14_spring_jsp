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
  var $frm = $(".login_f");
  $frm.on("submit", function(e) {
    e.preventDefault();
    var myData = $frm.serialize();//?id=korean&pw=1234
        console.log("myData",myData);

    $.ajax({
      type: "POST",
      url: $frm.attr("action"),
      data: myData,
      
      success:function(res) {
        if(res) {
         //var jsonData = JSON.parse(res);//{'user_name':'박부장','user_id':'park'}
         var message = res.user_name + 
         "( " + res.user_id + " )" 
         + "님 반갑습니다";
         $(".login_wrap").html(message);
        }
      }
    
    
    });
  });
});
</script>
</head>
<body>
<div class="login_wrap">
  <h1>로그인</h1>
  <form class="login_f" method='post' action='/member_login_ok'>
    <p>
    <label for="user_id">아이디</label>
    <input type="text" name="user_id" id="user_id" value="korean" />
    </p>
    <p>
    <label for="user_pw">비밀번호</label>
    <input type="password" name="user_pw" id="user_pw" value="12345" />
    </p>
    <p><input type="submit" value="로그인" class="login_btn" /></p>
  </form>
</div>
</body>
</html>