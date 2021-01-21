<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Result</title>
	<link rel="stylesheet" href="css/Style.css">
</head>
<body>
<div>
	<p>
1位：${ranking.get(0)}
<br>
2位：${ranking.get(1)}
<br>
3位：${ranking.get(2)}
<br>
4位：${ranking.get(3)}
	</p>
</div>
<div class="result">
	<div>
		<form action="./Millionaire" method="get">
			<button  class="btn02" type="submit">ANOTHER BATTLE</button>
		</form>
	</div>
	<jsp:include page="include/Back.jsp"/>
</div>
</body>
</html>