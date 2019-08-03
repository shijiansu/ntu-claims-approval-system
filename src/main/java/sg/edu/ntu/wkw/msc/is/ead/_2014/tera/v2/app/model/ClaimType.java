package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.model.AuditEntity;

/**
 * The Class ClaimType.
 */
public class ClaimType extends AuditEntity {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3482780574307052366L;

	/** The claim form items. */
	private Set<ClaimFormItem> claimFormItems = new HashSet<ClaimFormItem>(0);

	/** The claim type. */
	private String claimType;

	/** The id. */
	private Long id;

	/**
	 * Instantiates a new claim type.
	 */
	public ClaimType() {
	}

	/**
	 * Instantiates a new claim type.
	 *
	 * @param id the id
	 * @param claimType the claim type
	 */
	public ClaimType(Long id, String claimType) {
		this.id = id;
		this.claimType = claimType;
	}

	/**
	 * Instantiates a new claim type.
	 *
	 * @param id the id
	 * @param claimType the claim type
	 * @param createBy the create by
	 * @param createTime the create time
	 * @param updateBy the update by
	 * @param updateTime the update time
	 * @param claimFormItems the claim form items
	 */
	public ClaimType(Long id, String claimType, String createBy, Date createTime, String updateBy, Date updateTime, Set<ClaimFormItem> claimFormItems) {
		this.id = id;
		this.claimType = claimType;
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
		this.claimFormItems = claimFormItems;
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
	 * Gets the claim type.
	 *
	 * @return the claim type
	 */
	public String getClaimType() {
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
	 * Sets the claim form items.
	 *
	 * @param claimFormItems the new claim form items
	 */
	public void setClaimFormItems(Set<ClaimFormItem> claimFormItems) {
		this.claimFormItems = claimFormItems;
	}

	/**
	 * Sets the claim type.
	 *
	 * @param claimType the new claim type
	 */
	public void setClaimType(String claimType) {
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
