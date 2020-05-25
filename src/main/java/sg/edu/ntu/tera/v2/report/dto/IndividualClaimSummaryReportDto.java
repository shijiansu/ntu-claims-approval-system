/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.tera.v2.report.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * The Class IndividualClaimSummaryReportDto.
 */
public class IndividualClaimSummaryReportDto implements ReportDto {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2231867154239342585L;

	/** The create time. */
	private Date createTime;

	/** The department. */
	private String department;

	/** The financial. */
	private String financial;

	/** The financial approval time. */
	private Date financialApprovalTime;

	/** The id. */
	private int id;

	/** The item count. */
	private BigInteger itemCount;

	/** The manager. */
	private String manager;

	/** The manager approval time. */
	private Date managerApprovalTime;

	/** The month. */
	private String month;

	/** The status. */
	private String status;

	/** The total. */
	private BigDecimal total;

	/** The update time. */
	private Date updateTime;

	/** The user. */
	private String user;

	/** The year. */
	private String year;

	/**
	 * Gets the creates the time.
	 *
	 * @return the creates the time
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * Gets the department.
	 *
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Gets the financial.
	 *
	 * @return the financial
	 */
	public String getFinancial() {
		return financial;
	}

	/**
	 * Gets the financial approval time.
	 *
	 * @return the financial approval time
	 */
	public Date getFinancialApprovalTime() {
		return financialApprovalTime;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the item count.
	 *
	 * @return the item count
	 */
	public BigInteger getItemCount() {
		return itemCount;
	}

	/**
	 * Gets the manager.
	 *
	 * @return the manager
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * Gets the manager approval time.
	 *
	 * @return the manager approval time
	 */
	public Date getManagerApprovalTime() {
		return managerApprovalTime;
	}

	/**
	 * Gets the month.
	 *
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}

	/**
	 * Gets the update time.
	 *
	 * @return the update time
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Sets the creates the time.
	 *
	 * @param createTime the new creates the time
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * Sets the department.
	 *
	 * @param department the new department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * Sets the financial.
	 *
	 * @param financial the new financial
	 */
	public void setFinancial(String financial) {
		this.financial = financial;
	}

	/**
	 * Sets the financial approval time.
	 *
	 * @param financialApprovalTime the new financial approval time
	 */
	public void setFinancialApprovalTime(Date financialApprovalTime) {
		this.financialApprovalTime = financialApprovalTime;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets the item count.
	 *
	 * @param itemCount the new item count
	 */
	public void setItemCount(BigInteger itemCount) {
		this.itemCount = itemCount;
	}

	/**
	 * Sets the manager.
	 *
	 * @param manager the new manager
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	/**
	 * Sets the manager approval time.
	 *
	 * @param managerApprovalTime the new manager approval time
	 */
	public void setManagerApprovalTime(Date managerApprovalTime) {
		this.managerApprovalTime = managerApprovalTime;
	}

	/**
	 * Sets the month.
	 *
	 * @param month the new month
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Sets the total.
	 *
	 * @param total the new total
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	/**
	 * Sets the update time.
	 *
	 * @param updateTime the new update time
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Sets the year.
	 *
	 * @param year the new year
	 */
	public void setYear(String year) {
		this.year = year;
	}
}
