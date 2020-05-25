<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/pages/common/head.jsp" />
<title>Unknown Error</title>
</head>
<body>
 <jsp:include page="/pages/common/navigation.jsp" />
 <div class="container-fluid">
  <div class="row">
   <div class="center">
    <h2>
     <span class="label label-danger"><s:text name="errorpage.title.unknown" /></span>
    </h2>
   </div>
   <div class="center">
    <h4>
     <a href="${pageContext.request.contextPath}"><s:text name="page.field.gohome" /></a>
    </h4>
   </div>
  </div>
 </div>
 <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
 <jsp:include page="/pages/common/foot_script.jsp" />
 <jsp:include page="/pages/common/foot_copyright.jsp" />
</body>
</html>
