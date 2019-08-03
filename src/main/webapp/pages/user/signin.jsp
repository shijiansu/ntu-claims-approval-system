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
<jsp:include page="../common/head.jsp" />
<title><s:text name="user.title.signin" /></title>
<link href="${pageContext.request.contextPath}/resources/css/user/bootstrap_signin.css" rel="stylesheet">
</head>
<body>
 <div class="container">
  <div class="center">
   <jsp:include page="/pages/common/message.jsp" />
  </div>
  <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
  <%-- Sign In [Start] --%>
  <form class="form-signin" action="${pageContext.request.contextPath}/user_Post_Signin.do" method="post" name="signin_form">
   <h2 class="form-signin-heading"><s:text name="user.title.signin.please" /></h2>
   <input class="form-control" placeholder="User Name" name="inputUserName">
   <input class="form-control" placeholder="Password" type="password" name="inputPassword">
   <label class="checkbox"> <input value="Y" type="checkbox" name="checkboxRememberMe"> <s:text name="user.field.signin.cookie" />
   </label>
   <button class="btn btn-lg btn-primary btn-block" type="submit"><s:text name="page.button.signin" /></button>
  </form>
  <%-- Sign In [End] --%>
  <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
 </div>
 <%-- ---------------------------------------------------------------------------------------------------------------------------------------- --%>
 <jsp:include page="/pages/common/foot_copyright.jsp" />
</body>
</html>
