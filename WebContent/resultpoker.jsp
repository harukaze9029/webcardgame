<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Poker</title>
	<link rel="stylesheet" href="css/Style.css">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
</head>
<body>
<div id="wrapper">
	<main>
	<div class="hand">
		<div>
			<p class="example2">DEALER HAND</p>
			<h1>${dealerhand}</h1>
			<div class="handback">
				<c:forEach var="dealer" items="${dealer}">
					<img src="card/card_${dealer.suit}_${dealer.rank}.png" class="scard"/>
				</c:forEach>
			</div>
			<br>
		</div>
		<div>
			<p class="example2">PLAYER HAND</p>
			<h1>${playerhand}</h1>
			<div class="handback">
				<c:forEach var="player" items="${player}">
					<img src="card/card_${player.suit}_${player.rank}.png" class="scard"/>
				</c:forEach>
			</div>
		</div>
	</div>
	<div>
		<p class="${result}">${result}</p>
	</div>
	<div class="result">
		<div>
			<form action="./Poker" method="get">
				<button  class="btn02" type="submit">ANOTHER BATTLE</button>
			</form>
		</div>
	<jsp:include page="include/Back.jsp"/>
	</div>
	<jsp:include page="include/PKresult.jsp"/>
	</main>
	<jsp:include page="include/footer.jsp"/>
</div>
</body>
</html>