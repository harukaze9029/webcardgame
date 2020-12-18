<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="handback">
	<c:forEach var="dealer" items="${dealer}">
		<img src="card/card_${dealer.suit}_${dealer.rank}.png" class="card"/>
	</c:forEach>
</div>