package sg.edu.ntu.tera.v2.infr.web.interceptor;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * The Class MenuInterceptor.
 */
@SuppressWarnings("serial")
public class MenuInterceptor extends AbstractInterceptor {
	/** The Constant MENU_MAP. */
	public static final Map<String, String> MENU_MAP = new HashMap<String, String>() {
		private static final long serialVersionUID = 1923544565472627384L;
		{
			put("/UserAction/doPostSignin", "1");
			put("/UserAction/doGetViewDashboard", "1");
			put("/UserAction/doGetExpireCookie", "1");
			put("/UserAction/doGetList", "2");
			put("/DepartmentAction/doGetList", "3");
			put("/ClaimFormAction/doGetList", "4");
			put("/ClaimFormAction/doGetMonitor", "5");
			put("/ReportAction/doGetList", "6");
			put("/UserAction/doGetEditPassword", "7");
			put("/UserAction/doPostEditPassword", "7");
		}
	};

	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();

		Class<?> action = actionInvocation.getAction().getClass();

		if (action != null) {
			ActionProxy proxy = actionInvocation.getProxy();
			String method = proxy.getMethod();
			method = method == null ? "" : method;
			setActiveMenu(action, method, session);
		}
		return actionInvocation.invoke();
	}

	/**
	 * Sets the active menu.
	 *
	 * @param action the action
	 * @param method the method
	 * @param session the session
	 */
	public void setActiveMenu(Class<?> action, String method, Map<String, Object> session) {
		String result = MENU_MAP.get("/" + action.getSimpleName() + "/" + method);
		if (result != null) {
			session.put("activeMenu", result);
		}
	}
}
