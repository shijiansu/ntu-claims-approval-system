/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.tera.v2.app.facade;

import java.util.List;

import sg.edu.ntu.tera.v2.infr.facade.BaseFacade;
import sg.edu.ntu.tera.v2.app.dao.UserDao;
import sg.edu.ntu.tera.v2.app.model.User;

/**
 * The Interface UserFacade.
 */
public interface UserFacade extends BaseFacade<User, UserDao> {
	/**
	 * Creates the user with password.
	 *
	 * @param user the user
	 * @return the user
	 */
	public abstract User createUserWithPassword(User user);

	/**
	 * Gets the random password.
	 *
	 * @return the random password
	 */
	public abstract String getRandomPassword();

	/**
	 * Gets the un assign users.
	 *
	 * @return the un assign users
	 */
	public abstract List<User> getUnAssignUsers();

	/**
	 * Gets the user by name.
	 *
	 * @param userName the user name
	 * @return the user by name
	 */
	public abstract User getUserByName(String userName);

	/**
	 * Gets the users by department.
	 *
	 * @param departmentId the department id
	 * @return the users by department
	 */
	public abstract List<User> getUsersByDepartment(Long departmentId);

	/**
	 * Signin.
	 *
	 * @param user the user
	 * @return the user
	 */
	public abstract User signin(User user);

	/**
	 * Varify user.
	 *
	 * @param user the user
	 * @return the user
	 */
	public abstract User varifyUser(User user);
}
