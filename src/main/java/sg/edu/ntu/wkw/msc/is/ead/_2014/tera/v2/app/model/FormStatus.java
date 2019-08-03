package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.model.AuditEntity;

/**
 * The Class FormStatus.
 */
public class FormStatus extends AuditEntity {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8281724517978395781L;

	/** The claim forms. */
	private Set<ClaimForm> claimForms = new HashSet<ClaimForm>(0);

	/** The form status. */
	private String formStatus;

	/** The id. */
	private Long id;

	/**
	 * Instantiates a new form status.
	 */
	public FormStatus() {
	}

	/**
	 * Instantiates a new form status.
	 *
	 * @param id the id
	 * @param formStatus the form status
	 */
	public FormStatus(Long id, String formStatus) {
		this.id = id;
		this.formStatus = formStatus;
	}

	/**
	 * Instantiates a new form status.
	 *
	 * @param id the id
	 * @param formStatus the form status
	 * @param createBy the create by
	 * @param createTime the create time
	 * @param updateBy the update by
	 * @param updateTime the update time
	 * @param claimForms the claim forms
	 */
	public FormStatus(Long id, String formStatus, String createBy, Date createTime, String updateBy, Date updateTime, Set<ClaimForm> claimForms) {
		this.id = id;
		this.formStatus = formStatus;
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
		this.claimForms = claimForms;
	}

	/**
	 * Gets the claim forms.
	 *
	 * @return the claim forms
	 */
	public Set<ClaimForm> getClaimForms() {
		return this.claimForms;
	}

	/**
	 * Gets the form status.
	 *
	 * @return the form status
	 */
	public String getFormStatus() {
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
	 * Sets the claim forms.
	 *
	 * @param claimForms the new claim forms
	 */
	public void setClaimForms(Set<ClaimForm> claimForms) {
		this.claimForms = claimForms;
	}

	/**
	 * Sets the form status.
	 *
	 * @param formStatus the new form status
	 */
	public void setFormStatus(String formStatus) {
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
}
