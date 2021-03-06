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
import sg.edu.ntu.tera.v2.app.dao.RegionDaoBean;
import sg.edu.ntu.tera.v2.app.dao.RegionDao;
import sg.edu.ntu.tera.v2.app.model.Region;

/**
 * The Class RegionFacadeBean.
 */
public class RegionFacadeBean extends BaseFacadeBean<Region, RegionDao> implements RegionFacade {
	/** The region dao. */
	private final RegionDao regionDao = new RegionDaoBean();

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade#getDao()
	 */
	public RegionDao getDao() {
		return regionDao;
	}
}
