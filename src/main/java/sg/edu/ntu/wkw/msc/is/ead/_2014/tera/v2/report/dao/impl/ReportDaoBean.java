/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.dao.impl;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao.BaseDaoBean;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.dao.intf.ReportDao;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.model.Report;

/**
 * The Class ReportDaoBean.
 */
public class ReportDaoBean extends BaseDaoBean<Report> implements ReportDao {
	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao.BaseDao#getEntityClass()
	 */
	public Class<Report> getEntityClass() {
		return Report.class;
	}
}
