<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Suit" %>
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
			<c:forEach var="computer" items="${computer}">
				<img src="card/card_${computer.suit}_${computer.rank}.png" class="card"/>
			</c:forEach>
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
			<c:forEach var="player" items="${player}">
				<img src="card/card_${player.suit}_${player.rank}.png" class="card"/>
			</c:forEach>
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
			<span class="mgr-50"></span>
			<div>
				<form action="index.jsp" method="POST">
					<button type="submit">BACK TITLE</button>
				</form>
			</div>
		</div>
		<div class="resultback">
			<div>
				<h2>Record<span class="mgr-50"></span>
				${win + lose + drow}battles
				<c:if test="${win > 0}">${win}wins</c:if><c:if test="${result == 'win'}">(+1)</c:if>
				<c:if test="${lose > 0}"> ${lose}losses</c:if><c:if test="${result == 'lose'}">(+1)</c:if>
				<c:if test="${drow > 0}"> ${drow}drows</c:if><c:if test="${result == 'drow'}">(+1)</c:if>
				</h2>
			</div>
			<div>Win rate  ${rate}  %</div>
		</div>
	</body>
</html>
