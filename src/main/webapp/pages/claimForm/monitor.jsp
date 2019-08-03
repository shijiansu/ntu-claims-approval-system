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
<title><s:text name="claimform.title.monitor" /></title>
</head>
<body>
 <jsp:include page="/pages/common/navigation.jsp" />
 <div class="container-fluid">
  <div class="row">
   <jsp:include page="/pages/common/menu.jsp" />
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Title Section [Start] --%>
    <h3 class="page-header"><s:text name="claimform.title.monitor" /></h3>
    <%-- Title Section [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Monitor Claim Form [Start] --%>
    <h4 class="sub-header">Claim Form List (Save)</h4>
    <div class="table-responsive">
     <display:table name="claimFormList" requestURI="${pageContext.request.contextPath}/claimForm_Get_Monitor.do" pagesize="10" id="item" class="table table-striped its" defaultsort="1" defaultorder="descending">
      <display:column property="id" sortable="true" headerClass="sortable" title="Id"></display:column>
      <display:column sortable="true" headerClass="sortable" title="Yeat-Month" href="${pageContext.request.contextPath}/claimForm_Get_View.do" paramId="inputClaimFormId" paramProperty="id">
      ${item.travelOfYear}-${requestScope.months[item.travelOfMonth]}
      </display:column>
      <display:column property="total" sortable="true" headerClass="sortable" title="Total"></display:column>
      <display:column property="formStatus.formStatus" sortable="true" headerClass="sortable" title="Status"></display:column>
      <display:column property="department.departmentName" sortable="true" headerClass="sortable" title="Department"></display:column>
      <display:column sortable="true" headerClass="sortable" title="Request By">
       <c:if test="${not empty item.user}">
        ${item.user.firstName}&nbsp;${item.user.lastName}
       </c:if>
      </display:column>
      <display:column sortable="true" headerClass="sortable" title="By Manager">
       <c:if test="${not empty item.approvedByManager}">
      	${item.approvedByManager.firstName}&nbsp;${item.approvedByManager.lastName}
       </c:if>
      </display:column>
      <display:column property="approvedByManagerTime" sortable="true" headerClass="sortable" title="Approval Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column sortable="true" headerClass="sortable" title="By Financial">
       <c:if test="${not empty item1.approvedByFinancial}">
      	${item.approvedByFinancial.firstName}&nbsp;${item.approvedByFinancial.lastName}
       </c:if>
      </display:column>
      <display:column property="approvedByFinancialTime" sortable="true" headerClass="sortable" title="Approval Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column sortable="true" headerClass="sortable" title="Rejected By">
       <c:if test="${not empty item.rejectBy}">
        ${item.rejectBy.firstName}&nbsp;${item.rejectBy.lastName}
       </c:if>
      </display:column>
      <display:column property="rejectTime" sortable="true" headerClass="sortable" title="Reject Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column property="createTime" sortable="true" headerClass="sortable" title="Create Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column property="updateTime" sortable="true" headerClass="sortable" title="Update Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
     </display:table>
    </div>
    <%-- Monitor Claim Form [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
   </div>
  </div>
 </div>
 <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
 <jsp:include page="/pages/common/foot_scipt.jsp" />
</body>
</html>
