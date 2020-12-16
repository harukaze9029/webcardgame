<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Top</title>
	<link rel="stylesheet" href="css/Style.css">
</head>
<body>
	<div>
		<br>
		<div class="result">
			<div>
				<img src="card/BJ.jpg" class="trump">
				<form action="./BlackJack" method="get">
					<button type="submit">BRACK JACK</button>
				</form>
				<br>
				<div class="resultback">
					<jsp:include page="include/BJresult.jsp"/>
				</div>
			</div>
			<span class="mgr-50"></span>
			<div>
				<img src="card/royal.jpg" class="trump">
				<form action="./Poker" method="get">
					<button type="submit">POKER</button>
				</form>
				<br>
				<div class="resultback">
					<jsp:include page="include/PKresult.jsp"/>
				</div>
			</div>
		</div>
	</div>
</body>
</html>