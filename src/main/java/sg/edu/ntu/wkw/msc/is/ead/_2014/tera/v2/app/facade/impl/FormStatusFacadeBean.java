/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.impl;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.dao.impl.FormStatusDaoBean;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.dao.intf.FormStatusDao;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.FormStatusFacade;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.FormStatus;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacadeBean;

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
