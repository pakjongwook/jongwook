<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>scope 생명 주기 확인</title>
</head>
<body>
    <h3>request : ${requestScope.str}</h3> 
    <%-- 새로운 req 니까 이전  req는 안나옴 --%>

    <h3>session : ${sessionScope.str}</h3> 
    <%-- 브라우저가 꺼질 때까지 유지  --%>
    <h3>application : ${applicationScope.str}</h3> 
    <%-- 이클립스의 서버를 껏다가 끼면 값이 없어짐 --%>


</body>
</html>