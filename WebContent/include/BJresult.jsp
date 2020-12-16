<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<h2>Record</h2>
</div>
<div>
	<H3>
		<span class="mgr-20">${win + lose + drow}battles</span>
		<c:if test="${win > 0}">${win}wins</c:if>
		<c:if test="${lose > 0}"> ${lose}losses</c:if>
		<c:if test="${drow > 0}"> ${drow}drows</c:if>
	</H3>
</div>
<div>
	<c:if test="${battle.win > 0}">Win rate  ${rate}  %</c:if>
</div>