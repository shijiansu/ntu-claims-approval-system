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
<title>View Department</title>
</head>
<body>
 <jsp:include page="/pages/common/navigation.jsp" />
 <div class="container-fluid">
  <div class="row">
   <jsp:include page="/pages/common/menu.jsp" />
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Title Section [Start] --%>
    <h3 class="page-header">View Department</h3>
    <%-- Title Section [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- View Department [Start] --%>
    <div class="col-lg-6">
     <div class="well">
      <c:set var="item" scope="page" value="${requestScope.department}"></c:set>
      <form class="bs-example form-horizontal">
       <fieldset>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputDepartmentName"><s:text name="department.field.departmentname" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputDepartmentName" class="form-control" value="${item.departmentName}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectOperationArea"><s:text name="department.field.operationarea" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="selectOperationArea" class="form-control"
           value="<c:if test='${not empty item.operationArea}'>${item.operationArea.areaName}${item.operationArea.isFinancial eq 'Y' ? '&nbsp;(is Financial:&nbsp;Yes)' : '&nbsp;(is Financial:&nbsp;No)'}</c:if>"
          >
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectRegion"><s:text name="department.field.region" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="selectRegion" class="form-control" value="<c:if test='${not empty item.region}'>${item.region.regionName}</c:if>">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputTelephoneNumber"><s:text name="department.field.telephonenumber" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputTelephoneNumber" class="form-control" value="${item.telephoneNumber}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputOfficeAddress"><s:text name="department.field.officeaddress" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputOfficeAddress" class="form-control" value="${item.officeAddress}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectManager"><s:text name="department.field.manager" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="selectManager" class="form-control" value="<c:if test='${not empty item.manager}'>${item.manager.firstName}&nbsp;${item.manager.lastName}</c:if>">
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
       </fieldset>
      </form>
     </div>
    </div>
    <div class="col-lg-6"></div>
    <%-- View Department [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- User List [Start] --%>
    <div class="col-lg-12">
     <!-- user list part -->
     <h4 class="sub-header"><s:text name="user.title.list" /></h4>
     <div class="table-responsive">
      <display:table name="userList" id="userItem" class="table table-striped its" defaultsort="1" defaultorder="descending">
       <display:column property="id" title="Id"></display:column>
       <display:column title="User Name">
        <c:url var="userViewUril" value="user_Get_View.do" scope="page">
         <c:param name="inputUserId" value="${userItem.id}"></c:param>
        </c:url>
        <a href="${userViewUril}">${userItem.userName}</a>
       </display:column>
       <display:column property="firstName" title="First Name"></display:column>
       <display:column property="lastName" title="Last Name"></display:column>
       <display:column property="gender" title="Gender"></display:column>
       <display:column property="birthDate" title="Birth Date" format="{0, date,yyyy-MMM-dd}"></display:column>
       <display:column property="emailAddr" title="Email Address" autolink="true"></display:column>
       <display:column property="isAdmin" title="is Administrator"></display:column>
       <display:column property="createBy" title="Create By"></display:column>
       <display:column property="createTime" title="Create Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
       <display:column property="updateBy" title="Update By"></display:column>
       <display:column property="updateTime" title="Update Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      </display:table>
     </div>
    </div>
    <%-- User List [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
   </div>
  </div>
 </div>
 <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
 <jsp:include page="/pages/common/foot_scipt.jsp" />
</body>
</html>
