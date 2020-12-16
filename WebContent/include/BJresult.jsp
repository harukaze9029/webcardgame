<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${win + lose + drow > 0}">
<div class="resultback">
<div>
	<H3>
	<span class="mgr-20">${win + lose + drow}battles</span>
	<c:if test="${win > 0}">${win}wins</c:if><c:if test="${result == 'win'}">(+1)</c:if>
	<c:if test="${lose > 0}"> ${lose}losses</c:if><c:if test="${result == 'lose'}">(+1)</c:if>
	<c:if test="${drow > 0}"> ${drow}drows</c:if><c:if test="${result == 'drow'}">(+1)</c:if>
	</H3>
</div>
<div>
	<c:if test="${battle.win > 0}">Win rate  ${rate}  %</c:if>
</div>
</div>
</c:if>