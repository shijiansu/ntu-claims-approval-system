package sg.edu.ntu.tera.v2.app.web.action;

import sg.edu.ntu.tera.v2.app.facade.DepartmentFacade;
import sg.edu.ntu.tera.v2.app.model.Department;
import sg.edu.ntu.tera.v2.infr.web.action.BaseAction;
import sg.edu.ntu.tera.v2.app.dao.DepartmentDao;

/**
 * The Class DepartmentRoot.
 */
public abstract class DepartmentRoot extends
    BaseAction<Department, DepartmentDao, DepartmentFacade> {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5701460934406630789L;

	/** The Constant ACTION_CREATE_USER. */
	public static final String ACTION_CREATE_USER = "createUser";

	/** The Constant ACTION_DELETE_USER. */
	public static final String ACTION_DELETE_USER = "deleteUser";

	/** The Constant MODULE_NAME. */
	public static final String MODULE_NAME = "department";

	/** The input department id. */
	private String inputDepartmentId;

	/** The input user id. */
	private String inputUserId;

	/** The input department name. */
	private String inputDepartmentName;

	/** The select operation area. */
	private String selectOperationArea;

	/** The select region. */
	private String selectRegion;

	/** The input telephone number. */
	private String inputTelephoneNumber;

	/** The input office address. */
	private String inputOfficeAddress;

	/** The select user. */
	private String selectUser;

	/** The select manager. */
	private String selectManager;

	/**
	 * Gets the input department id.
	 *
	 * @return the input department id
	 */
	public String getInputDepartmentId() {
		return inputDepartmentId;
	}

	/**
	 * Sets the input department id.
	 *
	 * @param inputDepartmentId the new input department id
	 */
	public void setInputDepartmentId(String inputDepartmentId) {
		this.inputDepartmentId = inputDepartmentId;
	}

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
	 * Gets the input department name.
	 *
	 * @return the input department name
	 */
	public String getInputDepartmentName() {
		return inputDepartmentName;
	}

	/**
	 * Sets the input department name.
	 *
	 * @param inputDepartmentName the new input department name
	 */
	public void setInputDepartmentName(String inputDepartmentName) {
		this.inputDepartmentName = inputDepartmentName;
	}

	/**
	 * Gets the select operation area.
	 *
	 * @return the select operation area
	 */
	public String getSelectOperationArea() {
		return selectOperationArea;
	}

	/**
	 * Sets the select operation area.
	 *
	 * @param selectOperationArea the new select operation area
	 */
	public void setSelectOperationArea(String selectOperationArea) {
		this.selectOperationArea = selectOperationArea;
	}

	/**
	 * Gets the select region.
	 *
	 * @return the select region
	 */
	public String getSelectRegion() {
		return selectRegion;
	}

	/**
	 * Sets the select region.
	 *
	 * @param selectRegion the new select region
	 */
	public void setSelectRegion(String selectRegion) {
		this.selectRegion = selectRegion;
	}

	/**
	 * Gets the input telephone number.
	 *
	 * @return the input telephone number
	 */
	public String getInputTelephoneNumber() {
		return inputTelephoneNumber;
	}

	/**
	 * Sets the input telephone number.
	 *
	 * @param inputTelephoneNumber the new input telephone number
	 */
	public void setInputTelephoneNumber(String inputTelephoneNumber) {
		this.inputTelephoneNumber = inputTelephoneNumber;
	}

	/**
	 * Gets the input office address.
	 *
	 * @return the input office address
	 */
	public String getInputOfficeAddress() {
		return inputOfficeAddress;
	}

	/**
	 * Sets the input office address.
	 *
	 * @param inputOfficeAddress the new input office address
	 */
	public void setInputOfficeAddress(String inputOfficeAddress) {
		this.inputOfficeAddress = inputOfficeAddress;
	}

	/**
	 * Gets the select user.
	 *
	 * @return the select user
	 */
	public String getSelectUser() {
		return selectUser;
	}

	/**
	 * Sets the select user.
	 *
	 * @param selectUser the new select user
	 */
	public void setSelectUser(String selectUser) {
		this.selectUser = selectUser;
	}

	/**
	 * Gets the select manager.
	 *
	 * @return the select manager
	 */
	public String getSelectManager() {
		return selectManager;
	}

	/**
	 * Sets the select manager.
	 *
	 * @param selectManager the new select manager
	 */
	public void setSelectManager(String selectManager) {
		this.selectManager = selectManager;
	}
}
