<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ポーカー</title>
		<link rel="stylesheet" href="css/Style.css">
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
		<script type="text/javascript" src="css/from.js"></script>
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
								<label>
									<input type="checkbox" name="checkbox" value="0" class="location_checkbox">
									<img src="card/card_${player[0].suit}_${player[0].rank}.png" class="card"/>
								</label>
								<label>
									<input type="checkbox" name="checkbox" value="1" class="location_checkbox">
									<img src="card/card_${player[1].suit}_${player[1].rank}.png" class="card"/>
								</label>
								<label>
									<input type="checkbox" name="checkbox" value="2" class="location_checkbox">
									<img src="card/card_${player[2].suit}_${player[2].rank}.png" class="card"/>
								</label>
								<label>
									<input type="checkbox" name="checkbox" value="3" class="location_checkbox">
									<img src="card/card_${player[3].suit}_${player[3].rank}.png" class="card"/>
								</label>
								<label>
									<input type="checkbox" name="checkbox" value="4" class="location_checkbox">
									<img src="card/card_${player[4].suit}_${player[4].rank}.png" class="card"/>
								</label>
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