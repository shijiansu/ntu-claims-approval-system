/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.tera.v2.app.dao;

import sg.edu.ntu.tera.v2.app.model.Region;
import sg.edu.ntu.tera.v2.infr.dao.BaseDaoBean;

/**
 * The Class RegionDaoBean.
 */
public class RegionDaoBean extends BaseDaoBean<Region> implements RegionDao {
	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao.BaseDao#getEntityClass()
	 */
	public Class<Region> getEntityClass() {
		return Region.class;
	}
}
