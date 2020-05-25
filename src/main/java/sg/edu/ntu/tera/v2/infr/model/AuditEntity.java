/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.tera.v2.infr.model;

import java.util.Date;

/**
 * The Class AuditEntity.
 */
public abstract class AuditEntity extends BaseEntity {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2997280638567275030L;

	/** The create by. */
	protected String createBy;

	/** The create time. */
	protected Date createTime;

	/** The update by. */
	protected String updateBy;

	/** The update time. */
	protected Date updateTime;

	/**
	 * Gets the creates the by.
	 *
	 * @return the creates the by
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * Gets the creates the time.
	 *
	 * @return the creates the time
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * Gets the update by.
	 *
	 * @return the update by
	 */
	public String getUpdateBy() {
		return updateBy;
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
	 * Inits the creat time.
	 */
	public void initCreatTime() {
		setCreateTime(new Date());
	}

	/**
	 * Inits the update time.
	 */
	public void initUpdateTime() {
		setUpdateTime(new Date());
	}

	/**
	 * Sets the creates the by.
	 *
	 * @param createBy the new creates the by
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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
	 * Sets the update by.
	 *
	 * @param updateBy the new update by
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * Sets the update time.
	 *
	 * @param updateTime the new update time
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
