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
<title><s:text name="user.title.mantain" /></title>
</head>
<body>
 <jsp:include page="/pages/common/navigation.jsp" />
 <div class="container-fluid">
  <div class="row">
   <jsp:include page="/pages/common/menu.jsp" />
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Title Section [Start] --%>
    <h3 class="page-header"><s:text name="user.title.mantain" /></h3>
    <%-- Title Section [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- User List [Start] --%>
    <h4 class="sub-header"><s:text name="user.title.list" /></h4>
    <div class="table-responsive">
     <display:table name="userList" requestURI="${pageContext.request.contextPath}/user_Get_List.do" pagesize="5" id="item" class="table table-striped its" defaultsort="1" defaultorder="descending">
      <display:column property="id" sortable="true" headerClass="sortable" title="Id"></display:column>
      <display:column property="userName" sortable="true" headerClass="sortable" title="User Name" href="${pageContext.request.contextPath}/user_Get_View.do" paramId="inputUserId" paramProperty="id"></display:column>
      <display:column property="firstName" sortable="true" headerClass="sortable" title="First Name"></display:column>
      <display:column property="lastName" sortable="true" headerClass="sortable" title="Last Name"></display:column>
      <display:column property="gender" sortable="true" headerClass="sortable" title="Gender"></display:column>
      <display:column property="birthDate" sortable="true" headerClass="sortable" title="Birth Date" format="{0, date,yyyy-MMM-dd}"></display:column>
      <display:column property="emailAddr" sortable="true" headerClass="sortable" title="Email Address" autolink="true"></display:column>
      <display:column property="isAdmin" sortable="true" headerClass="sortable" title="is Administrator"></display:column>
      <display:column property="department.departmentName" sortable="true" headerClass="sortable" title="Department"></display:column>
      <display:column property="createBy" sortable="true" headerClass="sortable" title="Create By"></display:column>
      <display:column property="createTime" sortable="true" headerClass="sortable" title="Create Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column property="updateBy" sortable="true" headerClass="sortable" title="Update By"></display:column>
      <display:column property="updateTime" sortable="true" headerClass="sortable" title="Update Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      <display:column media="html" title="Action">
       <a href="${pageContext.request.contextPath}/user_Get_Edit.do?inputUserId=${item.id}"><s:text name="page.button.edit" /></a>
         |
       <c:choose>
        <c:when test="${item.id ne sessionScope.user.id}">
         <a href="${pageContext.request.contextPath}/user_Get_Delete.do?inputUserId=${item.id}" onclick="return confirm('Do you want to remove user: ${item.userName} (id=${item.id}) ?');">Remove</a>
        </c:when>
        <c:otherwise>
         <img src="${pageContext.request.contextPath}/resources/img/common/user.png" title="Current Signin User" onclick="alert('You Cannot Remove Current Signin User');">
        </c:otherwise>
       </c:choose>
      </display:column>
     </display:table>
    </div>
    <%-- User List [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Create New User [Start] --%>
    <div class="row placeholders">
     <div class="col-lg-2 col-lg-offset-10">
      <form action="${pageContext.request.contextPath}/user_Get_Create.do" method="get">
       <span class="pull-right">
        <button type="submit" class="btn btn-primary"><s:text name="page.button.createuser" /></button>
       </span>
      </form>
     </div>
    </div>
    <%-- Create New User [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
   </div>
  </div>
 </div>
 <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
 <jsp:include page="/pages/common/foot_script.jsp" />
</body>
</html>
