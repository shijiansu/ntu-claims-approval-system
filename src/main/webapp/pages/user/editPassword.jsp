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
<title><s:text name="user.title.edit.password" /></title>
</head>
<body>
 <jsp:include page="/pages/common/navigation.jsp" />
 <div class="container-fluid">
  <div class="row">
   <jsp:include page="/pages/common/menu.jsp" />
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Title Section [Start] --%>
    <h3 class="page-header"><s:text name="user.title.edit.password" /></h3>
    <%-- Title Section [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Edit Password Form [Start] --%>
    <div class="col-lg-6">
     <jsp:include page="/pages/common/message.jsp" />
     <div class="well">
      <c:set var="item" scope="page" value="${requestScope.user}"></c:set>
      <form class="bs-example form-horizontal" action="${pageContext.request.contextPath}/user_Post_EditPassword.do" method="post" name="user_form" id="user_form">
       <input type="hidden" name="inputUserId" value="${item.id}">
       <fieldset>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputOldPassword"><s:text name="user.field.password.old" /> *</label>
         <div class="col-lg-8">
          <input type="password" placeholder="Please Key in Your Old Password" id="inputOldPassword" name="inputOldPassword" class="form-control" type="password">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputNewPassword"><s:text name="user.field.password.new" /> *</label>
         <div class="col-lg-8">
          <input type="password" placeholder="Please Key in Your New Password" id="inputNewPassword" name="inputNewPassword" class="form-control" type="password">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputNewPassword2"><s:text name="user.field.password.new2" /> *</label>
         <div class="col-lg-8">
          <input type="password" placeholder="Please Key in Your New Password Again" id="inputNewPassword2" name="inputNewPassword2" class="form-control" type="password">
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
    <%-- Edit Password Form [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
   </div>
  </div>
 </div>
 <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
 <jsp:include page="/pages/common/foot_script.jsp" />
 <script>
 $(document).ready(function() {
  $("#user_form").validate({
   event : "keyup",
   rules : {
	"inputOldPassword": {
	 required : true
	},
	"inputNewPassword": {
	 required : true,
	 rangelength : [ 6, 12 ]
	},
    "inputNewPassword2": {
     required : true,
     rangelength : [ 6, 12 ],
     equalTo : "#inputNewPassword"
    }
   },
   messages : {
	"inputOldPassword" : {
	 required : "Please key in old password"
	},
	"inputNewPassword" : {
	 required : "Please key in new password",
	 rangelength : "Length 6~12 letter or number or _"
	},
    "inputNewPassword2" : {
     required : "Please key in new password again",
     rangelength : "Length 6~12 letter or number or _",
     equalTo : "New passowords are not the same"
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
