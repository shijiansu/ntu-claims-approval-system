/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.dao.impl.ClaimFormDaoBean;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.dao.intf.ClaimFormDao;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormFacade;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.ClaimForm;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.ClaimFormItem;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.ClaimType;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.Department;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.FormStatus;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.User;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.common.DateUtil;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacadeBean;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.FacadeServiceLocator;
import freemarker.template.utility.StringUtil;

/**
 * The Class ClaimFormFacadeBean.
 */
public class ClaimFormFacadeBean extends BaseFacadeBean<ClaimForm, ClaimFormDao> implements ClaimFormFacade {
	/** The claim form dao. */
	private final ClaimFormDao claimFormDao = new ClaimFormDaoBean();

	/*
	 * (non-Javadoc)
	 * @see
	 * sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormFacade#approveFormByDepartment(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app
	 * .model.ClaimForm)
	 */
	public void approveFormByDepartment(ClaimForm claimForm) {
		FormStatus formStatus = FacadeServiceLocator.getInstance().getFormStatusFacade().selectById(new Long(3L));
		claimForm.setFormStatus(formStatus);
		update(claimForm);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormFacade#approveFormByFinancial(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.
	 * model.ClaimForm)
	 */
	public void approveFormByFinancial(ClaimForm claimForm) {
		FormStatus formStatus = FacadeServiceLocator.getInstance().getFormStatusFacade().selectById(new Long(4L));
		claimForm.setFormStatus(formStatus);
		update(claimForm);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormFacade#getClaimFormByUser(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model
	 * .User)
	 */
	public List<ClaimForm> getClaimFormByUser(User user) {
		return getDao().getQueryResult("ClaimForm.getClaimFormsByUser", new Object[] { user });
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormFacade#getClaimFormsApprovedWiItems(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2
	 * .app.model.User)
	 */
	public List<ClaimForm> getClaimFormsApprovedWiItems(User user) {
		return getDao().getQueryResult("ClaimForm.getClaimFormsApprovedWiItems", new Object[] { user });
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormFacade#getClaimFormsForChart(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model
	 * .User, java.util.List, java.util.Map)
	 */
	public void getClaimFormsForChart(User user, List<String> monthsList, Map<String, List<BigDecimal>> monthsValues) {
		// [Start] construct period
		Calendar cal = Calendar.getInstance();
		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONTH) + 1;
		int startYear = 0;
		int startMonth = 0;
		if (currentMonth == 12) {
			startYear = currentYear;
			startMonth = 1;
		} else {
			startYear = currentYear - 1;
			startMonth = currentMonth + 1;
		}
		cal.add(Calendar.MONTH, 1);
		Date currentNextMonthDate = null;
		Date startDate = null;
		try {
			currentNextMonthDate = DateUtil.YEAR_MONTH_FORMATOR.parse(cal.get(Calendar.YEAR) + "" + (cal.get(Calendar.MONTH) + 1));
			startDate = DateUtil.YEAR_MONTH_FORMATOR.parse(startYear + "" + startMonth);
		} catch (ParseException e) {
			e.printStackTrace();
			return;
		}
		// [End] construct period
		// [Start] construct 12 month claim form
		Map<String, Integer> monthIndex = new HashMap<String, Integer>();
		int index = 0;
		for (int i = startYear; i <= currentYear; i++) {
			if (startYear == currentYear) {
				for (int j = startMonth; j <= currentMonth; j++) {
					monthsList.add(i + "" + j);
					monthIndex.put(i + "" + j, index++);
				}
			} else if (startYear < currentYear) {
				if (i == startYear) {
					for (int j = startMonth; j <= 12; j++) {
						String month = StringUtil.leftPad(String.valueOf(j), 2, "0");
						monthsList.add(i + "" + month);
						monthIndex.put(i + "" + month, index++);
					}
				} else if (i == currentYear) {
					for (int j = 1; j <= currentMonth; j++) {
						String month = StringUtil.leftPad(String.valueOf(j), 2, "0");
						monthsList.add(i + "" + month);
						monthIndex.put(i + "" + month, index++);
					}
				}
			}
		}
		// [Start] construct claim form by claim form type category
		List<ClaimType> claimTypeList = FacadeServiceLocator.getInstance().getClaimTypeFacade().getDao().getQueryResult("ClaimType.getAll", new Object[] {});
		for (ClaimType ct : claimTypeList) {
			String claimType = ct.getClaimType();
			if (claimType != null) {
				String[] split = claimType.split(" ");
				if (split != null && split.length > 0) {
					String claimTypeCategory = split[0];
					// init for each claim type category
					if (monthsValues.get(claimTypeCategory) == null) {
						List<BigDecimal> values = new ArrayList<BigDecimal>();
						for (@SuppressWarnings("unused")
						String s : monthsList) {
							// loop count as monthsList
							values.add(BigDecimal.ZERO);
						}
						monthsValues.put(claimTypeCategory, values);
					}
				}
			}
		}
		// [End] construct claim form by claim form type category
		// [End] construct result
		// [Start] assign value
		List<ClaimForm> chartClaimFormList = getClaimFormsApprovedWiItems(user);
		for (ClaimForm c : chartClaimFormList) {
			try {
				String key = c.getTravelOfYear() + c.getTravelOfMonth();
				Date claimFormDate = DateUtil.YEAR_MONTH_FORMATOR.parse(key);
				if (!startDate.after(claimFormDate) && claimFormDate.before(currentNextMonthDate)) {
					// qualified
					int indexTemp = monthIndex.get(key);
					Set<ClaimFormItem> claimFormItems = c.getClaimFormItems();
					for (ClaimFormItem ci : claimFormItems) {
						// assume data must be correct
						String key2 = ci.getClaimType().getClaimType().split(" ")[0];
						BigDecimal value = monthsValues.get(key2).get(indexTemp);
						monthsValues.get(key2).set(indexTemp, value.add(ci.getClaimAmount()));
					}
				}
			} catch (ParseException e) {
				e.printStackTrace();
				continue;
			}
		}
		// [End] assign value
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormFacade#getClaimFormsForYourApproval(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2
	 * .app.model.User)
	 */
	public List<ClaimForm> getClaimFormsForYourApproval(User user) {
		String isFinancialFlag = "N";
		Department department = user.getDepartment();
		if (department != null && department.getOperationArea() != null) {
			isFinancialFlag = department.getOperationArea().getIsFinancial();
		}
		return getDao().getQueryResult("ClaimForm.getClaimFormsForYourApproval", new Object[] { user, isFinancialFlag });
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormFacade#getClaimFormsPendingForApproval(sg.edu.ntu.wkw.msc.is.ead._2014.tera
	 * .v2.app.model.User)
	 */
	public List<ClaimForm> getClaimFormsPendingForApproval(User user) {
		return getDao().getQueryResult("ClaimForm.getClaimFormsPendingForApproval", new Object[] { user });
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade#getDao()
	 */
	public ClaimFormDao getDao() {
		return claimFormDao;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormFacade#getTypesOfClaimFormByUser(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app
	 * .model.User)
	 */
	public Map<Long, List<ClaimForm>> getTypesOfClaimFormByUser(User user) {
		Map<Long, List<ClaimForm>> result = new LinkedHashMap<Long, List<ClaimForm>>();
		List<ClaimForm> claimForms = getClaimFormByUser(user);
		if (claimForms != null) {
			for (ClaimForm claimForm : claimForms) {
				FormStatus formStatus = claimForm.getFormStatus();
				if (formStatus != null) {
					// include rejected status into list 1
					Long statsId = formStatus.getId();
					Long listGroupId = statsId;
					if (statsId.doubleValue() == 5) {
						listGroupId = 1L;
					}
					List<ClaimForm> list = result.get(listGroupId);
					if (list == null) {
						list = new ArrayList<ClaimForm>();
						result.put(listGroupId, list);
					}
					list.add(claimForm);
				}
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormFacade#reject(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.ClaimForm)
	 */
	public void reject(ClaimForm claimForm) {
		FormStatus formStatus = FacadeServiceLocator.getInstance().getFormStatusFacade().selectById(new Long(5L));
		claimForm.setFormStatus(formStatus);
		update(claimForm);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormFacade#resetFromRejectStatus(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model
	 * .ClaimForm)
	 */
	public void resetFromRejectStatus(ClaimForm claimForm) {
		if (claimForm.getFormStatus().getId().longValue() == 5L) {
			// update status to Saved Status
			FormStatus formStatus = FacadeServiceLocator.getInstance().getFormStatusFacade().selectById(new Long(1L));
			claimForm.setFormStatus(formStatus);
			// reset Reject By / Time to Null
			claimForm.setRejectBy(null);
			claimForm.setRejectTime(null);
			// update
			update(claimForm);
		} else if (claimForm.getFormStatus().getId().longValue() == 2L) {
			// reset Reject By / Time to Null
			claimForm.setRejectBy(null);
			claimForm.setRejectTime(null);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormFacade#submitForm(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.ClaimForm)
	 */
	public void submitForm(ClaimForm claimForm) {
		ClaimForm claimFormToUpdate = new ClaimForm();
		claimFormToUpdate.setId(claimForm.getId());
		claimFormToUpdate = selectById(claimForm);
		if (claimFormToUpdate != null) {
			FormStatus formStatus = FacadeServiceLocator.getInstance().getFormStatusFacade().selectById(new Long(2L));
			claimFormToUpdate.setFormStatus(formStatus);
			claimFormToUpdate.setUpdateBy(claimForm.getUpdateBy());
			resetFromRejectStatus(claimFormToUpdate);
			update(claimFormToUpdate);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormFacade#updateTotal(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.ClaimForm
	 * )
	 */
	public void updateTotal(ClaimForm claimForm) {
		claimForm = selectById(claimForm);
		if (claimForm != null) {
			claimForm.setTotal(BigDecimal.ZERO);
			List<ClaimFormItem> claimFormItems = FacadeServiceLocator.getInstance().getClaimFormItemFacade().getAllItemsByFormId(claimForm.getId());
			if (claimFormItems != null) {
				for (ClaimFormItem claimFormItem : claimFormItems) {
					claimForm.setTotal(claimForm.getTotal().add(claimFormItem.getClaimAmount()));
				}
			}
		}
		update(claimForm);
	}
}
