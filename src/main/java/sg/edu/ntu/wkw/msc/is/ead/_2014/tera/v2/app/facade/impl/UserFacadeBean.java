/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.impl;

import java.util.List;
import java.util.Random;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.dao.impl.UserDaoBean;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.dao.intf.UserDao;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.UserFacade;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.User;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacadeBean;

/**
 * The Class UserFacadeBean.
 */
public class UserFacadeBean extends BaseFacadeBean<User, UserDao> implements UserFacade {
	/** The user dao. */
	private final UserDao userDao = new UserDaoBean();

	/*
	 * (non-Javadoc)
	 * @see
	 * sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.UserFacade#createUserWithPassword(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model
	 * .User)
	 */
	public User createUserWithPassword(User user) {
		user.setPassword(getRandomPassword());
		insert(user);
		return user;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade#getDao()
	 */
	public UserDao getDao() {
		return userDao;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.UserFacade#getRandomPassword()
	 */
	public String getRandomPassword() {
		Random rd = new Random();
		String password = "";
		int getRandomNumber;
		do {
			getRandomNumber = Math.abs(rd.nextInt()) % 10 + 48;
			char num1 = (char) getRandomNumber;
			String dn = Character.toString(num1);
			password += dn;
		} while (password.length() < 6);
		return password;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.UserFacade#getUnAssignUsers()
	 */
	public List<User> getUnAssignUsers() {
		return getDao().getQueryResult("User.getUnAssignUsers", null);
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.UserFacade#getUserByName(java.lang.String)
	 */
	public User getUserByName(String userName) {
		return getDao().getQuerySingleResult("User.getUserByName", new Object[] { userName });
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.UserFacade#getUsersByDepartment(java.lang.Long)
	 */
	public List<User> getUsersByDepartment(Long departmentId) {
		return getDao().getQueryResult("User.getUsersByDepartment", new Object[] { departmentId });
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.UserFacade#signin(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.User)
	 */
	public User signin(User user) {
		return getDao().getQuerySingleResult("User.signin", new Object[] { user.getUserName(), user.getPassword() });
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.UserFacade#varifyUser(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.User)
	 */
	public User varifyUser(User user) {
		return getDao().getQuerySingleResult("User.varifyUser", new Object[] { user.getId(), user.getPassword() });
	}
}
