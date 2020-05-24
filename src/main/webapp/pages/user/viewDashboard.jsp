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
<title><s:text name="dashboard.title.dashboard" /></title>
</head>
<body>
 <jsp:include page="/pages/common/navigation.jsp" />
 <div class="container-fluid">
  <div class="row">
   <jsp:include page="/pages/common/menu.jsp" />
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Title Section [Start] --%>
    <h3 class="page-header"><s:text name="dashboard.title.dashboard" /></h3>
    <%-- Title Section [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Chart [Start] --%>
    <div class="table-responsive">
      <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
    </div>
     <%-- Chart [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Current User [Start] --%>
    <div class="col-lg-6">
     <h4 class="sub-header"><s:text name="dashboard.title.currentuser" /></h4>
     <div class="table-responsive">
      <display:table name="userList" id="item" class="table table-striped its">
       <display:column property="id" title="Id"></display:column>
       <display:column property="userName" title="User Name" href="${pageContext.request.contextPath}/user_Get_View.do" paramId="inputUserId" paramProperty="id"></display:column>
       <display:column property="firstName" title="First Name"></display:column>
       <display:column property="lastName" title="Last Name"></display:column>
       <%-- <display:column property="gender" title="Gender"></display:column> --%>
       <%-- <display:column property="birthDate" title="Birth Date" format="{0, date,yyyy-MMM-dd}"></display:column> --%>
       <display:column property="emailAddr" title="Email Address" autolink="true"></display:column>
       <display:column property="isAdmin" title="is Administrator"></display:column>
       <%-- <display:column property="department.departmentName" title="Department"></display:column> --%>
       <%-- <display:column property="createBy" title="Create By"></display:column> --%>
       <%-- <display:column property="createTime" title="Create Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column> --%>
       <%-- <display:column property="updateBy" title="Update By"></display:column> --%>
       <%-- <display:column property="updateTime" title="Update Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column> --%>
      </display:table>
     </div>
    </div>
    <%-- Current User [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Current Department [Start] --%>
    <div class="col-lg-6">
     <h4 class="sub-header"><s:text name="dashboard.title.currentdepartment" /></h4>
     <div class="table-responsive">
      <display:table name="departmentList" id="item2" class="table table-striped its" defaultsort="1" defaultorder="descending">
       <display:column property="id" title="Id"></display:column>
       <display:column property="departmentName" title="Department Name" href="${pageContext.request.contextPath}/department_Get_View.do" paramId="inputDepartmentId" paramProperty="id"></display:column>
       <display:column property="operationArea.areaName" title="Operation Area"></display:column>
       <display:column property="region.regionName" title="Region"></display:column>
       <display:column property="telephoneNumber" title="Telephone Number"></display:column>
       <display:column title="Manager">
        <c:if test="${not empty item2.manager}">
       ${item2.manager.firstName}&nbsp;${item2.manager.lastName}
       </c:if>
       </display:column>
       <%-- <display:column property="createBy" title="Create By"></display:column> --%>
       <%-- <display:column property="createTime" title="Create Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column> --%>
       <%-- <display:column property="updateBy" title="Update By"></display:column> --%>
       <%-- <display:column property="updateTime" title="Update Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column> --%>
      </display:table>
     </div>
    </div>
    <%-- Current Department [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Claim Form Pending Approval [Start] --%>
    <div class="col-lg-12">
     <h4 class="sub-header"><s:text name="dashboard.title.claimform.pending" /></h4>
     <div class="table-responsive">
      <display:table name="claimFormPendingList" requestURI="${pageContext.request.contextPath}/user_Get_ViewDashboard.do" pagesize="3" id="item3" class="table table-striped its" defaultsort="9" defaultorder="descending">
       <display:column property="id" sortable="true" headerClass="sortable" title="Id"></display:column>
       <display:column sortable="true" headerClass="sortable" title="Yeat-Month" href="${pageContext.request.contextPath}/claimForm_Get_View.do" paramId="inputClaimFormId" paramProperty="id">
        ${item3.travelOfYear}-${requestScope.months[item3.travelOfMonth]}
       </display:column>
       <display:column property="total" sortable="true" headerClass="sortable" title="Total"></display:column>
       <display:column property="formStatus.formStatus" sortable="true" headerClass="sortable" title="Status"></display:column>
       <display:column property="department.departmentName" sortable="true" headerClass="sortable" title="Department"></display:column>
       <display:column sortable="true" headerClass="sortable" title="By Manager">
        <c:if test="${not empty item3.approvedByManager}">
        ${item3.approvedByManager.firstName}&nbsp;${item3.approvedByManager.lastName}
       </c:if>
       </display:column>
       <display:column property="approvedByManagerTime" sortable="true" headerClass="sortable" title="Approval Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
       <display:column property="createTime" sortable="true" headerClass="sortable" title="Create Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
       <display:column property="updateTime" sortable="true" headerClass="sortable" title="Update Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      </display:table>
     </div>
    </div>
    <%-- Claim Form Pending Approval [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Claim Form For Your Approval [Start] --%>
    <c:if test="${sessionScope.user.isApprover}">
     <div class="col-lg-12">
      <h4 class="sub-header"><s:text name="dashboard.title.claimform.fya" /></h4>
      <div class="table-responsive">
       <display:table name="claimFormForYourApprovalList" requestURI="${pageContext.request.contextPath}/user_Get_ViewDashboard.do" pagesize="3" id="item4" class="table table-striped its" defaultsort="10" defaultorder="descending">
        <display:column property="id" sortable="true" headerClass="sortable" title="Id"></display:column>
        <display:column sortable="true" headerClass="sortable" title="Yeat-Month" href="${pageContext.request.contextPath}/claimForm_Get_View.do" paramId="inputClaimFormId" paramProperty="id">
         ${item4.travelOfYear}-${requestScope.months[item4.travelOfMonth]}
        </display:column>
        <display:column property="total" sortable="true" headerClass="sortable" title="Total"></display:column>
        <display:column property="formStatus.formStatus" sortable="true" headerClass="sortable" title="Status"></display:column>
        <display:column property="department.departmentName" sortable="true" headerClass="sortable" title="Department"></display:column>
        <display:column sortable="true" headerClass="sortable" title="Request By">
         <c:if test="${not empty item4.user}">
         ${item4.user.firstName}&nbsp;${item4.user.lastName}
        </c:if>
        </display:column>
        <display:column sortable="true" headerClass="sortable" title="By Manager">
         <c:if test="${not empty item4.approvedByManager}">
         ${item4.approvedByManager.firstName}&nbsp;${item4.approvedByManager.lastName}
        </c:if>
        </display:column>
        <display:column property="approvedByManagerTime" sortable="true" headerClass="sortable" title="Approval Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
        <display:column property="createTime" sortable="true" headerClass="sortable" title="Create Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
        <display:column property="updateTime" sortable="true" headerClass="sortable" title="Update Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
        <display:column media="html" title="Action">
         <c:choose>
          <c:when test="${item4.formStatus.id eq 2}">
           <a href="${pageContext.request.contextPath}/claimForm_Get_DepartmentApprove.do?inputClaimFormId=${item4.id}"><s:text name="page.button.approval.department" /></a>
           |
           <a href="${pageContext.request.contextPath}/claimForm_Get_Reject.do?inputClaimFormId=${item4.id}"><s:text name="page.button.approval.reject" /></a>
          </c:when>
          <c:when test="${item4.formStatus.id eq 3}">
           <a href="${pageContext.request.contextPath}/claimForm_Get_FinancialApprove.do?inputClaimFormId=${item4.id}"><s:text name="page.button.approval.financial" /></a>
           |
           <a href="${pageContext.request.contextPath}/claimForm_Get_Reject.do?inputClaimFormId=${item4.id}"><s:text name="page.button.approval.reject" /></a>
          </c:when>
         </c:choose>
        </display:column>
       </display:table>
      </div>
     </div>
    </c:if>
    <%-- Claim Form For Your Approval [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
   </div>
  </div>
 </div>
 <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
 <jsp:include page="/pages/common/foot_scipt.jsp" />
 <jsp:include page="/pages/common/chart.jsp" />
</body>
</html>
