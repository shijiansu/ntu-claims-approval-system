package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.web.action;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.dao.intf.ClaimFormDao;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormFacade;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model.ClaimForm;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.web.action.BaseAction;

/**
 * The Class ClaimFormRoot.
 */
public abstract class ClaimFormRoot extends BaseAction<ClaimForm, ClaimFormDao, ClaimFormFacade> {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3051986652540248546L;

	/** The Constant ACTION_CREATE_ITEM. */
	public static final String ACTION_CREATE_ITEM = "createItem";

	/** The Constant ACTION_DELETE_ITEM. */
	public static final String ACTION_DELETE_ITEM = "deleteItem";

	/** The Constant ACTION_DEPARTMENT_APPROVE. */
	public static final String ACTION_DEPARTMENT_APPROVE = "departmentApprove";

	/** The Constant ACTION_EDIT_ITEM. */
	public static final String ACTION_EDIT_ITEM = "editItem";

	/** The Constant ACTION_FINANCIAL_APPROVE. */
	public static final String ACTION_FINANCIAL_APPROVE = "financialApprove";

	/** The Constant ACTION_MONITOR. */
	public static final String ACTION_MONITOR = "monitor";

	/** The Constant ACTION_SUBMIT. */
	public static final String ACTION_SUBMIT = "submit";

	/** The Constant ACTION_VIEW_ITEM. */
	public static final String ACTION_VIEW_ITEM = "viewItem";

	/** The Constant MODULE_NAME. */
	public static final String MODULE_NAME = "claimForm";

	/** The input claim form id. */
	private String inputClaimFormId;

	/** The input claim form item id. */
	private String inputClaimFormItemId;

	/** The select year. */
	private String selectYear;

	/** The select month. */
	private String selectMonth;

	/** The input claim date. */
	private String inputClaimDate;

	/** The select claim type. */
	private String selectClaimType;

	/** The input claim description. */
	private String inputClaimDescription;

	/** The input claim amount. */
	private String inputClaimAmount;

	/**
	 * Gets the input claim form id.
	 *
	 * @return the input claim form id
	 */
	public String getInputClaimFormId() {
		return inputClaimFormId;
	}

	/**
	 * Sets the input claim form id.
	 *
	 * @param inputClaimFormId the new input claim form id
	 */
	public void setInputClaimFormId(String inputClaimFormId) {
		this.inputClaimFormId = inputClaimFormId;
	}

	/**
	 * Gets the input claim form item id.
	 *
	 * @return the input claim form item id
	 */
	public String getInputClaimFormItemId() {
		return inputClaimFormItemId;
	}

	/**
	 * Sets the input claim form item id.
	 *
	 * @param inputClaimFormItemId the new input claim form item id
	 */
	public void setInputClaimFormItemId(String inputClaimFormItemId) {
		this.inputClaimFormItemId = inputClaimFormItemId;
	}

	/**
	 * Gets the select year.
	 *
	 * @return the select year
	 */
	public String getSelectYear() {
		return selectYear;
	}

	/**
	 * Sets the select year.
	 *
	 * @param selectYear the new select year
	 */
	public void setSelectYear(String selectYear) {
		this.selectYear = selectYear;
	}

	/**
	 * Gets the select month.
	 *
	 * @return the select month
	 */
	public String getSelectMonth() {
		return selectMonth;
	}

	/**
	 * Sets the select month.
	 *
	 * @param selectMonth the new select month
	 */
	public void setSelectMonth(String selectMonth) {
		this.selectMonth = selectMonth;
	}

	/**
	 * Gets the input claim date.
	 *
	 * @return the input claim date
	 */
	public String getInputClaimDate() {
		return inputClaimDate;
	}

	/**
	 * Sets the input claim date.
	 *
	 * @param inputClaimDate the new input claim date
	 */
	public void setInputClaimDate(String inputClaimDate) {
		this.inputClaimDate = inputClaimDate;
	}

	/**
	 * Gets the select claim type.
	 *
	 * @return the select claim type
	 */
	public String getSelectClaimType() {
		return selectClaimType;
	}

	/**
	 * Sets the select claim type.
	 *
	 * @param selectClaimType the new select claim type
	 */
	public void setSelectClaimType(String selectClaimType) {
		this.selectClaimType = selectClaimType;
	}

	/**
	 * Gets the input claim description.
	 *
	 * @return the input claim description
	 */
	public String getInputClaimDescription() {
		return inputClaimDescription;
	}

	/**
	 * Sets the input claim description.
	 *
	 * @param inputClaimDescription the new input claim description
	 */
	public void setInputClaimDescription(String inputClaimDescription) {
		this.inputClaimDescription = inputClaimDescription;
	}

	/**
	 * Gets the input claim amount.
	 *
	 * @return the input claim amount
	 */
	public String getInputClaimAmount() {
		return inputClaimAmount;
	}

	/**
	 * Sets the input claim amount.
	 *
	 * @param inputClaimAmount the new input claim amount
	 */
	public void setInputClaimAmount(String inputClaimAmount) {
		this.inputClaimAmount = inputClaimAmount;
	}
}
