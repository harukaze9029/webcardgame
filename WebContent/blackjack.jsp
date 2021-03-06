<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Brack Jack</title>
	<link rel="stylesheet" href="css/Style.css">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
</head>
<body>
<div id="wrapper">
	<main>
	<div class="hand">
		<div class="host">
			<p class="example2">DEALER HAND</p>
			<h2 class="box1">COUNT ??</h2>
			<div class="handback">
				<img src="card/card_${dealer[0].suit}_${dealer[0].rank}.png" class="card"/>
				<img src="card/card_back.png" class="card"/>
			</div>
		</div>
		<div class="player">
			<p class="example2">PLAYER HAND</p>
			<h2 class="box1">COUNT ${playercount}</h2>
			<jsp:include page="include/playerhand.jsp"/>
		</div>
	</div>
	<br>
	<div class="result">
		<div>
			<form action="./BlackJack" method="post">
				<button class="button" type="submit">HIT</button>
			</form>
		</div>
		<span class="mgr-50"></span>
		<div>
			<form action="./BlackJackResult" method="get">
				<button class="button" type="submit">STAND</button>
			</form>
		</div>
	</div>
	</main>
	<jsp:include page="include/footer.jsp"/>
</div>
</body>
</html>