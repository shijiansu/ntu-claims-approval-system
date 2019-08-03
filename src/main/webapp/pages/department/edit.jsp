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
<title>Edit Department</title>
</head>
<body>
 <jsp:include page="/pages/common/navigation.jsp" />
 <div class="container-fluid">
  <div class="row">
   <jsp:include page="/pages/common/menu.jsp" />
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Title Section [Start] --%>
    <h3 class="page-header">Edit Department</h3>
    <%-- Title Section [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Edit Department [Start] --%>
    <div class="col-lg-6">
     <div class="well">
      <c:set var="item" scope="page" value="${requestScope.department}"></c:set>
      <form class="bs-example form-horizontal" action="${pageContext.request.contextPath}/department_Post_Edit.do" method="post" name="department_form">
       <input type="hidden" name="inputDepartmentId" value="${item.id}">
       <fieldset>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputDepartmentName"><s:text name="department.field.departmentname" /> *</label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputDepartmentName" name="inputDepartmentName" class="form-control" value="${item.departmentName}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectOperationArea"><s:text name="department.field.operationarea" /> *</label>
         <div class="col-lg-8">
          <select id="selectOperationArea" name="selectOperationArea" class="form-control">
           <c:forEach var="opsArea" items="${requestScope.operationAreas}">
            <option value="${opsArea.id}" ${opsArea.id eq (empty item.operationArea ? 0 : item.operationArea.id) ? 'selected' : ''}>${opsArea.areaName}&nbsp;(is
             Financial:&nbsp;${opsArea.isFinancial eq 'Y' ? 'Yes' : 'No'})</option>
           </c:forEach>
          </select>
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectRegion"><s:text name="department.field.region" /></label>
         <div class="col-lg-8">
          <select id="selectRegion" name="selectRegion" class="form-control">
           <c:forEach var="region" items="${requestScope.regions}">
            <option value="${region.id}" ${region.id eq (empty item.region ? 0 : item.region.id) ? 'selected' : ''}>${region.regionName}</option>
           </c:forEach>
          </select>
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputTelephoneNumber"><s:text name="department.field.telephonenumber" /></label>
         <div class="col-lg-8">
          <input type="text" placeholder="Please Key in Your Telephone Number" id="inputTelephoneNumber" name="inputTelephoneNumber" class="form-control" value="${item.telephoneNumber}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputOfficeAddress"><s:text name="department.field.officeaddress" /></label>
         <div class="col-lg-8">
          <input type="text" placeholder="Please Key in Your Office Address" id="inputOfficeAddress" name="inputOfficeAddress" class="form-control" value="${item.officeAddress}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectManager"><s:text name="department.field.manager" /></label>
         <div class="col-lg-8">
          <select id="selectManager" name="selectManager" class="form-control">
           <option value="">Select One</option>
           <c:forEach var="user" items="${requestScope.userList}">
            <option value="${user.id}" ${user.id eq (empty item.manager ? 0 : item.manager.id) ? 'selected' : ''}>${user.firstName}&nbsp;${user.lastName}</option>
           </c:forEach>
          </select>
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
          <button type="reset" class="btn btn-default"><s:text name="page.button.reset" /></button>
          <button type="submit" class="btn btn-primary"><s:text name="page.button.submit" /></button>
         </div>
        </div>
       </fieldset>
      </form>
     </div>
    </div>
    <div class="col-lg-6"></div>
    <%-- Edit Department [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- User List [Start] --%>
    <div class="col-lg-12">
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
       <display:column media="html" title="Action">
        <c:url var="userDeleteUril" value="department_Get_DeleteUsers.do" scope="page">
         <c:param name="inputUserId" value="${userItem.id}"></c:param>
         <c:param name="inputDepartmentId" value="${item.id}"></c:param>
        </c:url>
        <a href="${userDeleteUril}" onclick="return confirm('Do you want to remove user: ${userItem.userName} (id=${userItem.id}) from this department ?');">Remove</a>
       </display:column>
      </display:table>
     </div>
     <div class="row placeholders">
      <form action="${pageContext.request.contextPath}/department_Post_CreateUsers.do" method="post">
       <div class="col-lg-3 col-lg-offset-7">
        <select id="selectUser" name="selectUser" class="form-control">
         <c:forEach var="user" items="${requestScope.users}">
          <option value="${user.id}">${user.firstName}&nbsp;${user.lastName}</option>
         </c:forEach>
        </select>
       </div>
       <div class="col-lg-2">
        <span class="pull-right"> <input type="hidden" name="inputDepartmentId" value="${item.id}">
         <button type="submit" class="btn btn-primary">Assign User to Department</button>
        </span>
       </div>
      </form>
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
