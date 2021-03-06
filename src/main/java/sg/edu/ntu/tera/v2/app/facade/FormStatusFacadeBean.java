/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.tera.v2.app.facade;

import sg.edu.ntu.tera.v2.infr.facade.BaseFacadeBean;
import sg.edu.ntu.tera.v2.app.dao.FormStatusDaoBean;
import sg.edu.ntu.tera.v2.app.dao.FormStatusDao;
import sg.edu.ntu.tera.v2.app.model.FormStatus;

/**
 * The Class FormStatusFacadeBean.
 */
public class FormStatusFacadeBean extends BaseFacadeBean<FormStatus, FormStatusDao> implements FormStatusFacade {
	/** The form status dao. */
	private final FormStatusDao formStatusDao = new FormStatusDaoBean();

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade#getDao()
	 */
	public FormStatusDao getDao() {
		return formStatusDao;
	}
}
