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
import sg.edu.ntu.tera.v2.app.dao.OperationAreaDaoBean;
import sg.edu.ntu.tera.v2.app.dao.OperationAreaDao;
import sg.edu.ntu.tera.v2.app.model.OperationArea;

/**
 * The Class OperationAreaFacadeBean.
 */
public class OperationAreaFacadeBean extends
    BaseFacadeBean<OperationArea, OperationAreaDao> implements OperationAreaFacade {
	/** The operation area dao. */
	private final OperationAreaDao operationAreaDao = new OperationAreaDaoBean();

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade#getDao()
	 */
	public OperationAreaDao getDao() {
		return operationAreaDao;
	}
}
