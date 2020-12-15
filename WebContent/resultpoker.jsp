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
			<form action="./Poker" method="get">
				<button type="submit">ANOTHER BATTLE</button>
			</form>
		</div>
		<div>
			<form action="index.jsp" method="POST">
				<button type="submit">BACK TITLE</button>
			</form>
		</div>
	</div>
	<div class="resultback">
		<div>
		<h2>Record<span class="mgr-50"></span>
			${wincn + losecn + drowcn}battles
			<c:if test="${wincn > 0}">${wincn}wins</c:if><c:if test="${result == 'win'}">(+1)</c:if>
			<c:if test="${losecn > 0}"> ${losecn}losses</c:if><c:if test="${result == 'lose'}">(+1)</c:if>
			<c:if test="${drowcn > 0}"> ${drowcn}drows</c:if><c:if test="${result == 'drow'}">(+1)</c:if>
		</h2>
	</div>
	<div>Win rate  ${ratep}  %</div>
	</div>
</body>
</html>