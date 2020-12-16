<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Poker</title>
	<link rel="stylesheet" href="css/Style.css">
	<script src="css/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="css/form.js"></script>
</head>
<body>
	<div class="hand">
		<div>
			<p class="example2">DEALER HAND</p>
			<c:forEach var="i" begin="1" end="5" step="1">
				<img src="card/card_back.png" class="card"/>
			</c:forEach>
		</div>
		<div class="mod_form">
			<p class="example2">PLAYER HAND</p>
			<form action="./Poker" method="post">
				<table>
					<tbody>
						<tr>
							<td class="taste">
							<c:forEach begin="0" end="4" step="1" varStatus="i">
								<label>
									<input type="checkbox" name="checkbox" value="${i.index}" class="location_checkbox">
									<img src="card/card_${player[i.index].suit}_${player[i.index].rank}.png" class="card"/>
								</label>
							</c:forEach>
							</td>
						</tr>
					</tbody>
				</table>
				<input type="submit" value="CHANGE" id="btn1" class="btn">
			</form>
			<br>
			<form action="./PokerResult" method="get">
				<input type="submit" value="STAND" class="btn">
			</form>
		</div>
	</div>
</body>
</html>