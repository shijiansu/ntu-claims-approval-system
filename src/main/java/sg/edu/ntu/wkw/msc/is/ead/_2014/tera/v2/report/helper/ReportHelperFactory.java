/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.helper;

/**
 * A factory for creating ReportHelper objects.
 */
public class ReportHelperFactory {
	/**
	 * Gets the helper.
	 *
	 * @param reportId the report id
	 * @return the helper
	 */
	public static ReportHelper getHelper(Long reportId) {
		ReportHelper helper = null;
		if (reportId == 1) {
			helper = IndividualClaimSummaryReportHelper.getInstance();
		} else if (reportId == 2) {
			helper = IndividualClaimItemsReportHelper.getInstance();
		}
		return helper;
	}
}
