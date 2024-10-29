<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>사원정보${empInfo.empno}</title>
</head>
<body>
<table border="1">
 <tr><th>사원번호</th><th>사원이름</th><th>업무</th>
     <th>소속부서</th><th>부서위치</th>
 </tr>
 <tr><td>${empInfo.empno}</td><td>${empInfo.ename1}</td>
     <td>${empInfo.job}</td><td>${empInfo.dname1}</td>
     <td>${empInfo.loc}</td>
 </tr>
 
</table>
</body>
</html>