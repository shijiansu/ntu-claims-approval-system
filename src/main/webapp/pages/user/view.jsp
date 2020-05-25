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
<title><s:text name="user.title.view" /></title>
</head>
<body>
 <jsp:include page="/pages/common/navigation.jsp" />
 <div class="container-fluid">
  <div class="row">
   <jsp:include page="/pages/common/menu.jsp" />
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Title Section [Start] --%>
    <h3 class="page-header"><s:text name="user.title.view" /></h3>
    <%-- Title Section [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- View User Form [Start] --%>
    <div class="col-lg-6">
     <div class="well">
      <c:set var="item" scope="page" value="${requestScope.user}"></c:set>
      <form class="bs-example form-horizontal">
       <fieldset>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputUserName"><s:text name="user.field.username" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputUserName" class="form-control" value="${item.userName}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputOldPassword"><s:text name="user.field.password" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputOldPassword" name="inputOldPassword" class="form-control" type="password" value="${item.password}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputFirstName"><s:text name="user.field.firstname" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputFirstName" class="form-control" value="${item.firstName}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputLastName"><s:text name="user.field.lastname" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputLastName" class="form-control" value="${item.lastName}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectGender"><s:text name="user.field.gender" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="selectGender" class="form-control" value="${item.gender eq 'M' ? 'Male' : 'Female'}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputBirthDate"><s:text name="user.field.birthdate" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputBirthDate" name="inputBirthDate" class="form-control" value="<fmt:formatDate pattern='yyyy-MMM-dd' value='${item.birthDate}'/>">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputEmail"><s:text name="user.field.eSmail" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputEmail" class="form-control" value="${item.emailAddr}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label"><s:text name="user.field.isadminstrator" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="selectIsAdministratore" class="form-control" value="${item.isAdmin eq 'Y' ? 'Yes' : 'No'}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectDepartment"><s:text name="department.field.department" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="selectDepartment" class="form-control" value="${empty item.department ? '' : item.department.departmentName}">
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
    <%-- View User Form [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
   </div>
  </div>
 </div>
 <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
 <jsp:include page="/pages/common/foot_script.jsp" />
</body>
</html>
