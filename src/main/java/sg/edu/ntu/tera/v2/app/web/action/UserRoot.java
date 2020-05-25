package sg.edu.ntu.tera.v2.app.web.action;

import sg.edu.ntu.tera.v2.app.facade.UserFacade;
import sg.edu.ntu.tera.v2.app.model.User;
import sg.edu.ntu.tera.v2.infr.web.action.BaseAction;
import sg.edu.ntu.tera.v2.app.dao.UserDao;

/**
 * The Class UserRoot.
 */
public abstract class UserRoot extends BaseAction<User, UserDao, UserFacade> {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8967321849733749965L;

	/** The Constant ACTION_EDIT_PASSWORD. */
	public static final String ACTION_EDIT_PASSWORD = "editPassword";

	/** The Constant ACTION_EXPRIE_COOKIE. */
	public static final String ACTION_EXPRIE_COOKIE = "expireCookie";

	/** The Constant ACTION_SIGNIN. */
	public static final String ACTION_SIGNIN = "signin";

	/** The Constant ACTION_SIGNOUT. */
	public static final String ACTION_SIGNOUT = "signout";

	/** The Constant ACTION_VIEW_DASHBOARD. */
	public static final String ACTION_VIEW_DASHBOARD = "viewDashboard";

	/** The input user id. */
	private String inputUserId;

	/** The input user name. */
	private String inputUserName;

	/** The checkbox remember me. */
	private String checkboxRememberMe;

	/** The input first name. */
	private String inputFirstName;

	/** The input last name. */
	private String inputLastName;

	/** The input password. */
	private String inputPassword;

	/** The input old password. */
	private String inputOldPassword;

	/** The input new password. */
	private String inputNewPassword;

	/** The select gender. */
	private String selectGender;

	/** The input email. */
	private String inputEmail;

	/** The input birth date. */
	private String inputBirthDate;

	/** The is administrator radios. */
	private String isAdministratorRadios;

	/** The select department. */
	private String selectDepartment;

	/** The checkbox update password. */
	private String checkboxUpdatePassword;

	/**
	 * Gets the input user id.
	 *
	 * @return the input user id
	 */
	public String getInputUserId() {
		return inputUserId;
	}

	/**
	 * Sets the input user id.
	 *
	 * @param inputUserId the new input user id
	 */
	public void setInputUserId(String inputUserId) {
		this.inputUserId = inputUserId;
	}

	/**
	 * Gets the input user name.
	 *
	 * @return the input user name
	 */
	public String getInputUserName() {
		return inputUserName;
	}

	/**
	 * Sets the input user name.
	 *
	 * @param inputUserName the new input user name
	 */
	public void setInputUserName(String inputUserName) {
		this.inputUserName = inputUserName;
	}

	/**
	 * Gets the input first name.
	 *
	 * @return the input first name
	 */
	public String getInputFirstName() {
		return inputFirstName;
	}

	/**
	 * Sets the input first name.
	 *
	 * @param inputFirstName the new input first name
	 */
	public void setInputFirstName(String inputFirstName) {
		this.inputFirstName = inputFirstName;
	}

	/**
	 * Gets the input last name.
	 *
	 * @return the input last name
	 */
	public String getInputLastName() {
		return inputLastName;
	}

	/**
	 * Sets the input last name.
	 *
	 * @param inputLastName the new input last name
	 */
	public void setInputLastName(String inputLastName) {
		this.inputLastName = inputLastName;
	}

	/**
	 * Gets the input password.
	 *
	 * @return the input password
	 */
	public String getInputPassword() {
		return inputPassword;
	}

	/**
	 * Sets the input password.
	 *
	 * @param inputPassword the new input password
	 */
	public void setInputPassword(String inputPassword) {
		this.inputPassword = inputPassword;
	}

	/**
	 * Gets the input old password.
	 *
	 * @return the input old password
	 */
	public String getInputOldPassword() {
		return inputOldPassword;
	}

	/**
	 * Sets the input old password.
	 *
	 * @param inputOldPassword the new input old password
	 */
	public void setInputOldPassword(String inputOldPassword) {
		this.inputOldPassword = inputOldPassword;
	}

	/**
	 * Gets the input new password.
	 *
	 * @return the input new password
	 */
	public String getInputNewPassword() {
		return inputNewPassword;
	}

	/**
	 * Sets the input new password.
	 *
	 * @param inputNewPassword the new input new password
	 */
	public void setInputNewPassword(String inputNewPassword) {
		this.inputNewPassword = inputNewPassword;
	}

	/**
	 * Gets the select gender.
	 *
	 * @return the select gender
	 */
	public String getSelectGender() {
		return selectGender;
	}

	/**
	 * Sets the select gender.
	 *
	 * @param selectGender the new select gender
	 */
	public void setSelectGender(String selectGender) {
		this.selectGender = selectGender;
	}

	/**
	 * Gets the input email.
	 *
	 * @return the input email
	 */
	public String getInputEmail() {
		return inputEmail;
	}

	/**
	 * Sets the input email.
	 *
	 * @param inputEmail the new input email
	 */
	public void setInputEmail(String inputEmail) {
		this.inputEmail = inputEmail;
	}

	/**
	 * Gets the input birth date.
	 *
	 * @return the input birth date
	 */
	public String getInputBirthDate() {
		return inputBirthDate;
	}

	/**
	 * Sets the input birth date.
	 *
	 * @param inputBirthDate the new input birth date
	 */
	public void setInputBirthDate(String inputBirthDate) {
		this.inputBirthDate = inputBirthDate;
	}

	/**
	 * Gets the checks if is administrator radios.
	 *
	 * @return the checks if is administrator radios
	 */
	public String getIsAdministratorRadios() {
		return isAdministratorRadios;
	}

	/**
	 * Sets the checks if is administrator radios.
	 *
	 * @param isAdministratorRadios the new checks if is administrator radios
	 */
	public void setIsAdministratorRadios(String isAdministratorRadios) {
		this.isAdministratorRadios = isAdministratorRadios;
	}

	/**
	 * Gets the select department.
	 *
	 * @return the select department
	 */
	public String getSelectDepartment() {
		return selectDepartment;
	}

	/**
	 * Sets the select department.
	 *
	 * @param selectDepartment the new select department
	 */
	public void setSelectDepartment(String selectDepartment) {
		this.selectDepartment = selectDepartment;
	}

	/**
	 * Gets the checkbox remember me.
	 *
	 * @return the checkbox remember me
	 */
	public String getCheckboxRememberMe() {
		return checkboxRememberMe;
	}

	/**
	 * Sets the checkbox remember me.
	 *
	 * @param checkboxRememberMe the new checkbox remember me
	 */
	public void setCheckboxRememberMe(String checkboxRememberMe) {
		this.checkboxRememberMe = checkboxRememberMe;
	}

	/**
	 * Gets the checkbox update password.
	 *
	 * @return the checkbox update password
	 */
	public String getCheckboxUpdatePassword() {
		return checkboxUpdatePassword;
	}

	/**
	 * Sets the checkbox update password.
	 *
	 * @param checkboxUpdatePassword the new checkbox update password
	 */
	public void setCheckboxUpdatePassword(String checkboxUpdatePassword) {
		this.checkboxUpdatePassword = checkboxUpdatePassword;
	}
}
