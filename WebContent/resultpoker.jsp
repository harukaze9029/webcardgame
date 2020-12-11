<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ポーカー</title>
		<link rel="stylesheet" href="css/Style.css">
	</head>
	<body >
	<div class="hand">
		<div>
			<p class="example2">親の手札</p>
			<h1>${computerhand}</h1>
			<c:forEach var="computer" items="${computer}">
				<img src="card/card_${computer.suit}_${computer.rank}.png" class="card"/>
			</c:forEach>
			<br>
		</div>
		<div>
			<p class="example2">あなたの手札</p>
			<h1>${playerhand}</h1>
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
				<form action="/WebCardGame/Poker" method="get">
					<button type="submit" style="WIDTH: 200px; HEIGHT: 40px">ANOTHER BATTLE</button>
				</form>
			</div>
			<div>
				<form action="Start.jsp" method="POST">
					<button type="submit" style="WIDTH: 200px; HEIGHT: 40px">BACK TITLE</button>
				</form>
			</div>
		</div>
		<div>
		<h2>戦績<span class="mgr-50"></span>
			${wincn + losecn + drowcn}戦
			<c:if test="${wincn > 0}">${wincn}勝</c:if><c:if test="${result == 'win'}">(+1)</c:if>
			<c:if test="${losecn > 0}">${losecn}敗</c:if><c:if test="${result == 'lose'}">(+1)</c:if>
			<c:if test="${drowcn > 0}">${drowcn}分</c:if><c:if test="${result == 'drow'}">(+1)</c:if>
		</h2>
		</div>
		<div>
		勝率  ${ratep}  %
		</div>
	</body>
</html>