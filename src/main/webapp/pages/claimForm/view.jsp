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
<title><s:text name="claimform.title.view" /></title>
</head>
<body>
 <jsp:include page="/pages/common/navigation.jsp" />
 <div class="container-fluid">
  <div class="row">
   <jsp:include page="/pages/common/menu.jsp" />
   <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Title Section [Start] --%>
    <h3 class="page-header"><s:text name="claimform.title.view" /></h3>
    <%-- Title Section [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- View Claim Form [Start] --%>
    <div class="col-lg-6">
     <div class="well">
      <c:set var="item" scope="page" value="${requestScope.claimForm}"></c:set>
      <form class="bs-example form-horizontal">
       <fieldset>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectYear"><s:text name="claimform.field.year" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputTotal" class="form-control" value="${item.travelOfYear}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectMonth"><s:text name="claimform.field.month" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="selectMonth" class="form-control" value="${requestScope.months[item.travelOfMonth]}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputTotal"><s:text name="claimform.field.total" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputTotal" class="form-control" value="${item.total}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="selectFormStatus"><s:text name="claimform.field.status" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="selectFormStatus" class="form-control" value="${item.formStatus.formStatus}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputDepartment"><s:text name="department.field.department" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputDepartment" class="form-control" value="${item.department.departmentName}">
         </div>
        </div>
        <div class="form-group">
         <label class="col-lg-4 control-label" for="inputRequestedBy"><s:text name="claimform.field.requestby" /></label>
         <div class="col-lg-8">
          <input readonly type="text" id="inputRequestedBy" class="form-control" value="${item.user.firstName}&nbsp;${item.user.lastName}">
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
    <%-- View Claim Form [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
    <%-- Claim Form Item List [Start] --%>
    <div class="col-lg-12">
     <h4 class="sub-header"><s:text name="claimform.title.item.list" /></h4>
     <div class="table-responsive">
      <display:table name="claimFormItemList" id="claimFormItem" class="table table-striped its" defaultsort="1" defaultorder="descending">
       <display:column property="id" title="Id"></display:column>
       <display:column property="claimDate" title="Claim Date" format="{0, date,yyyy-MMM-dd}" href="${pageContext.request.contextPath}/claimForm_Get_ViewItem.do" paramId="inputClaimFormItemId" paramProperty="id"></display:column>
       <display:column property="claimType.claimType" title="Claim Type"></display:column>
       <display:column property="claimDescription" title="Claim Description" maxLength="20"></display:column>
       <display:column property="claimAmount" title="Claim Amount"></display:column>
       <display:column property="createBy" title="Create By"></display:column>
       <display:column property="createTime" title="Create Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
       <display:column property="updateBy" title="Update By"></display:column>
       <display:column property="updateTime" title="Update Time" format="{0, date,yyyy-MMM-dd HH:mm:ss}"></display:column>
      </display:table>
     </div>
    </div>
    <%-- Claim Form Item List [End] --%>
    <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
   </div>
  </div>
 </div>
 <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
 <jsp:include page="/pages/common/foot_script.jsp" />
</body>
</html>
