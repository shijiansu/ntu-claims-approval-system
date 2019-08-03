<!-- #-------------------------------------------------------------------------------
# Copyright (c) 2014, Shijian Su. All rights reserved.
# 
# This software is the confidential and proprietary information of Shijian Su. ("Confidential Information").  You shall not
# disclose such Confidential Information and shall use it only in
# accordance with the terms of the license agreement you entered into
# with him.
#------------------------------------------------------------------------------- -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="col-sm-3 col-md-2 sidebar">
 <ul class="nav nav-sidebar">
  <li id="menu1"><a href="${pageContext.request.contextPath}/user_Get_ViewDashboard.do">Dashboard</a></li>
  <c:if test="${sessionScope.user.isAdmin eq 'Y'}">
   <li id="menu2"><a href="${pageContext.request.contextPath}/user_Get_List.do">Maintain User</a></li>
   <li id="menu3"><a href="${pageContext.request.contextPath}/department_Get_List.do"><s:text name="department.title.maintain" /></a></li>
  </c:if>
  <li id="menu4"><a href="${pageContext.request.contextPath}/claimForm_Get_List.do"><s:text name="claimform.title.maintain" /></a></li>
  <c:if test="${sessionScope.user.isFinancial}">
   <li id="menu5"><a href="${pageContext.request.contextPath}/claimForm_Get_Monitor.do"><s:text name="claimform.title.monitor" /></a></li>
  </c:if>
  <li id="menu6"><a href="${pageContext.request.contextPath}/report_Get_List.do">Report</a></li>
 </ul>
 <ul class="nav nav-sidebar">
  <li id="menu7"><a href="${pageContext.request.contextPath}/user_Get_EditPassword.do?inputUserId=${sessionScope.user.id}">Edit Password</a></li>
  <li><a href="${pageContext.request.contextPath}/user_Get_ExpireCookie.do">Expire Remember Me</a></li>
  <li><a href="${pageContext.request.contextPath}/user_Get_Signout.do"><s:text name="user.title.signout" /></a></li>
 </ul>
</div>
