/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.model;

import java.io.Serializable;

/**
 * The Class BaseEntity.
 */
public abstract class BaseEntity implements Serializable {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4660280479631809588L;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public abstract Long getId();
}
