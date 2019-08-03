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
<title><s:text name="user.title.create" /></title>
</head>
<body>
 <jsp:include page="/pages/common/navigation.jsp" />
 <div class="container-fluid">
  <div class="row">
   <jsp:include page="/pages/common/menu.jsp" />
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Title Section [Start] --%>
    <h3 class="page-header"><s:text name="user.title.create" /></h3>
    <%-- Title Section [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Create User Form [Start] --%>
    <div class="col-lg-6">
     <div class="well">
      <form class="bs-example form-horizontal" action="${pageContext.request.contextPath}/user_Post_Create.do" method="post" name="user_form" id="user_form">
       <fieldset>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputUserName"><s:text name="user.field.username" /> *</label>
         <div class="col-lg-8">
          <input type="text" placeholder="Please Key in the User Name" id="inputUserName" name="inputUserName" class="form-control">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputFirstName"><s:text name="user.field.firstname" /> *</label>
         <div class="col-lg-8">
          <input type="text" placeholder="Please Key in the Fisrt Name" id="inputFirstName" name="inputFirstName" class="form-control">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputLastName"><s:text name="user.field.lastname" /> *</label>
         <div class="col-lg-8">
          <input type="text" placeholder="Please Key in the Last Name" id="inputLastName" name="inputLastName" class="form-control">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectGender"><s:text name="user.field.gender" /> *</label>
         <div class="col-lg-8">
          <select id="selectGender" name="selectGender" class="form-control">
           <option value="M">Male</option>
           <option value="F">Female</option>
          </select>
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputBirthDate"><s:text name="user.field.birthdate" /></label>
         <div class="col-lg-8">
          <input readonly type="text" placeholder="Please Key in the Birth Date" id="inputBirthDate" name="inputBirthDate" class="form-control">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputEmail"><s:text name="user.field.email" /> *</label>
         <div class="col-lg-8">
          <input type="text" placeholder="Please Key in the Email" id="inputEmail" name="inputEmail" class="form-control">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label"><s:text name="user.field.isadminstrator" /> *</label>
         <div class="col-lg-8">
          <div class="radio">
           <label> <input type="radio" value="Y" id="isAdministratorRadios1" name="isAdministratorRadios">Yes
           </label>
          </div>
          <div class="radio">
           <label> <input type="radio" checked value="N" id="isAdministratorRadios2" name="isAdministratorRadios">No
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
            <option value="${dept.id}">${dept.departmentName}</option>
           </c:forEach>
          </select>
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
    <%-- Create User Form [End] --%>
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
  $("#user_form").validate({
   event : "blur",
   rules : {
    "inputUserName" : {
     required : true,
     rangelength : [ 4, 45 ],
     remote : {
       url : "${pageContext.request.contextPath}/user_Post_CheckName.do",
       type : "post",
       async: false,
       dataType : 'json',
       data : {'name' : function() {return encodeURIComponent($("input[name='inputUserName']").val());}}
     }
    },
    "inputFirstName": {
     required : true,
     rangelength : [ 1, 45 ]
    },
    "inputLastName": {
     required : true,
     rangelength : [ 1, 45 ]
    },
    "inputEmail": {
     required : true,
     email : true
    }
   },
   messages : {
    "inputUserName" : {
     required : "Please key in user name",
     rangelength : "Length 4~45 letter or number or _",
     remote: "User name is already taken"
    },
    "inputFirstName" : {
    	 required : "Please key in first name",
    	 rangelength : "Length 1~45 letter or number or _"
    },
    "inputLastName" : {
   	 required : "Please key in last name",
   	 rangelength : "Length 1~45 letter or number or _"
    },
    "inputEmail" : {
     required : "Please key in email",
     email : "Email format is not correct"
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
