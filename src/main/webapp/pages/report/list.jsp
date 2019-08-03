<!-- #-------------------------------------------------------------------------------
# Copyright (c) 2014, Shijian Su. All rights reserved.
# 
# This software is the confidential and proprietary information of Shijian Su. ("Confidential Information").  You shall not
# disclose such Confidential Information and shall use it only in
# accordance with the terms of the license agreement you entered into
# with him.
#------------------------------------------------------------------------------- -->
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
<title>Report</title>
</head>
<body>
 <jsp:include page="/pages/common/navigation.jsp" />
 <div class="container-fluid">
  <div class="row">
   <jsp:include page="/pages/common/menu.jsp" />
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Title Section [Start] --%>
    <h3 class="page-header"><s:text name="report.title.report" /></h3>
    <%-- Title Section [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Report List [Start] --%>
    <h4 class="sub-header"><s:text name="report.title.list" /></h4>
    <c:set var="item" scope="page" value="${requestScope.user}"></c:set>
    <c:forEach items="${requestScope.reports}" var="report">
     <div class="col-lg-12">
      <p class="lead">
       <!-- report[0] is report id, report[1] is report name -->
       <span class="pull-left">${report[0]}.&nbsp;<a href="${pageContext.request.contextPath}/report_Get_Edit.do?inputReportId=${report[0]}">${report[1]}</a>
       </span>
      </p>
     </div>
    </c:forEach>
    <%-- Report List [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
   </div>
  </div>
 </div>
 <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
 <jsp:include page="/pages/common/foot_scipt.jsp" />
</body>
</html>
