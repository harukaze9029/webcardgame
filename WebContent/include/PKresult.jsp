<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${winpo + losepo + drowpo > 0}">
<div class="resultback">
<div>
	<H3>
	<span class="mgr-20">${winpo + losepo + drowpo}battles</span>
	<c:if test="${winpo > 0}">${winpo}wins</c:if><c:if test="${result == 'Win'}">(+1)</c:if>
	<c:if test="${losepo > 0}"> ${losepo}losses</c:if><c:if test="${result == 'Lose'}">(+1)</c:if>
	<c:if test="${drawpo > 0}"> ${drawpo}drows</c:if><c:if test="${result == 'Draw'}">(+1)</c:if>
	</H3>
</div>
<div>
	<c:if test="${count.winpo > 0}">Win rate  ${ratepo}  %</c:if>
</div>
</div>
</c:if>