package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.web.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.Department;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.User;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.common.DateUtil;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao.BaseDao;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.FacadeServiceLocator;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.model.BaseEntity;

import com.opensymphony.xwork2.ActionSupport;

/**
 * The Class BaseAction.
 *
 * @param <E> the element type
 * @param <D> the generic type
 * @param <F> the generic type
 */
public abstract class BaseAction<E extends BaseEntity, D extends BaseDao<E>, F extends BaseFacade<E, D>> extends ActionSupport {
	/** The Constant ACTION_AJAX. */
	public static final String ACTION_AJAX = "ajax";

	/** The Constant ACTION_CREATE. */
	public static final String ACTION_CREATE = "create";

	/** The Constant ACTION_DELETE. */
	public static final String ACTION_DELETE = "delete";

	/** The Constant ACTION_EDIT. */
	public static final String ACTION_EDIT = "edit";

	/** The Constant ACTION_LIST. */
	public static final String ACTION_LIST = "list";

	/** The Constant ACTION_VIEW. */
	public static final String ACTION_VIEW = "view";

	/** The Constant REMEBER_ME_COOKIE. */
	public static final String REMEBER_ME_COOKIE = "REMEBER_ME";

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 694995742768899247L;

	/**
	 * Do get create.
	 *
	 * @return the string
	 */
	public abstract String doGetCreate();

	/**
	 * Do get delete.
	 *
	 * @return the string
	 */
	public abstract String doGetDelete();

	/**
	 * Do get edit.
	 *
	 * @return the string
	 */
	public abstract String doGetEdit();

	/**
	 * Do get list.
	 *
	 * @return the string
	 */
	public abstract String doGetList();

	/**
	 * Do get view.
	 *
	 * @return the string
	 */
	public abstract String doGetView();

	/**
	 * Do post create.
	 *
	 * @return the string
	 */
	public abstract String doPostCreate();

	/**
	 * Do post edit.
	 *
	 * @return the string
	 */
	public abstract String doPostEdit();

	// move to MenuInterceptor
	// /** The Constant MENU_MAP. */
	// public static final Map<String, String> MENU_MAP = new HashMap<String, String>() {
	// private static final long serialVersionUID = 1923544565472627384L;
	// {
	// put("/user/signin", "1");
	// put("/user/viewDashboard", "1");
	// put("/user/expireCookie", "1");
	// put("/user/list", "2");
	// put("/department/list", "3");
	// put("/claimForm/list", "4");
	// put("/claimForm/monitor", "5");
	// put("/report/list", "6");
	// put("/user/editPassword", "7");
	// }
	// };
	/**
	 * Gets the facade.
	 *
	 * @return the facade
	 */
	public abstract F getFacade();

	/**
	 * Gets the new entity.
	 *
	 * @return the new entity
	 */
	public abstract E getNewEntity();

	/**
	 * Gets the session user.
	 *
	 * @param request the request
	 * @return the session user
	 */
	public User getSessionUser(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		User sessionUser = (User) session.getAttribute("user");
		return sessionUser;
	}

	/**
	 * Removes the session user.
	 *
	 * @param request the request
	 */
	public void removeSessionUser(HttpServletRequest request) {
		request.getSession(true).removeAttribute("user");
	}

	/**
	 * Sets the access right.
	 *
	 * @param user the new access right
	 */
	private void setAccessRight(User user) {
		boolean isFinancial = false;
		boolean isApprover = false;
		Department department = user.getDepartment();
		// check is department approver
		if (department != null) {
			isApprover = user.equals(department.getManager());
			isFinancial = "Y".equalsIgnoreCase(department.getOperationArea().getIsFinancial());
			// check is financial approver
			if (!isApprover) {
				isApprover = isFinancial;
			}
		}
		user.setIsFinancial(isFinancial);
		user.setIsApprover(isApprover);
	}

	// move to MenuInterceptor
	// /**
	// * Sets the active menu.
	// *
	// * @param request the new active menu
	// */
	// public void setActiveMenu(HttpServletRequest request) {
	// String input = request.getServletPath();
	// String result = MENU_MAP.get(input);
	// if (result != null) {
	// request.getSession(true).setAttribute("activeMenu", result);
	// }
	// }
	/**
	 * Sets the claim types.
	 *
	 * @param request the new claim types
	 */
	public void setClaimTypes(HttpServletRequest request) {
		request.setAttribute("claimTypes", FacadeServiceLocator.getInstance().getClaimTypeFacade().selectAll(new String[] { "id" }, true));
	}

	/**
	 * Sets the departments.
	 *
	 * @param request the new departments
	 */
	public void setDepartments(HttpServletRequest request) {
		request.setAttribute("departments", FacadeServiceLocator.getInstance().getDepartmentFacade().selectAll(new String[] { "departmentName" }, true));
	}

	/**
	 * Sets the error message.
	 *
	 * @param request the request
	 * @param message the message
	 */
	public void setErrorMessage(HttpServletRequest request, String message) {
		// struts 2 overridden the request.getAttribute("errors")
		// @SuppressWarnings("unchecked")
		// List<String> messages = (List<String>) request.getAttribute("errors");
		// if (messages == null) {
		// messages = new ArrayList<String>();
		// }
		// messages.add(message);
		// request.setAttribute("errors", messages);
		//
		@SuppressWarnings("unchecked")
		Map<String, String> messages = (Map<String, String>) request.getAttribute("errors");
		if (messages == null) {
			messages = new LinkedHashMap<>();
		}
		messages.put(message, message);
		request.setAttribute("errors", messages);
	}

	/**
	 * Sets the form statuses.
	 *
	 * @param request the new form statuses
	 */
	public void setFormStatuses(HttpServletRequest request) {
		request.setAttribute("formStatuses", FacadeServiceLocator.getInstance().getFormStatusFacade().selectAll(new String[] { "id" }, true));
	}

	/**
	 * Sets the message.
	 *
	 * @param request the request
	 * @param message the message
	 */
	public void setMessage(HttpServletRequest request, String message) {
		// struts 2 overridden the request.getAttribute("errors")
		// @SuppressWarnings("unchecked")
		// List<String> messages = (List<String>) request.getAttribute("messages");
		// if (messages == null) {
		// messages = new ArrayList<String>();
		// }
		// messages.add(message);
		// request.setAttribute("messages", messages);
		//
		@SuppressWarnings("unchecked")
		Map<String, String> messages = (Map<String, String>) request.getAttribute("messages");
		if (messages == null) {
			messages = new LinkedHashMap<>();
		}
		messages.put(message, message);
		request.setAttribute("messages", messages);
	}

	/**
	 * Sets the months.
	 *
	 * @param request the new months
	 */
	public void setMonths(HttpServletRequest request) {
		request.setAttribute("months", DateUtil.MONTHS);
	}

	/**
	 * Sets the operation areas.
	 *
	 * @param request the new operation areas
	 */
	public void setOperationAreas(HttpServletRequest request) {
		request.setAttribute("operationAreas", FacadeServiceLocator.getInstance().getOperationAreaFacade().selectAll(new String[] { "areaName" }, true));
	}

	/**
	 * Sets the regions.
	 *
	 * @param request the new regions
	 */
	public void setRegions(HttpServletRequest request) {
		request.setAttribute("regions", FacadeServiceLocator.getInstance().getRegionFacade().selectAll(new String[] { "regionName" }, true));
	}

	/**
	 * Sets the session user.
	 *
	 * @param request the request
	 * @param user the user
	 */
	public void setSessionUser(HttpServletRequest request, User user) {
		HttpSession session = request.getSession(true);
		setAccessRight(user);
		User sessionUser = new User();
		sessionUser.setId(user.getId());
		sessionUser.setUserName(user.getUserName());
		sessionUser.setFirstName(user.getFirstName());
		sessionUser.setLastName(user.getLastName());
		sessionUser.setIsAdmin(user.getIsAdmin());
		sessionUser.setIsApprover(user.getIsApprover());
		sessionUser.setIsFinancial(user.getIsFinancial());
		session.setAttribute("user", sessionUser);
	}

	/**
	 * Sets the users.
	 *
	 * @param request the new users
	 */
	public void setUsers(HttpServletRequest request) {
		request.setAttribute("users", FacadeServiceLocator.getInstance().getUserFacade().selectAll(new String[] { "firstName", "lastName" }, true));
	}

	/**
	 * Sets the years.
	 *
	 * @param request the new years
	 */
	public void setYears(HttpServletRequest request) {
		List<Integer> years = new ArrayList<>();
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = currentYear; i > currentYear - 4; i--) {
			years.add(i);
		}
		request.setAttribute("years", years);
	}
}
