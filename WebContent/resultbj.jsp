<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<div>
			<p class="example2">DEALER HAND</p>
			<c:choose>
				<c:when test="${dealercount == -1}">
					<h2 class="box1" id="burst">BURST</h2>
				</c:when>
				<c:when test="${dealercount == 21}">
					<h1 class="box1" id="blackjack">BLACK JACK!!</h1>
				</c:when>
				<c:otherwise>
					<h2 class="box1">COUNT ${dealercount}</h2>
				</c:otherwise>
			</c:choose>
			<jsp:include page="include/dealerhand.jsp"/>
		</div>
		<div>
			<p class="example2">PLAYER HAND</p>
			<c:choose>
				<c:when test="${playercount == -1}">
					<h2 class="box1" id="burst">BURST</h2>
				</c:when>
				<c:when test="${playercount == 21}">
					<h1 class="box1" id="blackjack">BLACK JACK!!</h1>
				</c:when>
				<c:otherwise>
					<h2 class="box1">COUNT ${playercount}</h2>
				</c:otherwise>
			</c:choose>
			<jsp:include page="include/playerhand.jsp"/>
		</div>
	</div>
	<div>
		<p class="${result}">${result}</p>
	</div>
	<div class="result">
		<div>
			<form action="./BlackJack" method="get">
				<button  class="btn02" type="submit">ANOTHER BATTLE</button>
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
