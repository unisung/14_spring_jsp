<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="k" %>    
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>나의 멤버들</h1>
<k:forEach var="mem" items="${members}" varStatus="st">
    ${st.count } 번: ${mem} <br> 
</k:forEach>
</body>
</html>