package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.web.action;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormFacade;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.ClaimForm;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.ClaimFormItem;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.ClaimType;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.Department;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.FormStatus;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.User;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.common.DateUtil;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.FacadeServiceLocator;

/**
 * The Class ClaimFormAction.
 */
public class ClaimFormAction extends ClaimFormRoot {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7358695234165013051L;

	/* (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.web.action.BaseAction#doGetCreate()
	 */
	@Override
	public String doGetCreate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		setYears(request);
		setMonths(request);
		return ACTION_CREATE;
	}

	/**
	 * Do get create item.
	 *
	 * @return the string
	 */
	public String doGetCreateItem() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		String claimFormId = getInputClaimFormId();
		ClaimForm claimForm = getFacade().selectById(new Long(claimFormId));
		setClaimTypes(request);
		request.setAttribute("claimForm", claimForm);
		request.setAttribute("claimFormId", claimFormId);
		return ACTION_CREATE_ITEM;
	}

	/* (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.web.action.BaseAction#doGetDelete()
	 */
	@Override
	public String doGetDelete() {
		//
		String id = getInputClaimFormId();
		getFacade().delete(new Long(id));
		return doGetList();
	}

	/**
	 * Do get delete item.
	 *
	 * @return the string
	 */
	public String doGetDeleteItem() {
		//
		String claimFormItemId = getInputClaimFormItemId();
		FacadeServiceLocator.getInstance().getClaimFormItemFacade().deleteAndUpdateTotal(new Long(claimFormItemId));
		return doGetEdit();
	}

	/**
	 * Do get department approve.
	 *
	 * @return the string
	 */
	public String doGetDepartmentApprove() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		String claimFormId = getInputClaimFormId();
		ClaimForm claimForm = getFacade().selectById(new Long(claimFormId));
		if (claimForm != null) {
			claimForm.setApprovedByManager(getSessionUser(request));
			claimForm.setApprovedByManagerTime(new Date());
			claimForm.setUpdateBy(getSessionUser(request).getUserName());
			claimForm.setUpdateTime(new Date());
			getFacade().approveFormByDepartment(claimForm);
		}
		return UserRoot.ACTION_VIEW_DASHBOARD;
	}

	/**
	 * Do get reject.
	 *
	 * @return the string
	 */
	public String doGetReject() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		String claimFormId = getInputClaimFormId();
		ClaimForm claimForm = getFacade().selectById(new Long(claimFormId));
		if (claimForm != null) {
			claimForm.setRejectBy(getSessionUser(request));
			claimForm.setRejectTime(new Date());
			claimForm.setUpdateBy(getSessionUser(request).getUserName());
			claimForm.setUpdateTime(new Date());
			getFacade().reject(claimForm);
		}
		return UserRoot.ACTION_VIEW_DASHBOARD;
	}

	/* (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.web.action.BaseAction#doGetEdit()
	 */
	@Override
	public String doGetEdit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		String claimFormId = getInputClaimFormId();
		ClaimForm claimForm = getFacade().selectById(new Long(claimFormId));
		setMonths(request);
		request.setAttribute("claimForm", claimForm);
		List<ClaimFormItem> claimFormItems = FacadeServiceLocator.getInstance().getClaimFormItemFacade().getAllItemsByFormId(new Long(claimFormId));
		request.setAttribute("claimFormItemList", claimFormItems);
		return ACTION_EDIT;
	}

	/**
	 * Do get edit item.
	 *
	 * @return the string
	 */
	public String doGetEditItem() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		String claimFormItemId = getInputClaimFormItemId();
		ClaimFormItem claimFormItem = FacadeServiceLocator.getInstance().getClaimFormItemFacade().selectById(new Long(claimFormItemId));
		String claimFormId = getInputClaimFormId();
		ClaimForm claimForm = getFacade().selectById(new Long(claimFormId));
		request.setAttribute("claimFormItem", claimFormItem);
		request.setAttribute("claimForm", claimForm);
		setClaimTypes(request);
		return ACTION_EDIT_ITEM;
	}

	/**
	 * Do get financial approve.
	 *
	 * @return the string
	 */
	public String doGetFinancialApprove() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		String claimFormId = getInputClaimFormId();
		ClaimForm claimForm = getFacade().selectById(new Long(claimFormId));
		if (claimForm != null) {
			claimForm.setApprovedByFinancial(getSessionUser(request));
			claimForm.setApprovedByFinancialTime(new Date());
			claimForm.setUpdateBy(getSessionUser(request).getUserName());
			claimForm.setUpdateTime(new Date());
			getFacade().approveFormByFinancial(claimForm);
		}
		return UserRoot.ACTION_VIEW_DASHBOARD;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#doGetList()
	 */
	@Override
	public String doGetList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		setMonths(request);
		Map<Long, List<ClaimForm>> result = getFacade().getTypesOfClaimFormByUser(getSessionUser(request));
		if (result != null) {
			for (Entry<Long, List<ClaimForm>> i : result.entrySet()) {
				if (i.getKey() != null) {
					request.setAttribute("claimFormList" + i.getKey(), i.getValue());
				}
			}
		}
		User manager = FacadeServiceLocator.getInstance().getDepartmentFacade().getCurrentDepartmentManager(getSessionUser(request));
		request.setAttribute("manager", manager);
		return ACTION_LIST;
	}

	/**
	 * Do get monitor.
	 *
	 * @return the string
	 */
	public String doGetMonitor() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		setMonths(request);
		List<ClaimForm> claimFormList = getFacade().selectAll();
		request.setAttribute("claimFormList", claimFormList);
		return ACTION_MONITOR;
	}

	/**
	 * Do get submit.
	 *
	 * @return the string
	 */
	public String doGetSubmit() {
		//
		return doPostEdit();
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#doGetView()
	 */
	@Override
	public String doGetView() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		String claimFormId = getInputClaimFormId();
		ClaimForm claimForm = getFacade().selectById(new Long(claimFormId));
		setMonths(request);
		request.setAttribute("claimForm", claimForm);
		List<ClaimFormItem> claimFormItems = FacadeServiceLocator.getInstance().getClaimFormItemFacade().getAllItemsByFormId(new Long(claimFormId));
		request.setAttribute("claimFormItemList", claimFormItems);
		return ACTION_VIEW;
	}

	/**
	 * Do get view item.
	 *
	 * @return the string
	 */
	public String doGetViewItem() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		String claimFormItemId = getInputClaimFormItemId();
		ClaimFormItem claimFormItem = FacadeServiceLocator.getInstance().getClaimFormItemFacade().selectById(new Long(claimFormItemId));
		setClaimTypes(request);
		request.setAttribute("claimFormItem", claimFormItem);
		return ACTION_VIEW_ITEM;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#doPostCreate()
	 */
	@Override
	public String doPostCreate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		String year = getSelectYear();
		String month = getSelectMonth();
		User user = getSessionUser(request);
		user = FacadeServiceLocator.getInstance().getUserFacade().selectById(user.getId());
		Department department = user.getDepartment();
		FormStatus formStatus = FacadeServiceLocator.getInstance().getFormStatusFacade().selectById(1L);
		ClaimForm claimForm = getNewEntity();
		claimForm.setTravelOfYear(year);
		claimForm.setTravelOfMonth(month);
		claimForm.setUser(user);
		claimForm.setTotal(BigDecimal.ZERO);
		claimForm.setDepartment(department);
		claimForm.setFormStatus(formStatus);
		claimForm.setCreateBy(getSessionUser(request).getUserName());
		claimForm.setCreateTime(new Date());
		getFacade().insert(claimForm);
		return doGetList();
	}

	/**
	 * Do post create item.
	 *
	 * @return the string
	 */
	public String doPostCreateItem() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		String claimFormId = getInputClaimFormId();
		String claimDate = getInputClaimDate();
		String claimTypeId = getSelectClaimType();
		String claimDescription = getInputClaimDescription();
		String claimAmount = getInputClaimAmount();
		ClaimForm claimForm = getFacade().selectById(new Long(claimFormId));
		ClaimType claimType = FacadeServiceLocator.getInstance().getClaimTypeFacade().selectById(new Long(claimTypeId));
		ClaimFormItem claimFormItem = new ClaimFormItem();
		claimFormItem.setClaimAmount(new BigDecimal(claimAmount));
		try {
			claimFormItem.setClaimDate(DateUtil.DATE_FORMATOR.parse(claimDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		claimFormItem.setClaimDescription(claimDescription);
		claimFormItem.setClaimForm(claimForm);
		claimFormItem.setClaimType(claimType);
		claimFormItem.setCreateBy(getSessionUser(request).getUserName());
		claimFormItem.setCreateTime(new Date());
		FacadeServiceLocator.getInstance().getClaimFormItemFacade().createAndUpdateTotal(claimFormItem);
		return doGetEdit();
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#doPostEdit()
	 */
	@Override
	public String doPostEdit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		String claimFormId = getInputClaimFormId();
		ClaimForm claimForm = getFacade().selectById(new Long(claimFormId));
		if (claimForm != null) {
			claimForm.setUpdateBy(getSessionUser(request).getUserName());
			claimForm.setUpdateTime(new Date());
			getFacade().submitForm(claimForm);
		}
		return doGetList();
	}

	/**
	 * Do post edit item.
	 *
	 * @return the string
	 */
	public String doPostEditItem() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		String claimFormItemId = getInputClaimFormItemId();
		String claimDate = getInputClaimDate();
		String claimTypeId = getSelectClaimType();
		String claimDescription = getInputClaimDescription();
		String claimAmount = getInputClaimAmount();
		ClaimFormItem claimFormItem = FacadeServiceLocator.getInstance().getClaimFormItemFacade().selectById(new Long(claimFormItemId));
		ClaimType claimType = FacadeServiceLocator.getInstance().getClaimTypeFacade().selectById(new Long(claimTypeId));
		try {
			claimFormItem.setClaimAmount(new BigDecimal(claimAmount));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			claimFormItem.setClaimDate(DateUtil.DATE_FORMATOR.parse(claimDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		claimFormItem.setClaimDescription(claimDescription);
		claimFormItem.setClaimType(claimType);
		claimFormItem.setUpdateBy(getSessionUser(request).getUserName());
		claimFormItem.setUpdateTime(new Date());
		FacadeServiceLocator.getInstance().getClaimFormItemFacade().updateAndUpdateTotal(claimFormItem);
		return doGetEdit();
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#getFacade()
	 */
	@Override
	public ClaimFormFacade getFacade() {
		return FacadeServiceLocator.getInstance().getClaimFormFacade();
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#getNewEntity()
	 */
	@Override
	public ClaimForm getNewEntity() {
		return new ClaimForm();
	}
}
