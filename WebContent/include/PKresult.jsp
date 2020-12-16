<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${wincn + losecn + drowcn > 0}">
<div class="resultback">
<div>
	<H3>
	<span class="mgr-20">${wincn + losecn + drowcn}battles</span>
	<c:if test="${wincn > 0}">${wincn}wins</c:if><c:if test="${result == 'win'}">(+1)</c:if>
	<c:if test="${losecn > 0}"> ${losecn}losses</c:if><c:if test="${result == 'lose'}">(+1)</c:if>
	<c:if test="${drowcn > 0}"> ${drowcn}drows</c:if><c:if test="${result == 'drow'}">(+1)</c:if>
	</H3>
</div>
<div>
	<c:if test="${count.win > 0}">Win rate  ${ratep}  %</c:if>
</div>
</div>
</c:if>