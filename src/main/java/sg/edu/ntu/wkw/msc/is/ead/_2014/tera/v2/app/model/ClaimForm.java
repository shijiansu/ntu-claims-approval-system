package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.model.AuditEntity;

/**
 * The Class ClaimForm.
 */
public class ClaimForm extends AuditEntity {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5973890556528788111L;

	/** The approved by financial. */
	private User approvedByFinancial;

	/** The approved by financial time. */
	private Date approvedByFinancialTime;

	/** The approved by manager. */
	private User approvedByManager;

	/** The approved by manager time. */
	private Date approvedByManagerTime;

	/** The claim form items. */
	private Set<ClaimFormItem> claimFormItems = new HashSet<ClaimFormItem>(0);

	/** The department. */
	private Department department;

	/** The form status. */
	private FormStatus formStatus;

	/** The id. */
	private Long id;

	/** The reject by. */
	private User rejectBy;

	/** The reject time. */
	private Date rejectTime;

	/** The total. */
	private BigDecimal total;

	/** The travel of month. */
	private String travelOfMonth;

	/** The travel of year. */
	private String travelOfYear;

	/** The user. */
	private User user;

	/**
	 * Instantiates a new claim form.
	 */
	public ClaimForm() {
	}

	/**
	 * Instantiates a new claim form.
	 *
	 * @param user the user
	 * @param approvedByManager the approved by manager
	 * @param department the department
	 * @param formStatus the form status
	 * @param approvedByFinancial the approved by financial
	 * @param travelOfYear the travel of year
	 * @param travelOfMonth the travel of month
	 * @param total the total
	 * @param approvedByManagerTime the approved by manager time
	 * @param approvedByFinancialTime the approved by financial time
	 * @param createBy the create by
	 * @param createTime the create time
	 * @param updateBy the update by
	 * @param updateTime the update time
	 * @param claimFormItems the claim form items
	 * @param rejectBy the reject by
	 * @param rejectTime the reject time
	 */
	public ClaimForm(User user, User approvedByManager, Department department, FormStatus formStatus, User approvedByFinancial, String travelOfYear, String travelOfMonth, BigDecimal total, Date approvedByManagerTime, Date approvedByFinancialTime,
			String createBy, Date createTime, String updateBy, Date updateTime, Set<ClaimFormItem> claimFormItems, User rejectBy, Date rejectTime) {
		this.user = user;
		this.approvedByManager = approvedByManager;
		this.department = department;
		this.formStatus = formStatus;
		this.approvedByFinancial = approvedByFinancial;
		this.travelOfYear = travelOfYear;
		this.travelOfMonth = travelOfMonth;
		this.total = total;
		this.approvedByManagerTime = approvedByManagerTime;
		this.approvedByFinancialTime = approvedByFinancialTime;
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
		this.claimFormItems = claimFormItems;
		this.rejectBy = rejectBy;
		this.rejectTime = rejectTime;
	}

	/**
	 * Gets the approved by financial.
	 *
	 * @return the approved by financial
	 */
	public User getApprovedByFinancial() {
		return this.approvedByFinancial;
	}

	/**
	 * Gets the approved by financial time.
	 *
	 * @return the approved by financial time
	 */
	public Date getApprovedByFinancialTime() {
		return this.approvedByFinancialTime;
	}

	/**
	 * Gets the approved by manager.
	 *
	 * @return the approved by manager
	 */
	public User getApprovedByManager() {
		return this.approvedByManager;
	}

	/**
	 * Gets the approved by manager time.
	 *
	 * @return the approved by manager time
	 */
	public Date getApprovedByManagerTime() {
		return this.approvedByManagerTime;
	}

	/**
	 * Gets the claim form items.
	 *
	 * @return the claim form items
	 */
	public Set<ClaimFormItem> getClaimFormItems() {
		return this.claimFormItems;
	}

	/**
	 * Gets the department.
	 *
	 * @return the department
	 */
	public Department getDepartment() {
		return this.department;
	}

	/**
	 * Gets the form status.
	 *
	 * @return the form status
	 */
	public FormStatus getFormStatus() {
		return this.formStatus;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.model.BaseEntity#getId()
	 */
	@Override
	public Long getId() {
		return this.id;
	}

	/**
	 * Gets the reject by.
	 *
	 * @return the reject by
	 */
	public User getRejectBy() {
		return rejectBy;
	}

	/**
	 * Gets the reject time.
	 *
	 * @return the reject time
	 */
	public Date getRejectTime() {
		return rejectTime;
	}

	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return this.total;
	}

	/**
	 * Gets the travel of month.
	 *
	 * @return the travel of month
	 */
	public String getTravelOfMonth() {
		return this.travelOfMonth;
	}

	/**
	 * Gets the travel of year.
	 *
	 * @return the travel of year
	 */
	public String getTravelOfYear() {
		return this.travelOfYear;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * Sets the approved by financial.
	 *
	 * @param approvedByFinancial the new approved by financial
	 */
	public void setApprovedByFinancial(User approvedByFinancial) {
		this.approvedByFinancial = approvedByFinancial;
	}

	/**
	 * Sets the approved by financial time.
	 *
	 * @param approvedByFinancialTime the new approved by financial time
	 */
	public void setApprovedByFinancialTime(Date approvedByFinancialTime) {
		this.approvedByFinancialTime = approvedByFinancialTime;
	}

	/**
	 * Sets the approved by manager.
	 *
	 * @param approvedByManager the new approved by manager
	 */
	public void setApprovedByManager(User approvedByManager) {
		this.approvedByManager = approvedByManager;
	}

	/**
	 * Sets the approved by manager time.
	 *
	 * @param approvedByManagerTime the new approved by manager time
	 */
	public void setApprovedByManagerTime(Date approvedByManagerTime) {
		this.approvedByManagerTime = approvedByManagerTime;
	}

	/**
	 * Sets the claim form items.
	 *
	 * @param claimFormItems the new claim form items
	 */
	public void setClaimFormItems(Set<ClaimFormItem> claimFormItems) {
		this.claimFormItems = claimFormItems;
	}

	/**
	 * Sets the department.
	 *
	 * @param department the new department
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * Sets the form status.
	 *
	 * @param formStatus the new form status
	 */
	public void setFormStatus(FormStatus formStatus) {
		this.formStatus = formStatus;
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
	 * Sets the reject by.
	 *
	 * @param rejectBy the new reject by
	 */
	public void setRejectBy(User rejectBy) {
		this.rejectBy = rejectBy;
	}

	/**
	 * Sets the reject time.
	 *
	 * @param rejectTime the new reject time
	 */
	public void setRejectTime(Date rejectTime) {
		this.rejectTime = rejectTime;
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
	 * Sets the travel of month.
	 *
	 * @param travelOfMonth the new travel of month
	 */
	public void setTravelOfMonth(String travelOfMonth) {
		this.travelOfMonth = travelOfMonth;
	}

	/**
	 * Sets the travel of year.
	 *
	 * @param travelOfYear the new travel of year
	 */
	public void setTravelOfYear(String travelOfYear) {
		this.travelOfYear = travelOfYear;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
