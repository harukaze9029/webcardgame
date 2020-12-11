<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ブラックジャック</title>
		<link rel="stylesheet" href="css/Style.css">
	</head>
	<body>
	<div class="hand">
		<div>
			<p class="example2">DEALER HAND</p>
			<h2 class="box1">HOST COUNT ??</h2>
			<img src="card/card_${computer[0].suit}_${computer[0].rank}.png" class="card"/>
			<img src="card/card_back.png" class="card"/>
		</div>
		<div>
			<p class="example2">PLAYER HAND</p>
			<h2 class="box1">YOU COUNT ${youcount}</h2>
			<c:forEach var="player" items="${player}">
				<img src="card/card_${player.suit}_${player.rank}.png" class="card"/>
			</c:forEach>
		</div>
		</div>
		<br>
		<br>
		<div class="result">

			<div>
				<form action="./BlackJack" method="post">
					<button  type="submit">HIT</button>
				</form>
			</div>
			<span class="mgr-50"></span>
			<div>
				<form action="./BlackJackResult" method="get">
					<button type="submit">STAND</button>
				</form>
			</div>
			<span class="mgr-50"></span>
		</div>
	</body>
</html>