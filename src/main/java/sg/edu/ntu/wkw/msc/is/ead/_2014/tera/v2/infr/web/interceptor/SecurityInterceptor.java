package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.web.interceptor;

import java.util.Map;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.User;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.web.action.UserAction;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.web.action.UserRoot;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * The Class SecurityInterceptor.
 */
@SuppressWarnings("serial")
public class SecurityInterceptor extends AbstractInterceptor {
	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<?, ?> session = actionInvocation.getInvocationContext().getSession();
		//
		if (UserAction.class == actionInvocation.getAction().getClass()) {
			ActionProxy proxy = actionInvocation.getProxy();
			String method = proxy.getMethod();
			method = method == null ? "" : method;
			if (method.contains("Signin") || method.contains("Signout")) {
				return actionInvocation.invoke();
			}
		}
		User sessionUser = (User) session.get("user");
		if (sessionUser == null) {
			return UserRoot.ACTION_SIGNIN;
		} else {
			return actionInvocation.invoke();
		}
	}
}
