<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>スタート画面</title>
	<link rel="stylesheet" href="css/Style.css">
</head>
<body>
	<div>
		<h1>Good luck to you!</h1>
		<br>
		<div class="result">
			<div>
				<img src="card/BJ.jpg" class="trump">
				<form action="./BlackJack" method="get">
					<button type="submit">BRACK JACK</button>
				</form>
				<div>
					<h2>Record</h2>
				</div>
				<div><H3>
					<span class="mgr-20">${win + lose + drow}battles</span>
					<c:if test="${win > 0}">${win}wins</c:if>
					<c:if test="${lose > 0}"> ${lose}losses</c:if>
					<c:if test="${drow > 0}"> ${drow}drows</c:if>
					</H3>
				</div>
				<div>
					<c:if test="${battle.win > 0}">Win rate  ${rate}  %</c:if>
				</div>
			</div>
			<span class="mgr-50"></span>
			<div>
				<img src="card/royal.jpg" class="trump">
				<form action="./Poker" method="get">
					<button type="submit">POKER</button>
				</form>
				<div>
					<h2>Record</h2>
				</div>
				<div><H3>
					<span class="mgr-20">${wincn + losecn + drowcn}battles</span>
					<c:if test="${wincn > 0}">${wincn}wins</c:if>
					<c:if test="${losecn > 0}"> ${losecn}losses</c:if>
					<c:if test="${drowcn > 0}"> ${drowcn}drows</c:if>
					</H3>
				</div>
				<div>
					<c:if test="${count.win > 0}">Win rate  ${ratep}  %</c:if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>