/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Class CookieUtil.
 */
public class CookieUtil {
	/**
	 * The Enum COOKIE_EXPIRE.
	 */
	public enum COOKIE_EXPIRE {
		/** The at end of session. */
		AT_END_OF_SESSION(-1),
		/** The now. */
		NOW(0),
		/** The one week. */
		ONE_WEEK(60 * 60 * 24 * 7);
		/** The value. */
		int value = 0;

		/**
		 * Instantiates a new cookie expire.
		 *
		 * @param value the value
		 */
		private COOKIE_EXPIRE(int value) {
			this.value = value;
		}
	}

	/**
	 * Adds the cookie into response.
	 *
	 * @param response the response
	 * @param cookie the cookie
	 */
	private static void addCookieIntoResponse(HttpServletResponse response, Cookie cookie) {
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	/**
	 * Delete all cookie.
	 *
	 * @param request the request
	 * @param response the response
	 */
	public static void deleteAllCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = getAllCookie(request);
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				deleteCookie(response, cookie);
			}
		}
	}

	/**
	 * Delete cookie.
	 *
	 * @param request the request
	 * @param response the response
	 * @param cookieName the cookie name
	 */
	public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
		Cookie cookie = getCookie(request, cookieName);
		deleteCookie(response, cookie);
	}

	/**
	 * Delete cookie.
	 *
	 * @param response the response
	 * @param cookie the cookie
	 */
	public static void deleteCookie(HttpServletResponse response, Cookie cookie) {
		if (cookie != null) {
			cookie.setMaxAge(COOKIE_EXPIRE.NOW.value);
			addCookieIntoResponse(response, cookie);
		}
	}

	/**
	 * Gets the all cookie.
	 *
	 * @param request the request
	 * @return the all cookie
	 */
	public static Cookie[] getAllCookie(HttpServletRequest request) {
		return request.getCookies();
	}

	/**
	 * Gets the cookie.
	 *
	 * @param request the request
	 * @param cookieName the cookie name
	 * @return the cookie
	 */
	public static Cookie getCookie(HttpServletRequest request, String cookieName) {
		Cookie result = null;
		if (null == cookieName) {
		} else {
			Cookie[] cookies = getAllCookie(request);
			if (null != cookies) {
				for (Cookie cookie : cookies) {
					if (cookieName.equals(cookie.getName())) {
						result = cookie;
						break;
					}
				}
			}
		}
		return result;
	}

	/**
	 * Sets the cookie.
	 *
	 * @param response the response
	 * @param cookieName the cookie name
	 * @param cookieValue the cookie value
	 */
	public static void setCookie(HttpServletResponse response, String cookieName, String cookieValue) {
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setMaxAge(COOKIE_EXPIRE.ONE_WEEK.value);
		addCookieIntoResponse(response, cookie);
	}
}
