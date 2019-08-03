/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.web.action;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.UserFacade;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.ClaimForm;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.Department;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.User;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.common.CookieUtil;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.common.DateUtil;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.FacadeServiceLocator;

/**
 * The Class UserAction.
 */
public class UserAction extends UserRoot {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7994157394898765579L;

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#doGetCreate()
	 */
	@Override
	public String doGetCreate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		setDepartments(request);
		return ACTION_CREATE;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#doGetDelete()
	 */
	@Override
	public String doGetDelete() {
		//
		String userId = getInputUserId();
		getFacade().delete(new Long(userId));
		return doGetList();
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#doGetEdit()
	 */
	@Override
	public String doGetEdit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		setDepartments(request);
		String userId = getInputUserId();
		User user = getFacade().selectById(new Long(userId));
		request.setAttribute("user", user);
		return ACTION_EDIT;
	}

	/**
	 * Do get edit password.
	 *
	 * @return the string
	 */
	public String doGetEditPassword() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		String userId = getInputUserId();
		User user = getFacade().selectById(new Long(userId));
		request.setAttribute("user", user);
		return ACTION_EDIT_PASSWORD;
	}

	/**
	 * Do get expire cookie.
	 *
	 * @return the string
	 */
	public String doGetExpireCookie() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		//
		CookieUtil.deleteCookie(request, response, REMEBER_ME_COOKIE);
		return doGetViewDashboard();
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#doGetList()
	 */
	@Override
	public String doGetList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		List<User> userList = getFacade().selectAll();
		request.setAttribute("userList", userList);
		return ACTION_LIST;
	}

	/**
	 * Do post check name.
	 *
	 * @return the string
	 */
	public String doPostCheckName() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		//
		String userName = getInputUserName();
		User user = getFacade().getUserByName(userName);
		boolean result = (user == null);
		response.setContentType("application/json");
		try {
			request.setAttribute("result", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ACTION_AJAX;
	}

	/**
	 * Do get signin.
	 *
	 * @return the string
	 */
	public String doGetSignin() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		User sessionUser = getSessionUser(request);
		if (sessionUser == null) {
			Cookie cookie = CookieUtil.getCookie(request, REMEBER_ME_COOKIE);
			if (cookie == null) {
				// no cookie, request to sign in
				return ACTION_SIGNIN;
			} else {
				String userId = cookie.getValue();
				User user = getFacade().selectById(new Long(userId));
				if (user == null) {
					// user been deleted, request to sign in
					return ACTION_SIGNIN;
				} else {
					// sign in by cookie - remember me
					setSessionUser(request, user);
					return doGetViewDashboard();
				}
			}
		} else {
			return doGetViewDashboard();
		}
	}

	/**
	 * Do get signout.
	 *
	 * @return the string
	 */
	public String doGetSignout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		removeSessionUser(request);
		return ACTION_SIGNOUT;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#doGetView()
	 */
	@Override
	public String doGetView() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		String userId = getInputUserId();
		User user = getFacade().selectById(new Long(userId));
		request.setAttribute("user", user);
		return ACTION_VIEW;
	}

	/**
	 * Do get view dashboard.
	 *
	 * @return the string
	 */
	public String doGetViewDashboard() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		User user = getSessionUser(request);
		// list of chart data
		List<String> monthsList = new ArrayList<String>();
		Map<String, List<BigDecimal>> monthsValues = new LinkedHashMap<String, List<BigDecimal>>();
		FacadeServiceLocator.getInstance().getClaimFormFacade().getClaimFormsForChart(user, monthsList, monthsValues);
		StringBuffer xAxisCategories = new StringBuffer();
		for (String i : monthsList) {
			xAxisCategories.append("'");
			xAxisCategories.append(i);
			xAxisCategories.append("',");
		}
		xAxisCategories.delete(xAxisCategories.length() - 1, xAxisCategories.length());
		request.setAttribute("xAxisCategories", xAxisCategories.toString());
		//
		StringBuffer series = new StringBuffer();
		for (Entry<String, List<BigDecimal>> i : monthsValues.entrySet()) {
			series.append("{");
			series.append("name:");
			series.append("'");
			series.append(i.getKey());
			series.append("',");
			series.append("data:");
			series.append("[");
			for (BigDecimal j : i.getValue()) {
				series.append(j);
				series.append(",");
			}
			series.delete(series.length() - 1, series.length());
			series.append("]");
			series.append("},");
		}
		series.delete(series.length() - 1, series.length());
		request.setAttribute("series", series.toString());
		System.out.println(xAxisCategories);
		System.out.println(series);
		// list of users
		List<User> userList = new ArrayList<User>();
		user = getFacade().selectById(user);
		userList.add(user);
		request.setAttribute("userList", userList);
		// list of departments
		List<Department> departmentList = new ArrayList<Department>();
		if (user.getDepartment() != null) {
			departmentList.add(user.getDepartment());
		}
		request.setAttribute("departmentList", departmentList);
		// list of claim form pending approval
		List<ClaimForm> claimFormPendingList = FacadeServiceLocator.getInstance().getClaimFormFacade().getClaimFormsPendingForApproval(user);
		setMonths(request);
		request.setAttribute("claimFormPendingList", claimFormPendingList);
		// list of claim form for your approval
		List<ClaimForm> claimFormForYourApprovalList = FacadeServiceLocator.getInstance().getClaimFormFacade().getClaimFormsForYourApproval(user);
		setMonths(request);
		request.setAttribute("claimFormForYourApprovalList", claimFormForYourApprovalList);
		return ACTION_VIEW_DASHBOARD;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#doPostCreate()
	 */
	@Override
	public String doPostCreate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		String userName = getInputUserName();
		String firstName = getInputFirstName();
		String lastName = getInputLastName();
		String gender = getSelectGender();
		String emailAddr = getInputEmail();
		String birthDate = getInputBirthDate();
		String isAdmin = getIsAdministratorRadios();
		String departmentId = getSelectDepartment();
		Department department = null;
		if (!StringUtils.isEmpty(departmentId)) {
			department = FacadeServiceLocator.getInstance().getDepartmentFacade().selectById(new Long(departmentId));
		}
		User user = getNewEntity();
		user.setUserName(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setEmailAddr(emailAddr);
		try {
			user.setBirthDate(DateUtil.DATE_FORMATOR.parse(birthDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setIsAdmin(isAdmin);
		user.setDepartment(department);
		user.setCreateBy(getSessionUser(request).getUserName());
		user.setCreateTime(new Date());
		getFacade().createUserWithPassword(user);
		return doGetList();
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#doPostEdit()
	 */
	@Override
	public String doPostEdit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		String userId = getInputUserId();
		String firstName = getInputFirstName();
		String lastName = getInputLastName();
		String gender = getSelectGender();
		String birthDate = getInputBirthDate();
		String isAdmin = getIsAdministratorRadios();
		String departmentId = getSelectDepartment();
		String isUpdatePassword = getCheckboxUpdatePassword();
		String password = getInputNewPassword();
		Department department = null;
		if (!StringUtils.isEmpty(departmentId)) {
			department = FacadeServiceLocator.getInstance().getDepartmentFacade().selectById(new Long(departmentId));
		}
		User user = getFacade().selectById(new Long(userId));
		if (user != null) {
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setGender(gender);
			try {
				user.setBirthDate(DateUtil.DATE_FORMATOR.parse(birthDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			user.setIsAdmin(isAdmin);
			user.setDepartment(department);
			user.setUpdateBy(getSessionUser(request).getUserName());
			user.setUpdateTime(new Date());
			if ("Y".equalsIgnoreCase(isUpdatePassword)) {
				user.setPassword(password);
			}
			getFacade().update(user);
		}
		return doGetList();
	}

	/**
	 * Do post edit password.
	 *
	 * @return the string
	 */
	public String doPostEditPassword() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		String userId = getInputUserId();
		String oldPassword = getInputOldPassword();
		String newPassword = getInputNewPassword();
		User user = getNewEntity();
		user.setId(new Long(userId));
		user.setPassword(oldPassword);
		user = getFacade().varifyUser(user);
		if (user != null) {
			user.setPassword(newPassword);
			user.setUpdateBy(getSessionUser(request).getUserName());
			user.setUpdateTime(new Date());
			getFacade().update(user);
			setMessage(request, "Update password successful");
		} else {
			setErrorMessage(request, "Old password is not correct");
		}
		return doGetEditPassword();
	}

	/**
	 * Do post signin.
	 *
	 * @return the string
	 */
	public String doPostSignin() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		//
		String userName = getInputUserName();
		String password = getInputPassword();
		User user = getNewEntity();
		user.setUserName(userName);
		user.setPassword(password);
		user = getFacade().signin(user);
		if (user != null) {
			setSessionUser(request, user);
			String isRememberMe = getCheckboxRememberMe();
			if ("Y".equalsIgnoreCase(isRememberMe)) {
				CookieUtil.setCookie(response, REMEBER_ME_COOKIE, String.valueOf(user.getId()));
			}
			return doGetViewDashboard();
		} else {
			setErrorMessage(request, "User name or password is not correct");
			return ACTION_SIGNIN;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#getNewEntity()
	 */
	@Override
	public User getNewEntity() {
		return new User();
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#getFacade()
	 */
	@Override
	public UserFacade getFacade() {
		return FacadeServiceLocator.getInstance().getUserFacade();
	}
}
