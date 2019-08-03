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
<title><s:text name="department.title.maintain" /></title>
</head>
<body>
 <jsp:include page="/pages/common/navigation.jsp" />
 <div class="container-fluid">
  <div class="row">
   <jsp:include page="/pages/common/menu.jsp" />
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Title Section [Start] --%>
    <h3 class="page-header"><s:text name="department.title.maintain" /></h3>
    <%-- Title Section [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Department List [Start] --%>
    <h4 class="sub-header"><s:text name="department.title.list" /></h4>
    <div class="table-responsive">
     <display:table name="departmentList" requestURI="${pageContext.request.contextPath}/department_Get_List.do" pagesize="5" id="item" class="table table-striped its" defaultsort="1" defaultorder="descending">
      <display:column property="id" sortable="true" headerClass="sortable" title="Id"></display:column>
      <display:column property="departmentName" sortable="true" headerClass="sortable" title="Department Name" href="${pageContext.request.contextPath}/department_Get_View.do" paramId="inputDepartmentId" paramProperty="id"></display:column>
      <display:column property="operationArea.areaName" sortable="true" headerClass="sortable" title="Operation Area"></display:column>
      <display:column property="operationArea.isFinancial" sortable="true" headerClass="sortable" title="is Financial"></display:column>
      <display:column property="region.regionName" sortable="true" headerClass="sortable" title="Region"></display:column>
      <display:column property="telephoneNumber" sortable="true" headerClass="sortable" title="Telephone Number"></display:column>
      <display:column property="officeAddress" sortable="true" headerClass="sortable" title="Office Address" maxLength="20"></display:column>
      <display:column sortable="true" headerClass="sortable" title="Manager">
       <c:if test="${not empty item.manager}">
      ${item.manager.firstName}&nbsp;${item.manager.lastName}
      </c:if>
      </display:column>
      <display:column property="createBy" sortable="true" headerClass="sortable" title="Create By"></display:column>
      <display:column property="createTime" sortable="true" headerClass="sortable" title="Create Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column property="updateBy" sortable="true" headerClass="sortable" title="Update By"></display:column>
      <display:column property="updateTime" sortable="true" headerClass="sortable" title="Update Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column media="html" title="Action">
       <a href="${pageContext.request.contextPath}/department_Get_Edit.do?inputDepartmentId=${item.id}"><s:text name="page.button.edit" /></a>
       |
       <a href="${pageContext.request.contextPath}/department_Get_Delete.do?inputDepartmentId=${item.id}"
        onclick="return confirm('Do you want to remove department: ${item.departmentName} (id=${item.id}) ? All users under this department will be unassign department.');"
       >Remove</a>
      </display:column>
     </display:table>
    </div>
    <%-- Department List [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Create New Department [Start] --%>
    <div class="row placeholders">
     <div class="col-lg-2 col-lg-offset-10">
      <form action="${pageContext.request.contextPath}/department_Get_Create.do" method="get">
       <span class="pull-right">
        <button type="submit" class="btn btn-primary"><s:text name="page.button.createdepartment" /></button>
       </span>
      </form>
     </div>
    </div>
    <%-- Create New Department [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
   </div>
  </div>
 </div>
 <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
 <jsp:include page="/pages/common/foot_scipt.jsp" />
</body>
</html>
