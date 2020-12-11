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
			<h1>Let's play!!</h1>
			<br>
			<div class="result">
				<div>
					<img src="card/BJ.jpg" style="WIDTH: 400px; HEIGHT: 235px" hspace="30">
					<form action="./BlackJack" method="get">
						<button type="submit" style="WIDTH: 200px; HEIGHT: 40px">BRACK JACK</button>
					</form>
					<div>
						<h2>戦績<span class="mgr-50"></span>
						${win + lose + drow}戦<span class="mgr-50"></span>
							<c:if test="${win > 0}">${win}勝</c:if>
							<c:if test="${lose > 0}">${lose}敗</c:if>
							<c:if test="${drow > 0}">${drow}分</c:if>
						</h2>
					</div>
					<div>
						<c:if test="${battle.win > 0}">勝率  ${rate}  %</c:if>
					</div>
				</div>
				<div>
					<img src="card/royal.jpg" style="WIDTH: 400px; HEIGHT: 235px" hspace="30">
					<form action="./Poker" method="get">
						<button type="submit" style="WIDTH: 200px; HEIGHT: 40px">POKER</button>
					</form>
					<div>
						<h2>戦績<span class="mgr-50"></span>
							${wincn + losecn + drowcn}戦<span class="mgr-50"></span>
								<c:if test="${wincn > 0}">${wincn}勝</c:if>
								<c:if test="${losecn > 0}">${losecn}敗</c:if>
									<c:if test="${drowcn > 0}">${drowcn}分</c:if>
						</h2>
					</div>
					<div>
						<c:if test="${count.win > 0}">勝率  ${ratep}  %</c:if>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>