/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.facade.intf;

import java.util.List;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao.ResultSetPojo;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.dao.intf.ReportDao;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.model.Report;

/**
 * The Interface ReportFacade.
 */
public interface ReportFacade extends BaseFacade<Report, ReportDao> {
	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade#getDao()
	 */
	public abstract ReportDao getDao();

	/**
	 * Gets the report.
	 *
	 * @param report the report
	 * @return the report
	 */
	public abstract Report getReport(Report report);

	/**
	 * Sets the individual claim item report.
	 *
	 * @param content the content
	 * @param cells the cells
	 */
	public abstract void setIndividualClaimItemReport(List<Object> content, ResultSetPojo cells);

	/**
	 * Sets the individual claim summary report.
	 *
	 * @param content the content
	 * @param cells the cells
	 */
	public abstract void setIndividualClaimSummaryReport(List<Object> content, ResultSetPojo cells);
}
