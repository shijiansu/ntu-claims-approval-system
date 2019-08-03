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

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.dao.impl.DepartmentDaoBean;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.dao.intf.DepartmentDao;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.DepartmentFacade;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.Department;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.User;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacadeBean;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.FacadeServiceLocator;

/**
 * The Class DepartmentFacadeBean.
 */
public class DepartmentFacadeBean extends BaseFacadeBean<Department, DepartmentDao> implements DepartmentFacade {
	/** The department dao. */
	private final DepartmentDao departmentDao = new DepartmentDaoBean();

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.DepartmentFacade#deleteDepartmentWithUsers(java.lang.Long)
	 */
	public void deleteDepartmentWithUsers(Long id) {
		List<User> userList = FacadeServiceLocator.getInstance().getUserFacade().getUsersByDepartment(id);
		if (userList != null) {
			for (User u : userList) {
				u.setDepartment(null);
				FacadeServiceLocator.getInstance().getUserFacade().update(u);
			}
		}
		delete(id);
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.DepartmentFacade#getAllFinancialDepartments()
	 */
	public List<Department> getAllFinancialDepartments() {
		return getDao().getQueryResult("Department.getFinancialDepartments", null);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.DepartmentFacade#getCurrentDepartmentManager(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2
	 * .app.model.User)
	 */
	public User getCurrentDepartmentManager(User user) {
		if (user.getDepartment() == null) {
			user = FacadeServiceLocator.getInstance().getUserFacade().selectById(user);
			if (user != null && user.getDepartment() != null && user.getDepartment().getManager() != null) {
				return user.getDepartment().getManager();
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade#getDao()
	 */
	public DepartmentDao getDao() {
		return departmentDao;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.DepartmentFacade#getDepartmentByName(java.lang.String)
	 */
	public Department getDepartmentByName(String departmentName) {
		return getDao().getQuerySingleResult("Department.getDepartmentByName", new Object[] { departmentName });
	}
}
