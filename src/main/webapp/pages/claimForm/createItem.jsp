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
<title><s:text name="claimformitem.title.create" /></title>
</head>
<body>
 <jsp:include page="/pages/common/navigation.jsp" />
 <div class="container-fluid">
  <div class="row">
   <jsp:include page="/pages/common/menu.jsp" />
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Title Section [Start] --%>
    <h3 class="page-header"><s:text name="claimformitem.title.create" /></h3>
    <%-- Title Section [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Create Claim Form Item [Start] --%>
    <div class="col-lg-6">
     <div class="well">
      <c:set var="item" scope="page" value="${requestScope.claimForm}"></c:set>
      <form class="bs-example form-horizontal" action="${pageContext.request.contextPath}/claimForm_Post_CreateItem.do" method="post" name="claimFormItem_form" id="claimFormItem_form">
       <input type="hidden" name="inputClaimFormId" value="${requestScope.claimFormId}">
       <fieldset>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputClaimDate"><s:text name="claimformitem.field.claimdate" /> *</label>
         <div class="col-lg-8">
          <input readonly type="text" placeholder="Please Key in the Claim Date" id="inputClaimDate" name="inputClaimDate" class="form-control">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectClaimType"><s:text name="claimformitem.field.claimtype" /> *</label>
         <div class="col-lg-8">
          <select id="selectClaimType" name="selectClaimType" class="form-control">
           <c:forEach var="claimType" items="${requestScope.claimTypes}">
            <option value="${claimType.id}">${claimType.claimType}</option>
           </c:forEach>
          </select>
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputClaimDescription"><s:text name="claimformitem.field.claimdescription" /></label>
         <div class="col-lg-8">
          <input type="text" placeholder="Please Key in the Claim Description" id="inputClaimDescription" name="inputClaimDescription" class="form-control">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputClaimAmount"><s:text name="claimformitem.field.claimamount" /> *</label>
         <div class="col-lg-8">
          <input type="text" placeholder="Please Key in the Claim Amount" id="inputClaimAmount" name="inputClaimAmount" class="form-control">
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
    <%-- Create Claim Form Item [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
   </div>
  </div>
 </div>
 <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
 <jsp:include page="/pages/common/foot_script.jsp" />
 <script>
		$(document)
				.ready(
						function() {
							$("#inputClaimDate")
									.datepicker(
											{
												changeMonth : false,
												changeYear : false,
												showOn : "button",
												buttonImage : "${pageContext.request.contextPath}/resources/img/common/calendar.gif",
												buttonImageOnly : true,
												buttonText : "Please Key in the Claim Date",
												dateFormat : "yy-M-d",
												yearRange : "${item.travelOfYear}:${item.travelOfYear}",
												defaultDate : new Date(
														'${item.travelOfYear}',
														'${item.travelOfMonth - 1}',
														1),
												minDate : new Date(
														'${item.travelOfYear}',
														'${item.travelOfMonth - 1}',
														1),
												maxDate : new Date(
														new Date(
																'${item.travelOfYear}',
																'${item.travelOfMonth}',
																1).getTime()
																- 24
																* 60
																* 60
																* 1000)
											});
						});
	</script>
<script>
 $(document).ready(function() {
  $.validator.addMethod("checkDecimal", function(value, element) {
	  var decimal = /^-?\d+(\.\d{1,2})?$/;  
	  var result = (this.optional(element) || decimal.test(value))
	  if(result == true){
		  result = (value > 0);
	  }
	  return result; 
  }, "Only positive number allowed, maximum with 2 digit"); 
  
  $("#claimFormItem_form").validate({
   event : "keyup",
   rules : {
    "inputClaimDate": {
     required : true
    },
    "inputClaimAmount": {
     required : true,
     rangelength : [ 1, 12 ],
     checkDecimal:true
    }
   },
   messages : {
    "inputClaimDate" : {
      required : "Please key in claim date"
    },
    "inputClaimAmount" : {
     required : "Please key in claim amount",
     rangelength : "Length 1~12 number"
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
