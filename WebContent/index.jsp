<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Top</title>
	<link rel="stylesheet" href="css/Style.css">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
</head>
<body>
  <div id="wrapper">
	<main>
	<div class="result">
		<div>
			<img src="card/BJ.jpg" class="trump">
			<form action="./BlackJack" method="get">
				<button type="submit">BRACK JACK</button>
			</form>
			<br>
			<jsp:include page="include/BJresult.jsp"/>
		</div>
		<span class="mgr-50"></span>
		<div>
			<img src="card/royal.jpg" class="trump">
			<form action="./Poker" method="get">
				<button type="submit">POKER</button>
			</form>
			<br>
			<jsp:include page="include/PKresult.jsp"/>
		</div>
	</div>
	</main>
<jsp:include page="include/footer.jsp"/>
</div>
</body>
</html>