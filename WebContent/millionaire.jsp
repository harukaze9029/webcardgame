<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
/*
int order = (int) session.getAttribute("order");
if(order == 2 || order == 3 || order == 4){
	response.sendRedirect("./MillionairePlay");
}
*/
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>大富豪</title>
	<link rel="stylesheet" href="css/Style.css">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="js/form.js"></script>
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
</head>
<body>
<div class="mill">
<main>
<div class="and3">
	<div>
		<p class="conut">${count}人目</p><br>
		<p>${pass}人がパスしました。</p>
	</div>
	<div class="handback1">
	<c:if test="${com1.size() != 0}">
		<img src="card/card_back.png" class="scard"/>
		</c:if>
		<p>手札：${com1.size()}枚</p>
	</div>
	<div>
		<form action="./MillionairePlay" method="get">
			<input type="submit" value="Next" class="btn03">
		</form><br>
		<p>
		<c:if test="${order == 3}">com1さんの番</c:if>
		<c:if test="${order == 2}">com2さんの番</c:if>
		<c:if test="${order == 4}">com3さんの番</c:if>
		<c:if test="${order == 1}">あなたの番</c:if>
		</p>
		<br><br>
		<p>
		<c:if test="${playernum < 4}">1位：${ranking.get(0)}<br></c:if>
		<c:if test="${playernum < 3}">2位：${ranking.get(1)}<br></c:if>
		</p>
	</div>
</div>
<div class="and3">
	<div class="handback2">
	<c:if test="${com2.size() != 0}">
		<img src="card/card_back.png" class="scard"/>
		</c:if>
		<p>手札：${com2.size()}枚</p>
	</div>
	<div class="field">
		<c:if test="${gabage != null}">
		<c:forEach var="gabage" items="${gabage}">
			<img src="card/card_${gabage.suit}_${gabage.rank}.png" class="million"/>
		</c:forEach>
		</c:if>
		<c:if test="${gabage == null && order != 5}">
			<img src="card/card_back.png" class="million"/>
		</c:if>
		<c:if test="${order == 5}">
			<div class="container">
				<form action="./MillionairePlay" method="get">
					<button class="btn-open">GAME START</button>
				</form>
			</div>
		</c:if>
	</div>
	<div class="handback3">
		<p>手札：${com3.size()}枚</p>
		<c:if test="${com3.size() != 0}">
		<img src="card/card_back.png" class="scard"/>
		</c:if>
	</div>
</div>

<div class="handback4">
<p>手札：${player.size()}枚</p>
	<c:choose>
		<c:when test="${order == 1 && player.size() != 0}">
			<form action="./MillionairePlay" method="post">
				<table>
					<tbody>
						<tr>
							<td class="taste">
							<div>
							<c:forEach begin="0" end="${player.size() - 1}" step="1" varStatus="i">
								<label>
									<input type="checkbox" name="checkbox" value="${i.index}" class="location_checkbox">
									<img src="card/card_${player[i.index].suit}_${player[i.index].rank}.png" class="million"/>
								</label>
							</c:forEach>
							</div>
							</td>
						</tr>
					</tbody>
				</table>
				<input type="submit" value="Play a card" id="btn1" class="btn03">
			</form>
		</c:when>
		<c:otherwise>
			<c:forEach var="player" items="${player}">
				<img src="card/card_${player.suit}_${player.rank}.png" class="million"/>
			</c:forEach>
		</c:otherwise>
		</c:choose>
</div>
</main>
<jsp:include page="include/footer.jsp"/>
</div>
</body>
</html>