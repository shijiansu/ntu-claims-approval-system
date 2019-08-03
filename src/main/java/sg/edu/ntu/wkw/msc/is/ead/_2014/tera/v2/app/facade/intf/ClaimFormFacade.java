/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.dao.intf.ClaimFormDao;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.ClaimForm;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.User;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade;

/**
 * The Interface ClaimFormFacade.
 */
public interface ClaimFormFacade extends BaseFacade<ClaimForm, ClaimFormDao> {
	/**
	 * Approve form by department.
	 *
	 * @param claimForm the claim form
	 */
	public abstract void approveFormByDepartment(ClaimForm claimForm);

	/**
	 * Approve form by financial.
	 *
	 * @param claimForm the claim form
	 */
	public abstract void approveFormByFinancial(ClaimForm claimForm);

	/**
	 * Gets the claim form by user.
	 *
	 * @param user the user
	 * @return the claim form by user
	 */
	public abstract List<ClaimForm> getClaimFormByUser(User user);

	/**
	 * Gets the claim forms approved wi items.
	 *
	 * @param user the user
	 * @return the claim forms approved wi items
	 */
	public abstract List<ClaimForm> getClaimFormsApprovedWiItems(User user);

	/**
	 * Gets the claim forms for chart.
	 *
	 * @param user the user
	 * @param monthsList the months list
	 * @param monthsValues the months values
	 * @return the claim forms for chart
	 */
	public abstract void getClaimFormsForChart(User user, List<String> monthsList, Map<String, List<BigDecimal>> monthsValues);

	/**
	 * Gets the claim forms for your approval.
	 *
	 * @param user the user
	 * @return the claim forms for your approval
	 */
	public abstract List<ClaimForm> getClaimFormsForYourApproval(User user);

	/**
	 * Gets the claim forms pending for approval.
	 *
	 * @param user the user
	 * @return the claim forms pending for approval
	 */
	public abstract List<ClaimForm> getClaimFormsPendingForApproval(User user);

	/**
	 * Gets the types of claim form by user.
	 *
	 * @param user the user
	 * @return the types of claim form by user
	 */
	public abstract Map<Long, List<ClaimForm>> getTypesOfClaimFormByUser(User user);

	/**
	 * Reject.
	 *
	 * @param claimForm the claim form
	 */
	public abstract void reject(ClaimForm claimForm);

	/**
	 * Reset from reject status.
	 *
	 * @param claimForm the claim form
	 */
	public abstract void resetFromRejectStatus(ClaimForm claimForm);

	/**
	 * Submit form.
	 *
	 * @param claimForm the claim form
	 */
	public abstract void submitForm(ClaimForm claimForm);

	/**
	 * Update total.
	 *
	 * @param claimForm the claim form
	 */
	public abstract void updateTotal(ClaimForm claimForm);
}
