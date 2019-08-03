/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.helper;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * The Class ReportHelper.
 */
public abstract class ReportHelper {
	/** The date formator. */
	public static SimpleDateFormat DATE_FORMATOR = new SimpleDateFormat("yyyy-MMM-dd");

	/** The time formator. */
	public static SimpleDateFormat TIME_FORMATOR = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");

	/**
	 * Gets the report content list.
	 *
	 * @param content the content
	 * @return the report content list
	 */
	public abstract List<List<String>> getReportContentList(List<Object> content);
}
