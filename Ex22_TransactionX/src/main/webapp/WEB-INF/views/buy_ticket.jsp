<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>BuyTicket</title>
</head>
<body>
<p>카드결제</p>

<form action="buy_ticket_card" method="get">
 고객 아이디:<input name="consumerId"><br>
 티켓 구매수:<input name="amount"><br>
 에러 발생 여부:<input name="error" value="0"><br>
 <input type="submit" value="구매"><br>

<hr>
에러 발생 여부에 1을 입력하면 에러가 발생합니다.

</form>
</body>
</html>