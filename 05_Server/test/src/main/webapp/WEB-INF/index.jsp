<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>환영합니다!</title>
</head>
<body>
	<h1>제품 주문</h1>
	<form action="orderProduct.do" method="post">
		<label for="name">이름:</label>
		<input type="text" id="name" name="name" value="" /><br><br>
		
		<label for="blackPen">검정 펜 수량:</label>
		<input type="number" id="blackPen" name="blackPen" min="0" max="100" value="0" /><br><br>
		
		<label for="redPen">빨간 펜 수량:</label>
		<input type="number" id="redPen" name="redPen" min="0" max="100" value="0" /><br><br>
		
		<label for="bluePen">파란 펜 수량:</label>
		<input type="number" id="bluePen" name="bluePen" min="0" max="100" value="0" /><br><br>
		
		<label for="white">화이트 수량:</label>
		<input type="number" id="white" name="white" min="0" max="100" value="0" /><br><br>
		
		<input type="submit" value="구매" />
	</form>
	
	<form action="reset.do" method="post">
		<input type="submit" value="초기화" />
	</form>
</body>

	

</body>
</html>