<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="handback">
	<c:forEach var="player" items="${player}">
		<img src="card/card_${player.suit}_${player.rank}.png" class="card"/>
	</c:forEach>
</div>