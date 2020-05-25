/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.tera.v2.report.helper;

import java.util.ArrayList;
import java.util.List;

import sg.edu.ntu.tera.v2.report.dto.IndividualClaimSummaryReportDto;

/**
 * The Class IndividualClaimSummaryReportHelper.
 */
public class IndividualClaimSummaryReportHelper extends ReportHelper {
	/** The helper. */
	private static IndividualClaimSummaryReportHelper helper = new IndividualClaimSummaryReportHelper();

	/**
	 * Gets the single instance of IndividualClaimSummaryReportHelper.
	 *
	 * @return single instance of IndividualClaimSummaryReportHelper
	 */
	public static IndividualClaimSummaryReportHelper getInstance() {
		return helper;
	}

	/**
	 * Instantiates a new individual claim summary report helper.
	 */
	private IndividualClaimSummaryReportHelper() {
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.helper.ReportHelper#getReportContentList(java.util.List)
	 */
	@Override
	public List<List<String>> getReportContentList(List<Object> content) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (content != null) {
			List<String> title = new ArrayList<String>();
			title.add("Year");
			title.add("Month");
			title.add("Department");
			title.add("Status");
			title.add("Requset By");
			title.add("By Manager");
			title.add("Approval Time");
			title.add("By Financial");
			title.add("Approval Time");
			title.add("Id");
			title.add("Create Time");
			title.add("Update Time");
			title.add("Item Count");
			title.add("Total");
			result.add(title);
			for (Object row : content) {
				IndividualClaimSummaryReportDto d = (IndividualClaimSummaryReportDto) row;
				List<String> r = new ArrayList<String>();
				r.add(d.getYear());
				r.add(d.getMonth());
				r.add(d.getDepartment());
				r.add(d.getStatus());
				r.add(d.getUser());
				r.add(d.getManager());
				r.add(d.getManagerApprovalTime() == null ? "" : TIME_FORMATOR.format(d.getManagerApprovalTime()));
				r.add(d.getFinancial());
				r.add(d.getFinancialApprovalTime() == null ? "" : TIME_FORMATOR.format(d.getFinancialApprovalTime()));
				r.add(String.valueOf(d.getId()));
				r.add(d.getCreateTime() == null ? "" : TIME_FORMATOR.format(d.getCreateTime()));
				r.add(d.getUpdateTime() == null ? "" : TIME_FORMATOR.format(d.getUpdateTime()));
				r.add(String.valueOf(d.getItemCount()));
				r.add(String.valueOf(d.getTotal()));
				result.add(r);
			}
		}
		return result;
	}
}
