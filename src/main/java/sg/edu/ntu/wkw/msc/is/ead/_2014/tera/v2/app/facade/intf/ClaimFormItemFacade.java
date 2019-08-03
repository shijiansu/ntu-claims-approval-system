/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf;

import java.util.List;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.dao.intf.ClaimFormItemDao;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.ClaimFormItem;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade;

/**
 * The Interface ClaimFormItemFacade.
 */
public interface ClaimFormItemFacade extends BaseFacade<ClaimFormItem, ClaimFormItemDao> {
	/**
	 * Creates the and update total.
	 *
	 * @param claimFormItem the claim form item
	 */
	public abstract void createAndUpdateTotal(ClaimFormItem claimFormItem);

	/**
	 * Delete and update total.
	 *
	 * @param long1 the long1
	 */
	public abstract void deleteAndUpdateTotal(Long long1);

	/**
	 * Gets the all items by form id.
	 *
	 * @param claimFormId the claim form id
	 * @return the all items by form id
	 */
	public abstract List<ClaimFormItem> getAllItemsByFormId(Long claimFormId);

	/**
	 * Update and update total.
	 *
	 * @param claimFormItem the claim form item
	 */
	public abstract void updateAndUpdateTotal(ClaimFormItem claimFormItem);
}
