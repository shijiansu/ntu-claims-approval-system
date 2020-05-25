package sg.edu.ntu.tera.v2.app.model;

import java.math.BigDecimal;
import java.util.Date;

import sg.edu.ntu.tera.v2.infr.model.AuditEntity;

/**
 * The Class ClaimFormItem.
 */
public class ClaimFormItem extends AuditEntity {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1762753868845238476L;

	/** The claim amount. */
	private BigDecimal claimAmount;

	/** The claim date. */
	private Date claimDate;

	/** The claim description. */
	private String claimDescription;

	/** The claim form. */
	private ClaimForm claimForm;

	/** The claim type. */
	private ClaimType claimType;

	/** The id. */
	private Long id;

	/**
	 * Instantiates a new claim form item.
	 */
	public ClaimFormItem() {
	}

	/**
	 * Instantiates a new claim form item.
	 *
	 * @param claimType the claim type
	 * @param claimForm the claim form
	 * @param claimDate the claim date
	 * @param claimDescription the claim description
	 * @param claimAmount the claim amount
	 * @param createBy the create by
	 * @param createTime the create time
	 * @param updateBy the update by
	 * @param updateTime the update time
	 */
	public ClaimFormItem(ClaimType claimType, ClaimForm claimForm, Date claimDate, String claimDescription, BigDecimal claimAmount, String createBy, Date createTime, String updateBy, Date updateTime) {
		this.claimType = claimType;
		this.claimForm = claimForm;
		this.claimDate = claimDate;
		this.claimDescription = claimDescription;
		this.claimAmount = claimAmount;
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
	}

	/**
	 * Gets the claim amount.
	 *
	 * @return the claim amount
	 */
	public BigDecimal getClaimAmount() {
		return this.claimAmount;
	}

	/**
	 * Gets the claim date.
	 *
	 * @return the claim date
	 */
	public Date getClaimDate() {
		return this.claimDate;
	}

	/**
	 * Gets the claim description.
	 *
	 * @return the claim description
	 */
	public String getClaimDescription() {
		return this.claimDescription;
	}

	/**
	 * Gets the claim form.
	 *
	 * @return the claim form
	 */
	public ClaimForm getClaimForm() {
		return this.claimForm;
	}

	/**
	 * Gets the claim type.
	 *
	 * @return the claim type
	 */
	public ClaimType getClaimType() {
		return this.claimType;
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
	 * Sets the claim amount.
	 *
	 * @param claimAmount the new claim amount
	 */
	public void setClaimAmount(BigDecimal claimAmount) {
		this.claimAmount = claimAmount;
	}

	/**
	 * Sets the claim date.
	 *
	 * @param claimDate the new claim date
	 */
	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

	/**
	 * Sets the claim description.
	 *
	 * @param claimDescription the new claim description
	 */
	public void setClaimDescription(String claimDescription) {
		this.claimDescription = claimDescription;
	}

	/**
	 * Sets the claim form.
	 *
	 * @param claimForm the new claim form
	 */
	public void setClaimForm(ClaimForm claimForm) {
		this.claimForm = claimForm;
	}

	/**
	 * Sets the claim type.
	 *
	 * @param claimType the new claim type
	 */
	public void setClaimType(ClaimType claimType) {
		this.claimType = claimType;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
