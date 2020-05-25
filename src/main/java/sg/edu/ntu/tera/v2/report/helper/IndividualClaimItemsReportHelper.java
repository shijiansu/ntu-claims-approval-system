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

import sg.edu.ntu.tera.v2.report.dto.IndividualClaimItemsReportDto;

/**
 * The Class IndividualClaimItemsReportHelper.
 */
public class IndividualClaimItemsReportHelper extends ReportHelper {
	/** The helper. */
	private static IndividualClaimItemsReportHelper helper = new IndividualClaimItemsReportHelper();

	/**
	 * Gets the single instance of IndividualClaimItemsReportHelper.
	 *
	 * @return single instance of IndividualClaimItemsReportHelper
	 */
	public static IndividualClaimItemsReportHelper getInstance() {
		return helper;
	}

	/**
	 * Instantiates a new individual claim items report helper.
	 */
	private IndividualClaimItemsReportHelper() {
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.helper.ReportHelper#getReportContentList(java.util.List)
	 */
	@Override
	public List<List<String>> getReportContentList(List<Object> content) {
		List<List<String>> result = new ArrayList<List<String>>();
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
		title.add("Total");
		title.add("Create Time");
		title.add("Update Time");
		title.add("Type");
		title.add("Claim Date");
		title.add("Description");
		title.add("Amount");
		result.add(title);
		if (content != null) {
			for (Object row : content) {
				IndividualClaimItemsReportDto d = (IndividualClaimItemsReportDto) row;
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
				r.add(String.valueOf(d.getTotal()));
				r.add(d.getCreateTime() == null ? "" : TIME_FORMATOR.format(d.getCreateTime()));
				r.add(d.getUpdateTime() == null ? "" : TIME_FORMATOR.format(d.getUpdateTime()));
				r.add(d.getItemFormType());
				r.add(d.getItemCliamDate() == null ? "" : DATE_FORMATOR.format(d.getItemCliamDate()));
				r.add(d.getItemDescription());
				r.add(String.valueOf(d.getItemAmout()));
				result.add(r);
			}
		}
		return result;
	}
}
