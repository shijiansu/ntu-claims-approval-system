/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.dao.impl;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.dao.intf.ClaimTypeDao;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.ClaimType;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao.BaseDaoBean;

/**
 * The Class ClaimTypeDaoBean.
 */
public class ClaimTypeDaoBean extends BaseDaoBean<ClaimType> implements ClaimTypeDao {
	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao.BaseDao#getEntityClass()
	 */
	public Class<ClaimType> getEntityClass() {
		return ClaimType.class;
	}
}
