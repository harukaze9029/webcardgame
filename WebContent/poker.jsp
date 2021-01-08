<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Poker</title>
	<link rel="stylesheet" href="css/Style.css">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="js/form.js"></script>
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
</head>
<body>
  <div id="wrapper">
	<main>
	<div class="hand">
		<div>
			<p class="example2">DEALER HAND</p>
			<br>
			<div class="handback">
			<c:forEach var="i" begin="1" end="5" step="1">
				<img src="card/card_back.png" class="scard"/>
			</c:forEach>
			</div>
		</div>
		<div class="mod_form">
			<p class="example2">PLAYER HAND</p>
			<form action="./Poker" method="post">
				<table>
					<tbody>
						<tr>
							<td class="taste">
							<div class="handback">
							<c:forEach begin="0" end="4" step="1" varStatus="i">
								<label>
									<input type="checkbox" name="checkbox" value="${i.index}" class="location_checkbox">
									<img src="card/card_${player[i.index].suit}_${player[i.index].rank}.png" class="scard"/>
								</label>
							</c:forEach>
							</div>
							</td>
						</tr>
					</tbody>
				</table>
				<input type="submit" value="CHANGE" id="btn1" class="btn03">
			</form>
			<br>
			<form action="./PokerResult" method="get">
				<input type="submit" value="STAND" class="btn03">
			</form>
		</div>
	</div>
	</main>
<jsp:include page="include/footer.jsp"/>
</div>
</body>
</html>