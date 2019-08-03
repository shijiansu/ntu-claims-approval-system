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
<title><s:text name="report.title.report2" /></title>
</head>
<body>
 <jsp:include page="/pages/common/navigation.jsp" />
 <div class="container-fluid">
  <div class="row">
   <jsp:include page="/pages/common/menu.jsp" />
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Title Section [Start] --%>
    <h3 class="page-header"><s:text name="report.title.report2" /></h3>
    <%-- Title Section [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Parameters [Start] --%>
    <div class="col-lg-6">
     <jsp:include page="/pages/common/message.jsp" />
     <div class="well">
      <c:set var="report" scope="page" value="${requestScope.report}"></c:set>
      <form class="bs-example form-horizontal" action="${pageContext.request.contextPath}/report_Post_Edit2.do" method="post" name="report_form" id="report_form">
       <input type="hidden" name="inputReportId" value="${report.id}">
       <fieldset>
        <%-- only financial user can select all user, otherwise only yourself --%>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectUser"><s:text name="user.field.user" /></label>
         <div class="col-lg-8">
          <c:choose>
           <c:when test="${not sessionScope.user.isFinancial}">
            <input id="selectUser" type="hidden" value="${sessionScope.user.id}" name="selectUser">
            <select disabled id="selectUserReadOnly" name="selectUserReadOnly" class="form-control">
             <option value="${sessionScope.user.id}">${sessionScope.user.firstName}&nbsp;${sessionScope.user.lastName}</option>
            </select>
           </c:when>
           <c:otherwise>
            <select id="selectUser" name="selectUser" class="form-control">
             <option value="">All</option>
             <c:forEach var="user" items="${requestScope.users}">
              <option value="${user.id}" ${report.reportParams[0] eq user.id ? 'selected' : '' }>${user.firstName}&nbsp;${user.lastName}</option>
             </c:forEach>
            </select>
           </c:otherwise>
          </c:choose>
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectYear"><s:text name="claimform.field.year" /></label>
         <div class="col-lg-8">
          <select id="selectYear" name="selectYear" class="form-control">
           <option value="">All</option>
           <c:forEach var="year" items="${requestScope.years}">
            <option value="${year}" ${report.reportParams[1] eq year ? 'selected' : '' }>${year}</option>
           </c:forEach>
          </select>
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectMonth"><s:text name="claimform.field.month" /></label>
         <div class="col-lg-8">
          <select id="selectMonth" name="selectMonth" class="form-control">
           <option value="">All</option>
           <c:forEach var="month" items="${requestScope.months}">
            <option value="${month.key}" ${report.reportParams[2] eq month.key ? 'selected' : '' }>${month.value}</option>
           </c:forEach>
          </select>
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectFormStatus"><s:text name="claimform.field.status" /></label>
         <div class="col-lg-8">
          <select id="selectFormStatus" name="selectFormStatus" class="form-control">
           <option value="">All</option>
           <c:forEach var="formStatus" items="${requestScope.formStatuses}">
            <option value="${formStatus.id}" ${report.reportParams[3] eq formStatus.id ? 'selected' : '' }>${formStatus.formStatus}</option>
           </c:forEach>
          </select>
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectReportType"><s:text name="report.field.reporttype" /></label>
         <div class="col-lg-8">
          <select id="selectReportType" name="selectReportType" class="form-control">
           <option value="S" ${report.reportType eq 'S' ? 'selected' : ''}>Simple</option>
           <option value="C" ${report.reportType eq 'C' ? 'selected' : ''}>Complex</option>
          </select>
         </div>
        </div>
        <div class="form-group">
         <div class="col-lg-8 col-lg-offset-4">
          <button type="reset" class="btn btn-default"><s:text name="page.button.reset" /></button>
          <button type="button" class="btn btn-primary" onclick="$('#report_form').attr('action',' ${pageContext.request.contextPath}/report_Post_Edit2.do');$('#report_form').submit()"><s:text name="page.button.showreport" /></button>
          <button type="button" class="btn btn-primary" onclick="$('#report_form').attr('action',' ${pageContext.request.contextPath}/report_Post_Download.do');$('#report_form').submit()"><s:text name="page.button.download" /></button>
         </div>
        </div>
       </fieldset>
      </form>
     </div>
    </div>
    <div class="col-lg-6"></div>
    <%-- Parameters [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Result [Start] --%>
    <c:if test="${not empty report.content}">
     <div class="col-lg-12">
      <div class="table-responsive">
       <display:table name="report.content" id="item" class="table table-striped simple nocol" decorator="myDecorator">
        <display:caption media="html">
         <strong>${report.reportName}</strong>
         <br>(<fmt:formatDate pattern='yyyy-MMM-dd HH:mm:ss' value='${report.generateTime}' />)
        </display:caption>
        <display:column property="year" title="Year" group="1"></display:column>
        <display:column title="Month" group="2">${requestScope.months[item.month]}</display:column>
        <display:column property="department" title="Department" group="3"></display:column>
        <display:column property="status" title="Status" group="4"></display:column>
        <display:column property="user" title="Requset By"></display:column>
        <display:column property="manager" title="By Manager"></display:column>
        <display:column property="managerApprovalTime" title="Approval Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
        <display:column property="financial" title="By Financial"></display:column>
        <display:column property="financialApprovalTime" title="Approval Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
        <display:column property="id" title="Id"></display:column>
        <display:column property="total" title="Total" format="{0, number,0.00}"></display:column>
        <display:column property="createTime" title="Create Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
        <display:column property="updateTime" title="Update Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
        <display:column property="itemFormType" title="Type" format="{0, number,0}"></display:column>
        <display:column property="itemCliamDate" title="Claim Date" format="{0, date,yyyy-MMM-dd}"></display:column>
        <display:column property="itemDescription" title="Description"></display:column>
        <display:column property="itemAmout" title="Amount" format="{0, number,0.00}" headerClass="r" class="r" total="true"></display:column>
       </display:table>
      </div>
     </div>
    </c:if>
    <%-- Result [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
   </div>
  </div>
 </div>
 <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
 <jsp:include page="/pages/common/foot_scipt.jsp" />
</body>
</html>
