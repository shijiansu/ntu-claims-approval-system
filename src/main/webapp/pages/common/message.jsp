<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty requestScope.errors}">
 <h3>
  <span class="label label-danger"> <c:forEach var="error" items="${requestScope.errors}">
   ${error.value}
   </c:forEach>
  </span>
 </h3>
</c:if>
<c:if test="${not empty requestScope.messages}">
 <h3>
  <span class="label label-success"> <c:forEach var="msg" items="${requestScope.messages}">
   ${msg.value}
   </c:forEach>
  </span>
 </h3>
</c:if>
