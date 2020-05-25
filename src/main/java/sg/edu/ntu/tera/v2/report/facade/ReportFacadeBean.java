/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.tera.v2.report.facade;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sg.edu.ntu.tera.v2.infr.dao.ResultSetPojo;
import sg.edu.ntu.tera.v2.infr.facade.BaseFacadeBean;
import sg.edu.ntu.tera.v2.report.dao.ReportDaoBean;
import sg.edu.ntu.tera.v2.report.dao.ReportDao;
import sg.edu.ntu.tera.v2.report.dto.IndividualClaimItemsReportDto;
import sg.edu.ntu.tera.v2.report.dto.IndividualClaimSummaryReportDto;
import sg.edu.ntu.tera.v2.report.model.Report;

/**
 * The Class ReportFacadeBean.
 */
public class ReportFacadeBean extends BaseFacadeBean<Report, ReportDao> implements ReportFacade {
	/** The report dao. */
	private final ReportDao reportDao = new ReportDaoBean();

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade#getDao()
	 */
	/**
	 * Gets the dao.
	 *
	 * @return the dao
	 */
	public ReportDao getDao() {
		return reportDao;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.facade.intf.ReportFacade#getReport(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.model.Report)
	 */
	/**
	 * Gets the report.
	 *
	 * @param report the report
	 * @return the report
	 */
	public Report getReport(Report report) {
		report.setReportName(Report.REPORT_NAMES.get(report.getId()));
		report.setReportShortName(report.getReportName().replace(" ", ""));
		report.setGenerateTime(new Date());
		List<ResultSetPojo> result = getDao().getNativeQueryResult(Report.REPORT_QLS.get(report.getId()), report.getReportParams().toArray());
		if (result != null) {
			List<Object> content = new ArrayList<Object>();
			for (ResultSetPojo resultSetPojo : result) {
				if (Report.REPORT_INDIVIDUAL_CLAIM_SUM.compareTo(report.getId()) == 0) {
					setIndividualClaimSummaryReport(content, resultSetPojo);
				} else if (Report.REPORT_INDIVIDUAL_CLAIM_ITEMS.compareTo(report.getId()) == 0) {
					setIndividualClaimItemReport(content, resultSetPojo);
				}
			}
			report.setContent(content);
		}
		return report;
	}

	/**
	 * Sets the default string.
	 *
	 * @param s the s
	 * @return the string
	 */
	private String setDefaultString(Object s) {
		String result = "";
		if (s != null) {
			if (s instanceof String) {
				if (!"NULL".equalsIgnoreCase((String) s)) {
					result = (String) s;
				}
			} else {
				result = s.toString();
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.facade.intf.ReportFacade#setIndividualClaimItemReport(java.util.List, java.lang.Object[)
	 */
	/**
	 * Sets the individual claim item report.
	 *
	 * @param content the content
	 * @param cells the cells
	 */
	public void setIndividualClaimItemReport(List<Object> content, ResultSetPojo cells) {
		IndividualClaimItemsReportDto row = new IndividualClaimItemsReportDto();
		if (cells != null) {
			row.setYear((String) cells.getValue().get(0));
			row.setMonth((String) cells.getValue().get(1));
			row.setId((Integer) cells.getValue().get(2));
			row.setTotal((BigDecimal) cells.getValue().get(3));
			row.setStatus((String) cells.getValue().get(4));
			row.setDepartment((String) cells.getValue().get(5));
			row.setUser(setDefaultString(cells.getValue().get(6)) + " " + setDefaultString(cells.getValue().get(7)));
			row.setUser(row.getUser().trim());
			row.setManager(setDefaultString(cells.getValue().get(8)) + " " + setDefaultString(cells.getValue().get(9)));
			row.setManager(row.getManager().trim());
			row.setManagerApprovalTime((Date) cells.getValue().get(10));
			row.setFinancial(setDefaultString(cells.getValue().get(11)) + " " + setDefaultString(cells.getValue().get(12)));
			row.setFinancial(row.getFinancial().trim());
			row.setFinancialApprovalTime((Date) cells.getValue().get(13));
			row.setCreateTime((Date) cells.getValue().get(14));
			row.setUpdateTime((Date) cells.getValue().get(15));
			row.setItemCliamDate((Date) cells.getValue().get(16));
			row.setItemFormType((String) cells.getValue().get(17));
			row.setItemDescription((String) cells.getValue().get(18));
			row.setItemAmout((BigDecimal) cells.getValue().get(19));
			row.setItemAmout(row.getItemAmout() == null ? BigDecimal.ZERO : row.getItemAmout());
			content.add(row);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.facade.intf.ReportFacade#setIndividualClaimSummaryReport(java.util.List,
	 * java.lang.Object[)
	 */
	/**
	 * Sets the individual claim summary report.
	 *
	 * @param content the content
	 * @param cells the cells
	 */
	public void setIndividualClaimSummaryReport(List<Object> content, ResultSetPojo cells) {
		IndividualClaimSummaryReportDto row = new IndividualClaimSummaryReportDto();
		if (cells != null) {
			row.setYear((String) cells.getValue().get(0));
			row.setMonth((String) cells.getValue().get(1));
			row.setId((Integer) cells.getValue().get(2));
			row.setTotal((BigDecimal) cells.getValue().get(3));
			row.setStatus((String) cells.getValue().get(4));
			row.setDepartment((String) cells.getValue().get(5));
			row.setUser(setDefaultString(cells.getValue().get(6)) + " " + setDefaultString(cells.getValue().get(7)));
			row.setUser(row.getUser().trim());
			row.setManager(setDefaultString(cells.getValue().get(8)) + " " + setDefaultString(cells.getValue().get(9)));
			row.setManager(row.getManager().trim());
			row.setManagerApprovalTime((Date) cells.getValue().get(10));
			row.setFinancial(setDefaultString(cells.getValue().get(11)) + " " + setDefaultString(cells.getValue().get(12)));
			row.setFinancial(row.getFinancial().trim());
			row.setFinancialApprovalTime((Date) cells.getValue().get(13));
			row.setCreateTime((Date) cells.getValue().get(14));
			row.setUpdateTime((Date) cells.getValue().get(15));
			row.setItemCount(BigInteger.valueOf((Long) cells.getValue().get(16)));
			content.add(row);
		}
	}
}
