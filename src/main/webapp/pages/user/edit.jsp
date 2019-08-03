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
<title><s:text name="user.title.edit" /></title>
</head>
<body>
 <jsp:include page="/pages/common/navigation.jsp" />
 <div class="container-fluid">
  <div class="row">
   <jsp:include page="/pages/common/menu.jsp" />
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Title Section [Start] --%>
    <h3 class="page-header"><s:text name="user.title.edit" /></h3>
    <%-- Title Section [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Edit User Form [Start] --%>
    <div class="col-lg-6">
     <div class="well">
      <c:set var="item" scope="page" value="${requestScope.user}"></c:set>
      <form class="bs-example form-horizontal" action="${pageContext.request.contextPath}/user_Post_Edit.do" method="post" name="user_form" id="user_form">
       <input type="hidden" name="inputUserId" value="${item.id}">
       <fieldset>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputUserName"><s:text name="user.field.username" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputUserName" name="inputUserName" class="form-control" value="${item.userName}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputNewPassword"><s:text name="user.field.password.new" /></label>
         <div class="col-lg-8">
          <input type="password" placeholder="Please Key in Your New Password" id="inputNewPassword" name="inputNewPassword" class="form-control" type="password">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputNewPassword2"><s:text name="user.field.password.new2" /></label>
         <div class="col-lg-8">
          <input type="password" placeholder="Please Key in Your New Password Again" id="inputNewPassword2" name="inputNewPassword2" class="form-control" type="password">
          <div class="checkbox">
           <label>Is to Update Password<input value="Y" type="checkbox" name="checkboxUpdatePassword" id="checkboxUpdatePassword">
           </label>
          </div>
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputFirstName"><s:text name="user.field.firstname" /> *</label>
         <div class="col-lg-8">
          <input type="text" placeholder="Please Key in Your Fisrt Name" id="inputFirstName" name="inputFirstName" class="form-control" value="${item.firstName}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputLastName"><s:text name="user.field.lastname" /> *</label>
         <div class="col-lg-8">
          <input type="text" placeholder="Please Key in Your Last Name" id="inputLastName" name="inputLastName" class="form-control" value="${item.lastName}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectGender"><s:text name="user.field.gender" /> *</label>
         <div class="col-lg-8">
          <select id="selectGender" name="selectGender" class="form-control">
           <option value="M" ${item.gender eq 'M' ? 'selected' : ''}>Male</option>
           <option value="F" ${item.gender eq 'F' ? 'selected' : ''}>Female</option>
          </select>
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputBirthDate"><s:text name="user.field.birthdate" /></label>
         <div class="col-lg-8">
          <input readonly type="text" placeholder="Please Key in the Birth Date" id="inputBirthDate" name="inputBirthDate" class="form-control"
           value="<fmt:formatDate pattern='yyyy-MMM-dd' value='${item.birthDate}'/>"
          >
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputEmail"><s:text name="user.field.email" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputEmail" name="inputEmail" class="form-control" value="${item.emailAddr}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label"><s:text name="user.field.isadminstrator" /> *</label>
         <div class="col-lg-8">
          <div class="radio">
           <label> <input type="radio" value="Y" id="isAdministratorRadios1" name="isAdministratorRadios" ${item.isAdmin eq 'Y' ? 'checked' : ''}>Yes
           </label>
          </div>
          <div class="radio">
           <label> <input type="radio" value="N" id="isAdministratorRadios2" name="isAdministratorRadios" ${item.isAdmin eq 'N' ? 'checked' : ''}>No
           </label>
          </div>
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectDepartment"><s:text name="department.field.department" /></label>
         <div class="col-lg-8">
          <select id="selectDepartment" name="selectDepartment" class="form-control">
           <option value="">Select One</option>
           <c:forEach var="dept" items="${requestScope.departments}">
            <option value="${dept.id}" ${dept.id eq (empty item.department ? 0 : item.department.id) ? 'selected' : ''}>${dept.departmentName}</option>
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
    <%-- Edit User Form [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
   </div>
  </div>
 </div>
 <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
 <jsp:include page="/pages/common/foot_scipt.jsp" />
 <script>
		$(document)
				.ready(
						function() {
							$("#inputBirthDate")
									.datepicker(
											{
												changeMonth : true,
												changeYear : true,
												showOn : "button",
												buttonImage : "${pageContext.request.contextPath}/resources/img/common/calendar.gif",
												buttonImageOnly : true,
												buttonText : "Please Key in the Birth Day",
												dateFormat : "yy-M-d",
												defaultDate : new Date(
														(new Date())
																.getFullYear() - 25,
														0, 1),
												yearRange : (new Date())
														.getFullYear()
														- 60
														+ ":"
														+ (new Date())
																.getFullYear(),
											});
						});
	</script>
<script>
 $(document).ready(function() {
  $.validator.addMethod("checkPasswordEqual", function(value, element) {
	// debug
	// alert($(checkboxUpdatePassword).prop("checked"));
	if($(checkboxUpdatePassword).prop("checked") == true){
		// debug
		// alert($(inputNewPassword).val());
		// alert($(inputNewPassword2).val());
		return ($(inputNewPassword).val() == $(inputNewPassword2).val()) && ($(inputNewPassword).val() == null || $(inputNewPassword2).val() == null);
	}else{
		return true;
	}
  }, "Re-entry New Password must be matched and both passwords cannot be empty");
  
  $("#user_form").validate({
   event : "keyup",
   rules : {
    "inputFirstName": {
     required : true,
     rangelength : [ 1, 45 ]
    },
    "inputLastName": {
     required : true,
     rangelength : [ 1, 45 ]
    },
    "checkboxUpdatePassword": {
    	checkPasswordEqual : true
    }
   },
   messages : {
    "inputFirstName" : {
      required : "Please key in first name",
      rangelength : "Length 1~45 letter or number or _"
    },
    "inputLastName" : {
     required : "Please key in last name",
     rangelength : "Length 1~45 letter or number or _"
    }
   },
   // customize style
   highlight : function(element) {
    $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
   },
   success : function(element) {
    element.text('OK!').addClass('valid').closest('.form-group').removeClass('has-error').addClass('has-success');
   }
  });
  $("input[type=reset]").click(function(){ 
      validate.resetForm(); 
  }); 
 });
</script>
</body>
</html>
