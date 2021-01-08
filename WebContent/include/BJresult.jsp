<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${winbj + losebj + drowbj > 0}">
<div class="resultback">
<div>
	<H3>
	<span class="mgr-20">${winbj + losebj + drowbj}battles</span>
	<c:if test="${winbj > 0}">${winbj}wins</c:if><c:if test="${result == 'Win'}">(+1)</c:if>
	<c:if test="${losebj > 0}"> ${losebj}losses</c:if><c:if test="${result == 'Lose'}">(+1)</c:if>
	<c:if test="${drawbj > 0}"> ${drawbj}drows</c:if><c:if test="${result == 'Draw'}">(+1)</c:if>
	</H3>
</div>
<div>
	<c:if test="${battle.winbj > 0}">Win rate  ${ratebj}  %</c:if>
</div>
</div>
</c:if>