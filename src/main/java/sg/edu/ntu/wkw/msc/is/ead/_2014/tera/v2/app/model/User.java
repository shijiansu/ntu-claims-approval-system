package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model;

import java.util.Date;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.model.AuditEntity;

/**
 * The Class User.
 */
public class User extends AuditEntity {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2030808804174275089L;

	/** The birth date. */
	private Date birthDate;

	/** The department. */
	private Department department;

	/** The email addr. */
	private String emailAddr;

	/** The first name. */
	private String firstName;

	/** The gender. */
	private String gender;

	/** The id. */
	private Long id;

	/** The is admin. */
	private String isAdmin;

	/** The is approver. */
	private boolean isApprover;

	/** The is financial. */
	private boolean isFinancial;

	/** The last name. */
	private String lastName;

	/** The password. */
	private String password;

	/** The user name. */
	private String userName;

	/**
	 * Instantiates a new user.
	 */
	public User() {
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param department the department
	 * @param userName the user name
	 * @param password the password
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param gender the gender
	 * @param birthDate the birth date
	 * @param emailAddr the email addr
	 * @param isAdmin the is admin
	 * @param createBy the create by
	 * @param createTime the create time
	 * @param updateBy the update by
	 * @param updateTime the update time
	 */
	public User(Department department, String userName, String password, String firstName, String lastName, String gender, Date birthDate, String emailAddr, String isAdmin, String createBy, Date createTime, String updateBy, Date updateTime) {
		this.department = department;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate = birthDate;
		this.emailAddr = emailAddr;
		this.isAdmin = isAdmin;
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
	}

	/**
	 * Gets the birth date.
	 *
	 * @return the birth date
	 */
	public Date getBirthDate() {
		return this.birthDate;
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
	 * Gets the email addr.
	 *
	 * @return the email addr
	 */
	public String getEmailAddr() {
		return this.emailAddr;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return this.gender;
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
	 * Gets the checks if is admin.
	 *
	 * @return the checks if is admin
	 */
	public String getIsAdmin() {
		return this.isAdmin;
	}

	/**
	 * Gets the checks if is approver.
	 *
	 * @return the checks if is approver
	 */
	public boolean getIsApprover() {
		return isApprover;
	}

	/**
	 * Gets the checks if is financial.
	 *
	 * @return the checks if is financial
	 */
	public boolean getIsFinancial() {
		return isFinancial;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * Sets the birth date.
	 *
	 * @param birthDate the new birth date
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
	 * Sets the email addr.
	 *
	 * @param emailAddr the new email addr
	 */
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
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
	 * Sets the checks if is admin.
	 *
	 * @param isAdmin the new checks if is admin
	 */
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * Sets the checks if is approver.
	 *
	 * @param isApprover the new checks if is approver
	 */
	public void setIsApprover(boolean isApprover) {
		this.isApprover = isApprover;
	}

	/**
	 * Sets the checks if is financial.
	 *
	 * @param isFinancial the new checks if is financial
	 */
	public void setIsFinancial(boolean isFinancial) {
		this.isFinancial = isFinancial;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
