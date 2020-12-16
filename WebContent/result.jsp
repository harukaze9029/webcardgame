<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Brack Jack</title>
	<link rel="stylesheet" href="css/Style.css">
	<meta name=”viewport” content=”width=device-width,initial-scale=1.0″>
</head>
<body>
  <div id="wrapper">
<main>
	<div class="hand">
		<div>
			<p class="example2">DEALER HAND</p>
			<c:choose>
				<c:when test="${comcount == -1}">
					<h2 class="box1">HOST BURST</h2>
				</c:when>
				<c:when test="${comcount == 21}">
					<h1 class="box1">BLACK JACK!!</h1>
				</c:when>
				<c:otherwise>
					<h2 class="box1">HOST COUNT ${comcount}</h2>
				</c:otherwise>
			</c:choose>
			<div class="handback">
			<c:forEach var="computer" items="${computer}">
				<img src="card/card_${computer.suit}_${computer.rank}.png" class="card"/>
			</c:forEach>
			</div>
		</div>
		<div>
			<p class="example2">PLAYER HAND</p>
			<c:choose>
				<c:when test="${youcount == -1}">
					<h2 class="box1">YOU BURST</h2>
				</c:when>
				<c:when test="${youcount == 21}">
					<h1 class="box1">BLACK JACK!!</h1>
				</c:when>
				<c:otherwise>
					<h2 class="box1">YOU COUNT ${youcount}</h2>
				</c:otherwise>
			</c:choose>
			<div class="handback">
			<c:forEach var="player" items="${player}">
				<img src="card/card_${player.suit}_${player.rank}.png" class="card"/>
			</c:forEach>
			</div>
		</div>
	</div>
	<div>
		<h1>${result}</h1>
	</div>
	<div class="result">
		<div>
			<form action="./BlackJack" method="get">
				<button type="submit">ANOTHER BATTLE</button>
			</form>
		</div>
	<jsp:include page="include/Back.jsp"/>
	</div>
	<jsp:include page="include/BJresult.jsp"/>
	</main>
	<jsp:include page="include/footer.jsp"/>
	</div>
</body>
</html>
