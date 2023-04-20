<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EL 결과</title>
</head>
<body>
    <h1>EL을 이용해서 출력하기</h1>

    <h3>파라미터</h3>
    <ul>
        <li> \${ param.name속성값 } : request 담긴 파라미터 얻어오기(1개) </li>
            <%-- getParmeterValues --%>
        <li> \${ paramValues.name속성값 } : 모든 파라미터를 배열로 얻어오기 </li>
    </ul>


    <p>
        이름 : ${param.inputName} <br>   
        이름 : ${param.inputAge} <br>   

        opt : ${param.opt} <br>   

        opt[0] : ${paramValues.opt[0]} <br>   
        opt[1] : ${paramValues.opt[1]} <br>   
        opt[2] : ${paramValues.opt[2]} <br>   
    </p>
    
</body>
</html>