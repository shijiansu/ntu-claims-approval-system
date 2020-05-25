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
import sg.edu.ntu.tera.v2.app.dao.ClaimTypeDaoBean;
import sg.edu.ntu.tera.v2.app.dao.ClaimTypeDao;
import sg.edu.ntu.tera.v2.app.model.ClaimType;

/**
 * The Class ClaimTypeFacadeBean.
 */
public class ClaimTypeFacadeBean extends BaseFacadeBean<ClaimType, ClaimTypeDao> implements ClaimTypeFacade {
	/** The claim type dao. */
	private final ClaimTypeDao claimTypeDao = new ClaimTypeDaoBean();

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade#getDao()
	 */
	public ClaimTypeDao getDao() {
		return claimTypeDao;
	}
}
