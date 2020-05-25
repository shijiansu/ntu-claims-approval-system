/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.tera.v2.app.facade;

import java.util.List;

import sg.edu.ntu.tera.v2.infr.facade.BaseFacadeBean;
import sg.edu.ntu.tera.v2.infr.facade.FacadeServiceLocator;
import sg.edu.ntu.tera.v2.app.dao.ClaimFormItemDaoBean;
import sg.edu.ntu.tera.v2.app.dao.ClaimFormItemDao;
import sg.edu.ntu.tera.v2.app.model.ClaimForm;
import sg.edu.ntu.tera.v2.app.model.ClaimFormItem;

/**
 * The Class ClaimFormItemFacadeBean.
 */
public class ClaimFormItemFacadeBean extends
    BaseFacadeBean<ClaimFormItem, ClaimFormItemDao> implements ClaimFormItemFacade {
	/** The claim form item dao. */
	private final ClaimFormItemDao claimFormItemDao = new ClaimFormItemDaoBean();

	/*
	 * (non-Javadoc)
	 * @see
	 * sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormItemFacade#createAndUpdateTotal(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app
	 * .model.ClaimFormItem)
	 */
	public void createAndUpdateTotal(ClaimFormItem claimFormItem) {
		ClaimForm claimForm = claimFormItem.getClaimForm();
		insert(claimFormItem);
		FacadeServiceLocator.getInstance().getClaimFormFacade().resetFromRejectStatus(claimForm);
		FacadeServiceLocator.getInstance().getClaimFormFacade().updateTotal(claimForm);
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormItemFacade#deleteAndUpdateTotal(java.lang.Long)
	 */
	public void deleteAndUpdateTotal(Long id) {
		ClaimFormItem claimFormItem = selectById(id);
		ClaimForm claimForm = claimFormItem.getClaimForm();
		delete(id);
		FacadeServiceLocator.getInstance().getClaimFormFacade().resetFromRejectStatus(claimForm);
		FacadeServiceLocator.getInstance().getClaimFormFacade().updateTotal(claimForm);
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormItemFacade#getAllItemsByFormId(java.lang.Long)
	 */
	public List<ClaimFormItem> getAllItemsByFormId(Long claimFormId) {
		return getDao().getQueryResult("ClaimFormItem.getAllItemsByFormId", new Object[] { claimFormId });
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade#getDao()
	 */
	public ClaimFormItemDao getDao() {
		return claimFormItemDao;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormItemFacade#updateAndUpdateTotal(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app
	 * .model.ClaimFormItem)
	 */
	public void updateAndUpdateTotal(ClaimFormItem claimFormItem) {
		ClaimForm claimForm = claimFormItem.getClaimForm();
		update(claimFormItem);
		FacadeServiceLocator.getInstance().getClaimFormFacade().resetFromRejectStatus(claimForm);
		FacadeServiceLocator.getInstance().getClaimFormFacade().updateTotal(claimForm);
	}
}
