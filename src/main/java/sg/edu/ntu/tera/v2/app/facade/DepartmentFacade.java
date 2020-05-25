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
import sg.edu.ntu.tera.v2.app.dao.DepartmentDao;
import sg.edu.ntu.tera.v2.app.model.Department;
import sg.edu.ntu.tera.v2.app.model.User;

/**
 * The Interface DepartmentFacade.
 */
public interface DepartmentFacade extends BaseFacade<Department, DepartmentDao> {
	/**
	 * Delete department with users.
	 *
	 * @param id the id
	 */
	public abstract void deleteDepartmentWithUsers(Long id);

	/**
	 * Gets the all financial departments.
	 *
	 * @return the all financial departments
	 */
	public abstract List<Department> getAllFinancialDepartments();

	/**
	 * Gets the current department manager.
	 *
	 * @param user the user
	 * @return the current department manager
	 */
	public abstract User getCurrentDepartmentManager(User user);

	/**
	 * Gets the department by name.
	 *
	 * @param departmentName the department name
	 * @return the department by name
	 */
	public abstract Department getDepartmentByName(String departmentName);
}
