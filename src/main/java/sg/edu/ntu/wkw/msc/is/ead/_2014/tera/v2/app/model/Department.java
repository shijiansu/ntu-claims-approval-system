package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.model.AuditEntity;

/**
 * The Class Department.
 */
public class Department extends AuditEntity {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6840680342247303554L;

	/** The claim forms. */
	private Set<ClaimForm> claimForms = new HashSet<ClaimForm>(0);

	/** The department name. */
	private String departmentName;

	/** The id. */
	private Long id;

	/** The manager. */
	private User manager;

	/** The office address. */
	private String officeAddress;

	/** The operation area. */
	private OperationArea operationArea;

	/** The region. */
	private Region region;

	/** The telephone number. */
	private String telephoneNumber;

	/** The users. */
	private Set<User> users = new HashSet<User>(0);

	/**
	 * Instantiates a new department.
	 */
	public Department() {
	}

	/**
	 * Instantiates a new department.
	 *
	 * @param manager the manager
	 * @param region the region
	 * @param operationArea the operation area
	 * @param departmentName the department name
	 * @param telephoneNumber the telephone number
	 * @param officeAddress the office address
	 * @param createBy the create by
	 * @param createTime the create time
	 * @param updateBy the update by
	 * @param updateTime the update time
	 * @param users the users
	 * @param claimForms the claim forms
	 */
	public Department(User manager, Region region, OperationArea operationArea, String departmentName, String telephoneNumber, String officeAddress, String createBy, Date createTime, String updateBy, Date updateTime, Set<User> users,
			Set<ClaimForm> claimForms) {
		this.manager = manager;
		this.region = region;
		this.operationArea = operationArea;
		this.departmentName = departmentName;
		this.telephoneNumber = telephoneNumber;
		this.officeAddress = officeAddress;
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
		this.users = users;
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
	 * Gets the department name.
	 *
	 * @return the department name
	 */
	public String getDepartmentName() {
		return this.departmentName;
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
	 * Gets the manager.
	 *
	 * @return the manager
	 */
	public User getManager() {
		return this.manager;
	}

	/**
	 * Gets the office address.
	 *
	 * @return the office address
	 */
	public String getOfficeAddress() {
		return this.officeAddress;
	}

	/**
	 * Gets the operation area.
	 *
	 * @return the operation area
	 */
	public OperationArea getOperationArea() {
		return this.operationArea;
	}

	/**
	 * Gets the region.
	 *
	 * @return the region
	 */
	public Region getRegion() {
		return this.region;
	}

	/**
	 * Gets the telephone number.
	 *
	 * @return the telephone number
	 */
	public String getTelephoneNumber() {
		return this.telephoneNumber;
	}

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	public Set<User> getUsers() {
		return this.users;
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
	 * Sets the department name.
	 *
	 * @param departmentName the new department name
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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
	 * Sets the manager.
	 *
	 * @param manager the new manager
	 */
	public void setManager(User manager) {
		this.manager = manager;
	}

	/**
	 * Sets the office address.
	 *
	 * @param officeAddress the new office address
	 */
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	/**
	 * Sets the operation area.
	 *
	 * @param operationArea the new operation area
	 */
	public void setOperationArea(OperationArea operationArea) {
		this.operationArea = operationArea;
	}

	/**
	 * Sets the region.
	 *
	 * @param region the new region
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * Sets the telephone number.
	 *
	 * @param telephoneNumber the new telephone number
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	/**
	 * Sets the users.
	 *
	 * @param users the new users
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
