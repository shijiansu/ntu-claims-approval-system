/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 *
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.tera.v2.report.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sg.edu.ntu.tera.v2.infr.model.BaseEntity;

/**
 * The Class Report.
 */
public class Report extends BaseEntity {
	/** The Constant REPORT_INDIVIDUAL_CLAIM_ITEMS. */
	public static final transient Long REPORT_INDIVIDUAL_CLAIM_ITEMS = 2L;

	/** The Constant REPORT_INDIVIDUAL_CLAIM_SUM. */
	public static final transient Long REPORT_INDIVIDUAL_CLAIM_SUM = 1L;

	/** The Constant REPORT_NAMES. */
	public static final transient Map<Long, String> REPORT_NAMES = new HashMap<Long, String>() {
		private static final long serialVersionUID = -5705384561035951778L;
		{
			put(REPORT_INDIVIDUAL_CLAIM_SUM, "Individual Claim Summary Report");
			put(REPORT_INDIVIDUAL_CLAIM_ITEMS, "Individual Claim Items Report");
		}
	};

	/** The Constant REPORT_QLS. */
	public static final transient Map<Long, String> REPORT_QLS = new HashMap<Long, String>() {
		private static final long serialVersionUID = -5171981211538289808L;
		{
			// add "//" at the end of lines to remain formated SQL in
			// Eclipse
      // ANY_VALUE() to block the this is incompatible with sql_mode=only_full_group_by in after mysql5.7 - ONLY_FULL_GROUP_BY default true
			put(REPORT_INDIVIDUAL_CLAIM_SUM, //
					"SELECT C.TRAVEL_OF_YEAR AS YEAR, C.TRAVEL_OF_MONTH AS MONTH, C.ID AS ID, C.TOTAL, " + //
							"F.FORM_STATUS AS STATUS, D.DEPT_NAME AS DEPARTMENT, " + //
							"RU.FIRST_NAME AS RU_FIRST_NAME, RU.LAST_NAME AS RU_LAST_NAME, " + //
							"MA.FIRST_NAME AS MA_FIRST_NAME, MA.LAST_NAME AS MA_LAST_NAME, C.APP_BY_MANAGER_TIME AS MA_TIME, " + //
							"ANY_VALUE(FA.FIRST_NAME) AS FA_FIRST_NAME, ANY_VALUE(FA.LAST_NAME) AS FA_LAST_NAME, C.APP_BY_FINANCIAL_TIME AS FA_TIME, " + //
							"C.CREATE_TIME, C.UPDATE_TIME, " + //
							"COUNT(CI.ID) AS CI_COUNT " + //
							"FROM CLAIM_FORM C " + //
							"LEFT JOIN MD_FORM_STATUS F ON F.ID = C.FORM_STATUS_ID " + //
							"LEFT JOIN DEPT D ON D.ID = C.DEPT_ID " + //
							"LEFT JOIN USERS RU ON RU.ID = C.USER_ID " + //
							"LEFT JOIN USERS MA ON MA.ID = C.APP_BY_MANAGER " + //
							"LEFT JOIN USERS FA ON F.ID = C. APP_BY_FINANCIAL " + //
							"LEFT JOIN CLAIM_FORM_ITEM CI ON CI.CLAIM_FORM_ID = C.ID " + //
							"WHERE " + //
							"(?1 = '' OR ?1 IS NULL OR RU.ID = ?1) " + //
							"AND " + //
							"(?2 = '' OR ?2 IS NULL OR C.TRAVEL_OF_YEAR = ?2) " + //
							"AND " + //
							"(?3 = '' OR ?3 IS NULL OR C.TRAVEL_OF_MONTH = ?3) " + //
							"AND " + //
							"(?4 = '' OR ?4 IS NULL OR F.ID = ?4) " + //
							"GROUP BY C.ID " + //
							"ORDER BY YEAR ASC, MONTH ASC, DEPARTMENT ASC, F.ID ASC, " + //
							"RU_FIRST_NAME ASC, RU_LAST_NAME ASC, " + //
							"MA_FIRST_NAME ASC, MA_LAST_NAME ASC, MA_TIME DESC, " + //
							"FA_FIRST_NAME ASC, FA_LAST_NAME ASC, FA_TIME DESC, " + //
							"ID ASC");
			// add "//" at the end of lines to remain formated SQL in
			// Eclipse
			put(REPORT_INDIVIDUAL_CLAIM_ITEMS, //
					"SELECT C.TRAVEL_OF_YEAR AS YEAR, C.TRAVEL_OF_MONTH AS MONTH, C.ID AS ID, C.TOTAL, " + //
							"F.FORM_STATUS AS STATUS, D.DEPT_NAME AS DEPARTMENT, " + //
							"RU.FIRST_NAME AS RU_FIRST_NAME, RU.LAST_NAME AS RU_LAST_NAME, " + //
							"MA.FIRST_NAME AS MA_FIRST_NAME, MA.LAST_NAME AS MA_LAST_NAME, C.APP_BY_MANAGER_TIME AS MA_TIME, " + //
							"FA.FIRST_NAME AS FA_FIRST_NAME, FA.LAST_NAME AS FA_LAST_TIME, C.APP_BY_FINANCIAL_TIME AS FA_TIME, " + //
							"C.CREATE_TIME, C.UPDATE_TIME, " + //
							"CI.CLAIM_DATE, TYPE.CLAIM_TYPE, CI.CLAIM_DESCRIPTION, CI.CLAIM_AMOUNT " + //
							"FROM CLAIM_FORM C " + //
							"LEFT JOIN MD_FORM_STATUS F ON F.ID = C.FORM_STATUS_ID " + //
							"LEFT JOIN DEPT D ON D.ID = C.DEPT_ID " + //
							"LEFT JOIN USERS RU ON RU.ID = C.USER_ID " + //
							"LEFT JOIN USERS MA ON MA.ID = C.APP_BY_MANAGER " + //
							"LEFT JOIN USERS FA ON F.ID = C. APP_BY_FINANCIAL " + //
							"LEFT JOIN CLAIM_FORM_ITEM CI ON CI.CLAIM_FORM_ID = C.ID " + //
							"LEFT JOIN MD_CLAIM_TYPE TYPE ON TYPE.ID = CI.CLAIM_TYPE_ID " + //
							"WHERE " + //
							"(?1 = '' OR ?1 IS NULL OR RU.ID = ?1) " + //
							"AND " + //
							"(?2 = '' OR ?2 IS NULL OR C.TRAVEL_OF_YEAR = ?2) " + //
							"AND " + //
							"(?3 = '' OR ?3 IS NULL OR C.TRAVEL_OF_MONTH = ?3) " + //
							"AND " + //
							"(?4 = '' OR ?4 IS NULL OR F.ID = ?4) " + //
							"ORDER BY YEAR ASC, MONTH ASC, DEPARTMENT ASC, F.ID ASC, " + //
							"RU_FIRST_NAME ASC, RU_LAST_NAME ASC, " + //
							"MA_FIRST_NAME ASC, MA_LAST_NAME ASC, MA_TIME DESC, " + //
							"FA_FIRST_NAME ASC, FA_LAST_TIME ASC, FA_TIME DESC, " + //
							"ID ASC, CI.CLAIM_TYPE_ID ASC, CI.CLAIM_DATE ASC"); //
		}
	};

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4844329532659023668L;

	/** The content. */
	private List<Object> content;

	/** The generate time. */
	private Date generateTime;

	/** The id. */
	private Long id;

	/** The report name. */
	private String reportName;

	/** The report params. */
	private List<Object> reportParams;

	/** The report short name. */
	private String reportShortName;

	/** The report type. */
	private String reportType;

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public List<Object> getContent() {
		return content;
	}

	/**
	 * Gets the generate time.
	 *
	 * @return the generate time
	 */
	public Date getGenerateTime() {
		return generateTime;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.model.BaseEntity#getId()
	 */
	@Override
	public Long getId() {
		return id;
	}

	/**
	 * Gets the report name.
	 *
	 * @return the report name
	 */
	public String getReportName() {
		return reportName;
	}

	/**
	 * Gets the report params.
	 *
	 * @return the report params
	 */
	public List<Object> getReportParams() {
		return reportParams;
	}

	/**
	 * Gets the report short name.
	 *
	 * @return the report short name
	 */
	public String getReportShortName() {
		return reportShortName;
	}

	/**
	 * Gets the report type.
	 *
	 * @return the report type
	 */
	public String getReportType() {
		return reportType;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(List<Object> content) {
		this.content = content;
	}

	/**
	 * Sets the generate time.
	 *
	 * @param generateTime the new generate time
	 */
	public void setGenerateTime(Date generateTime) {
		this.generateTime = generateTime;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Sets the report name.
	 *
	 * @param reportName the new report name
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	/**
	 * Sets the report params.
	 *
	 * @param reportParams the new report params
	 */
	public void setReportParams(List<Object> reportParams) {
		this.reportParams = reportParams;
	}

	/**
	 * Sets the report short name.
	 *
	 * @param reportShortName the new report short name
	 */
	public void setReportShortName(String reportShortName) {
		this.reportShortName = reportShortName;
	}

	/**
	 * Sets the report type.
	 *
	 * @param reportType the new report type
	 */
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
}
