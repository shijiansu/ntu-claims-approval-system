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
<title><s:text name="claimform.title.maintain" /></title>
</head>
<body>
 <jsp:include page="/pages/common/navigation.jsp" />
 <div class="container-fluid">
  <div class="row">
   <jsp:include page="/pages/common/menu.jsp" />
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Title Section [Start] --%>
    <h3 class="page-header"><s:text name="claimform.title.maintain" /></h3>
    <%-- Title Section [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Maintain Claim Form (Saved) [Start] --%>
    <h4 class="sub-header"><s:text name="claimform.title.list.savedandrejected" /></h4>
    <div class="table-responsive">
     <display:table name="claimFormList1" requestURI="${pageContext.request.contextPath}/claimForm_Get_List.do" pagesize="3" id="item1" class="table table-striped its" defaultsort="9" defaultorder="descending">
      <display:column property="id" sortable="true" headerClass="sortable" title="Id"></display:column>
      <display:column sortable="true" headerClass="sortable" title="Yeat-Month" href="${pageContext.request.contextPath}/claimForm_Get_View.do" paramId="inputClaimFormId" paramProperty="id">
      ${item1.travelOfYear}-${requestScope.months[item1.travelOfMonth]}
      </display:column>
      <display:column property="total" sortable="true" headerClass="sortable" title="Total"></display:column>
      <display:column property="department.departmentName" sortable="true" headerClass="sortable" title="Department"></display:column>
      <display:column sortable="true" headerClass="sortable" title="By Manager">
       <c:if test="${not empty item1.approvedByManager}">
      	${item1.approvedByManager.firstName}&nbsp;${item1.approvedByManager.lastName}
      </c:if>
      </display:column>
      <display:column property="approvedByManagerTime" sortable="true" headerClass="sortable" title="Approval Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column sortable="true" headerClass="sortable" title="Rejected By">
       <c:if test="${not empty item1.rejectBy}">
      	${item1.rejectBy.firstName}&nbsp;${item1.rejectBy.lastName}
      </c:if>
      </display:column>
      <display:column property="rejectTime" sortable="true" headerClass="sortable" title="Reject Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column property="createTime" sortable="true" headerClass="sortable" title="Create Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column property="updateTime" sortable="true" headerClass="sortable" title="Update Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column media="html" title="Action">
       <c:choose>
        <c:when test="${(item1.formStatus.id eq 1) || (item1.formStatus.id eq 5)}">
         <a href="${pageContext.request.contextPath}/claimForm_Get_Edit.do?inputClaimFormId=${item1.id}"><s:text name="page.button.edit" /></a>
         |
         <a href="${pageContext.request.contextPath}/claimForm_Get_Delete.do?inputClaimFormId=${item1.id}"
          onclick="return confirm('Do you want to remove claim form:  ${item1.travelOfYear}-${item1.travelOfMonth} (id=${item1.id}) ?"
         >Remove</a>
         |
         <a href="${pageContext.request.contextPath}/claimForm_Get_Submit.do?inputClaimFormId=${item1.id}"><s:text name="page.button.submit" /></a>
        </c:when>
       </c:choose>
      </display:column>
     </display:table>
    </div>
    <%-- Maintain Claim Form (Saved) [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Maintain Claim Form (Submitted) [Start] --%>
    <h4 class="sub-header"><s:text name="claimform.title.list.submitted" /></h4>
    <div class="table-responsive">
     <display:table name="claimFormList2" requestURI="${pageContext.request.contextPath}/claimForm_Get_List.do" pagesize="3" id="item2" class="table table-striped its" defaultsort="10" defaultorder="descending">
      <display:column property="id" sortable="true" headerClass="sortable" title="Id"></display:column>
      <display:column sortable="true" headerClass="sortable" title="Yeat-Month" href="${pageContext.request.contextPath}/claimForm_Get_View.do" paramId="inputClaimFormId" paramProperty="id">
      ${item2.travelOfYear}-${requestScope.months[item2.travelOfMonth]}
      </display:column>
      <display:column property="total" sortable="true" headerClass="sortable" title="Total"></display:column>
      <display:column property="department.departmentName" sortable="true" headerClass="sortable" title="Department"></display:column>
      <display:column sortable="true" headerClass="sortable" title="By Manager">
       <c:if test="${not empty item2.approvedByManager}">
       ${item2.approvedByManager.firstName}&nbsp;${item2.approvedByManager.lastName}
      </c:if>
      </display:column>
      <display:column property="approvedByManagerTime" sortable="true" headerClass="sortable" title="Approval Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column sortable="true" headerClass="sortable" title="By Financial">
       <c:if test="${not empty item2.approvedByFinancial}">
       ${item2.approvedByFinancial.firstName}&nbsp;${item2.approvedByFinancial.lastName}
      </c:if>
      </display:column>
      <display:column property="approvedByFinancialTime" sortable="true" headerClass="sortable" title="Approval Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column property="createTime" sortable="true" headerClass="sortable" title="Create Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column property="updateTime" sortable="true" headerClass="sortable" title="Update Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
     </display:table>
    </div>
    <%-- Maintain Claim Form (Submitted) [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Maintain Claim Form (Manager Approved) [Start] --%>
    <h4 class="sub-header"><s:text name="claimform.title.list.deptapproved" /></h4>
    <div class="table-responsive">
     <display:table name="claimFormList3" requestURI="${pageContext.request.contextPath}/claimForm_Get_List.do" pagesize="3" id="item3" class="table table-striped its" defaultsort="10" defaultorder="descending">
      <display:column property="id" sortable="true" headerClass="sortable" title="Id"></display:column>
      <display:column sortable="true" headerClass="sortable" title="Yeat-Month" href="${pageContext.request.contextPath}/claimForm_Get_View.do" paramId="inputClaimFormId" paramProperty="id">
      ${item3.travelOfYear}-${requestScope.months[item3.travelOfMonth]}
      </display:column>
      <display:column property="total" sortable="true" headerClass="sortable" title="Total"></display:column>
      <display:column property="department.departmentName" sortable="true" headerClass="sortable" title="Department"></display:column>
      <display:column sortable="true" headerClass="sortable" title="By Manager">
       <c:if test="${not empty item3.approvedByManager}">
       ${item3.approvedByManager.firstName}&nbsp;${item3.approvedByManager.lastName}
      </c:if>
      </display:column>
      <display:column property="approvedByManagerTime" sortable="true" headerClass="sortable" title="Approval Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column sortable="true" headerClass="sortable" title="By Financial">
       <c:if test="${not empty item3.approvedByFinancial}">
       ${item3.approvedByFinancial.firstName}&nbsp;${item3.approvedByFinancial.lastName}
      </c:if>
      </display:column>
      <display:column property="approvedByFinancialTime" sortable="true" headerClass="sortable" title="Approval Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column property="createTime" sortable="true" headerClass="sortable" title="Create Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column property="updateTime" sortable="true" headerClass="sortable" title="Update Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
     </display:table>
    </div>
    <%-- Maintain Claim Form (Manager Approved) [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Maintain Claim Form (Financial Approved) [Start] --%>
    <h4 class="sub-header"><s:text name="claimform.title.list.finapproved" /></h4>
    <div class="table-responsive">
     <display:table name="claimFormList4" requestURI="${pageContext.request.contextPath}/claimForm_Get_List.do" pagesize="3" id="item4" class="table table-striped its" defaultsort="10" defaultorder="descending">
      <display:column property="id" sortable="true" headerClass="sortable" title="Id"></display:column>
      <display:column sortable="true" headerClass="sortable" title="Yeat-Month" href="${pageContext.request.contextPath}/claimForm_Get_View.do" paramId="inputClaimFormId" paramProperty="id">
      ${item4.travelOfYear}-${requestScope.months[item4.travelOfMonth]}
      </display:column>
      <display:column property="total" sortable="true" headerClass="sortable" title="Total"></display:column>
      <display:column property="department.departmentName" sortable="true" headerClass="sortable" title="Department"></display:column>
      <display:column sortable="true" headerClass="sortable" title="By Manager">
       <c:if test="${not empty item4.approvedByManager}">
       ${item4.approvedByManager.firstName}&nbsp;${item4.approvedByManager.lastName}
      </c:if>
      </display:column>
      <display:column property="approvedByManagerTime" sortable="true" headerClass="sortable" title="Approval Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column sortable="true" headerClass="sortable" title="By Financial">
       <c:if test="${not empty item4.approvedByFinancial}">
       ${item4.approvedByFinancial.firstName}&nbsp;${item4.approvedByFinancial.lastName}
      </c:if>
      </display:column>
      <display:column property="approvedByFinancialTime" sortable="true" headerClass="sortable" title="Approval Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column property="createTime" sortable="true" headerClass="sortable" title="Create Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column property="updateTime" sortable="true" headerClass="sortable" title="Update Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
     </display:table>
    </div>
    <%-- Maintain Claim Form (Financial Approved) [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Create New Claim Form [Start] --%>
    <div class="row placeholders">
     <div class="col-lg-2 col-lg-offset-10">
      <form action="${pageContext.request.contextPath}/claimForm_Get_Create.do" method="get">
       <span class="pull-right">
        <button type="submit" class="btn btn-primary"><s:text name="page.button.createclaimform" /></button>
       </span>
      </form>
     </div>
    </div>
    <%-- Create New Claim Form [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Display To Approval Manager and Financial Department Information Section [Start] --%>
    <div class="table-responsive">
     <div class="bs-docs-section">
      <div class="row">
       <div class="col-lg-2">
        <p>
         <span class="pull-left"><abbr title="After you submit the claim form, first will be pending by your department manager to approve">Manager to Approve:</abbr> </span>
        </p>
       </div>
       <div class="col-lg-10">
        <p>
         <span class="pull-left"><c:choose>
           <c:when test="${not empty requestScope.manager}">
            ${requestScope.manager.firstName}&nbsp;${requestScope.manager.lastName}&nbsp;(Email:
            <c:choose>
             <c:when test="${not empty requestScope.manager.emailAddr}">
              <a href="mailto:${requestScope.manager.emailAddr}">${requestScope.manager.emailAddr}</a>
             </c:when>
             <c:otherwise>Not Available</c:otherwise>
            </c:choose>
            )
           </c:when>
           <c:otherwise>
            You haven't been assigned to a department or your department doesn't have manager yet.
           </c:otherwise>
          </c:choose></span>
        </p>
       </div>
       <div class="col-lg-2">
        <p>
         <span class="pull-left"><abbr title="After department manager approved, then will be pending by financial department to approve">Financial to Approve:</abbr></span>
        </p>
       </div>
       <div class="col-lg-10">
        <p>
         <span class="pull-left"><c:choose>
           <c:when test="${not empty requestScope.financialDepartments}">
            ${requestScope.financialDepartments[0].departmentName}&nbsp;(Telepone:&nbsp;${not empty requestScope.financialDepartments[0].telephoneNumber ? requestScope.financialDepartments[0].telephoneNumber : 'Not Available'})
           </c:when>
           <c:otherwise>There is no available financial department yet.
           </c:otherwise>
          </c:choose></span>
        </p>
       </div>
       <c:if test="${not empty requestScope.financialDepartments && fn:length(requestScope.financialDepartments) gt 1}">
        <c:forEach begin="1" items="requestScope.financialDepartments" var="financialDepartment">
         <div class="col-lg-2">
          <p>
           <span class="pull-left"><abbr title="After department manager approved, then will be pending by financial department to approve">Financial to Approve:</abbr></span>
          </p>
         </div>
         <div class="col-lg-10">
          <p>
           <span class="pull-left">${financialDepartment.departmentName}&nbsp;(Telepone:&nbsp;${not empty financialDepartment.telephoneNumber ? financialDepartment.telephoneNumber : 'Not
            Available'})</span>
          </p>
         </div>
        </c:forEach>
       </c:if>
      </div>
     </div>
    </div>
    <%-- Display To Approval Manager and Financial Department Information Section [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
   </div>
  </div>
 </div>
 <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
 <jsp:include page="/pages/common/foot_scipt.jsp" />
</body>
</html>
