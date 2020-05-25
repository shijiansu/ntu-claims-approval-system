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
<title><s:text name="department.title.create" /></title>
</head>
<body>
 <jsp:include page="/pages/common/navigation.jsp" />
 <div class="container-fluid">
  <div class="row">
   <jsp:include page="/pages/common/menu.jsp" />
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Title Section [Start] --%>
    <h3 class="page-header"><s:text name="department.title.create" /></h3>
    <%-- Title Section [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Create Department [Start] --%>
    <div class="col-lg-6">
     <div class="well">
      <form class="bs-example form-horizontal" action="${pageContext.request.contextPath}/department_Post_Create.do" method="post" name="department_form" id="department_form">
       <fieldset>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputDepartmentName"><s:text name="department.field.departmentname" /> *</label>
         <div class="col-lg-8">
          <input type="text" placeholder="Please Key in Your Department Name" id="inputDepartmentName" name="inputDepartmentName" class="form-control">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectOperationArea"><s:text name="department.field.operationarea" /> *</label>
         <div class="col-lg-8">
          <select id="selectOperationArea" name="selectOperationArea" class="form-control">
           <c:forEach var="opsArea" items="${requestScope.operationAreas}">
            <option value="${opsArea.id}">${opsArea.areaName}${opsArea.isFinancial eq 'Y' ? '&nbsp;(is Financial:&nbsp;Yes)' : ''}</option>
           </c:forEach>
          </select>
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectRegion"><s:text name="department.field.region" /></label>
         <div class="col-lg-8">
          <select id="selectRegion" name="selectRegion" class="form-control">
           <c:forEach var="region" items="${requestScope.regions}">
            <option value="${region.id}">${region.regionName}</option>
           </c:forEach>
          </select>
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputTelephoneNumber"><s:text name="department.field.telephonenumber" /></label>
         <div class="col-lg-8">
          <input type="text" placeholder="Please Key in Your Telephone Number" id="inputTelephoneNumber" name="inputTelephoneNumber" class="form-control">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputOfficeAddress"><s:text name="department.field.officeaddress" /></label>
         <div class="col-lg-8">
          <input type="text" placeholder="Please Key in Your Office Address" id="inputOfficeAddress" name="inputOfficeAddress" class="form-control">
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
    <%-- Create Department [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
   </div>
  </div>
 </div>
 <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
 <jsp:include page="/pages/common/foot_script.jsp" />
 <script>
 $(document).ready(function() {
  $("#department_form").validate({
   event : "blur",
   rules : {
    "inputDepartmentName" : {
     required : true,
     rangelength : [ 4, 45 ],
     remote : {
       url : "${pageContext.request.contextPath}/department_Post_CheckName.do",
       type : "post",
       async: false,
       dataType : 'json',
       data : {'name' : function() {return encodeURIComponent($("input[name='inputDepartmentName']").val());}}
     }
    }
   },
   messages : {
    "inputDepartmentName" : {
     required : "Please key in department name",
     rangelength : "Length 4~45 letter or number or _",
     remote: "Department name is already taken"
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
