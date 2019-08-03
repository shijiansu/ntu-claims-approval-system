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
<title><s:text name="claimform.title.edit" /></title>
</head>
<body>
 <jsp:include page="/pages/common/navigation.jsp" />
 <div class="container-fluid">
  <div class="row">
   <jsp:include page="/pages/common/menu.jsp" />
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Title Section [Start] --%>
    <h3 class="page-header"><s:text name="claimform.title.edit" /></h3>
    <%-- Title Section [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Edit Claim Form [Start] --%>
    <div class="col-lg-6">
     <div class="well">
      <c:set var="item" scope="page" value="${requestScope.claimForm}"></c:set>
      <form class="bs-example form-horizontal" action="${pageContext.request.contextPath}/claimForm_Post_Edit.do" method="post" name="claimForm_form">
       <input type="hidden" name="inputClaimFormId" value="${item.id}">
       <fieldset>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectYear"><s:text name="claimform.field.year" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputTotal" class="form-control" value="${item.travelOfYear}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectMonth"><s:text name="claimform.field.month" /></label>
         <div class="col-lg-8">
          <c:forEach var="month" items="${requestScope.months}">
           <c:if test="${month.key eq item.travelOfMonth}">
            <input readonly type="text" id="selectMonth" class="form-control" value="${month.value}">
           </c:if>
          </c:forEach>
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputTotal"><s:text name="claimform.field.total" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputTotal" class="form-control" value="${item.total}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectFormStatus"><s:text name="claimform.field.status" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="selectFormStatus" class="form-control" value="${item.formStatus.formStatus}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputDepartment"><s:text name="department.field.department" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputDepartment" class="form-control" value="${item.department.departmentName}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputRequestedBy"><s:text name="claimform.field.requestby" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputRequestedBy" class="form-control" value="${item.user.firstName}&nbsp;${item.user.lastName}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputCreateBy"><s:text name="page.field.createby" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputCreateBy" class="form-control" value="${item.createBy}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputCreateTime"><s:text name="page.field.createtime" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputCreateTime" class="form-control" value="<fmt:formatDate pattern='yyyy-MMM-dd HH:mm:ss' value='${item.createTime}' />">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputUpdateBy"><s:text name="page.field.updateby" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputUpdateBy" class="form-control" value="${item.updateBy}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputUpdateTime"><s:text name="page.field.updatetime" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputUpdateTime" class="form-control" value="<fmt:formatDate pattern='yyyy-MMM-dd HH:mm:ss' value='${item.updateTime}' />">
         </div>
        </div>
        <div class="form-group">
         <div class="col-lg-8 col-lg-offset-4">
          <button type="submit" class="btn btn-primary"><s:text name="page.button.submittoapproval" /></button>
         </div>
        </div>
       </fieldset>
      </form>
     </div>
    </div>
    <div class="col-lg-6"></div>
    <%-- Edit Claim Form [Start] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Claim Form Item List [Start] --%>
    <div class="col-lg-12">
     <h4 class="sub-header"><s:text name="claimform.title.item.list" /></h4>
     <div class="table-responsive">
      <display:table name="claimFormItemList" id="claimFormItem" class="table table-striped its" defaultsort="1" defaultorder="descending">
       <display:column property="id" title="Id"></display:column>
       <display:column property="claimDate" title="Claim Date" format="{0, date,yyyy-MMM-dd}" href="${pageContext.request.contextPath}/claimForm_Get_ViewItem.do" paramId="inputClaimFormItemId" paramProperty="id"></display:column>
       <display:column property="claimType.claimType" title="Claim Type"></display:column>
       <display:column property="claimDescription" title="Claim Description" maxLength="20"></display:column>
       <display:column property="claimAmount" title="Claim Amount"></display:column>
       <display:column property="createBy" title="Create By"></display:column>
       <display:column property="createTime" title="Create Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
       <display:column property="updateBy" title="Update By"></display:column>
       <display:column property="updateTime" title="Update Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
       <display:column media="html" title="Action">
        <c:url var="claimFormItemEditUril" value="claimForm_Get_EditItem.do" scope="page">
         <c:param name="inputClaimFormItemId" value="${claimFormItem.id}"></c:param>
         <c:param name="inputClaimFormId" value="${item.id}"></c:param>
        </c:url>
        <c:url var="claimFormItemDeleteUril" value="claimForm_Get_DeleteItem.do" scope="page">
         <c:param name="inputClaimFormItemId" value="${claimFormItem.id}"></c:param>
         <c:param name="inputClaimFormId" value="${item.id}"></c:param>
        </c:url>
        <a href="${claimFormItemEditUril}"><s:text name="page.button.edit" /></a>
        |
        <a href="${claimFormItemDeleteUril}"
         onclick="return confirm('Do you want to remove item: <fmt:formatDate pattern='yyyy-MMM-dd' value='${claimFormItem.claimDate}'/> ${claimFormItem.claimType.claimType} (id=${claimFormItem.id}) from this claim form ?');"
        >Remove</a>
       </display:column>
      </display:table>
     </div>
     <div class="row placeholders">
      <form action="${pageContext.request.contextPath}/claimForm_Get_CreateItem.do" method="get">
       <div class="col-lg-3 col-lg-offset-7"></div>
       <div class="col-lg-2">
        <span class="pull-right"> <input type="hidden" name="inputClaimFormId" value="${item.id}">
         <button type="submit" class="btn btn-primary">Create New Claim Form Item</button>
        </span>
       </div>
      </form>
     </div>
    </div>
    <%-- Claim Form Item List [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
   </div>
  </div>
 </div>
 <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
 <jsp:include page="/pages/common/foot_scipt.jsp" />
</body>
</html>
