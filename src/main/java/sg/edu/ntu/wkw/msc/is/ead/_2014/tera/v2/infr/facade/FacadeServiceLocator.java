/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.impl.ClaimFormFacadeBean;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.impl.ClaimFormItemFacadeBean;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.impl.ClaimTypeFacadeBean;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.impl.DepartmentFacadeBean;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.impl.FormStatusFacadeBean;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.impl.OperationAreaFacadeBean;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.impl.RegionFacadeBean;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.impl.UserFacadeBean;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormFacade;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimFormItemFacade;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.ClaimTypeFacade;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.DepartmentFacade;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.FormStatusFacade;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.OperationAreaFacade;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.RegionFacade;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.facade.intf.UserFacade;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.facade.impl.ReportFacadeBean;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.facade.intf.ReportFacade;

/**
 * The Class FacadeServiceLocator.
 */
public class FacadeServiceLocator {
	/** The Constant facadeServiceLocator. */
	private static final FacadeServiceLocator facadeServiceLocator = new FacadeServiceLocator();

	/**
	 * Gets the single instance of FacadeServiceLocator.
	 *
	 * @return single instance of FacadeServiceLocator
	 */
	public static FacadeServiceLocator getInstance() {
		return facadeServiceLocator;
	}

	/** The claim form facade. */
	private final ClaimFormFacade claimFormFacade;

	/** The claim form item facade. */
	private final ClaimFormItemFacade claimFormItemFacade;

	/** The claim type facade. */
	private final ClaimTypeFacade claimTypeFacade;

	/** The department facade. */
	private final DepartmentFacade departmentFacade;

	/** The form status facade. */
	private final FormStatusFacade formStatusFacade;

	/** The operation area facade. */
	private final OperationAreaFacade operationAreaFacade;

	/** The region facade. */
	private final RegionFacade regionFacade;

	/** The report facade. */
	private final ReportFacade reportFacade;

	/** The user facade. */
	private final UserFacade userFacade;

	/**
	 * Instantiates a new facade service locator.
	 */
	private FacadeServiceLocator() {
		this.claimFormFacade = new ClaimFormFacadeBean();
		this.claimFormItemFacade = new ClaimFormItemFacadeBean();
		this.claimTypeFacade = new ClaimTypeFacadeBean();
		this.departmentFacade = new DepartmentFacadeBean();
		this.formStatusFacade = new FormStatusFacadeBean();
		this.operationAreaFacade = new OperationAreaFacadeBean();
		this.regionFacade = new RegionFacadeBean();
		this.userFacade = new UserFacadeBean();
		this.reportFacade = new ReportFacadeBean();
	}

	/**
	 * Gets the claim form facade.
	 *
	 * @return the claim form facade
	 */
	public ClaimFormFacade getClaimFormFacade() {
		return claimFormFacade;
	}

	/**
	 * Gets the claim form item facade.
	 *
	 * @return the claim form item facade
	 */
	public ClaimFormItemFacade getClaimFormItemFacade() {
		return claimFormItemFacade;
	}

	/**
	 * Gets the claim type facade.
	 *
	 * @return the claim type facade
	 */
	public ClaimTypeFacade getClaimTypeFacade() {
		return claimTypeFacade;
	}

	/**
	 * Gets the department facade.
	 *
	 * @return the department facade
	 */
	public DepartmentFacade getDepartmentFacade() {
		return departmentFacade;
	}

	/**
	 * Gets the form status facade.
	 *
	 * @return the form status facade
	 */
	public FormStatusFacade getFormStatusFacade() {
		return formStatusFacade;
	}

	/**
	 * Gets the operation area facade.
	 *
	 * @return the operation area facade
	 */
	public OperationAreaFacade getOperationAreaFacade() {
		return operationAreaFacade;
	}

	/**
	 * Gets the region facade.
	 *
	 * @return the region facade
	 */
	public RegionFacade getRegionFacade() {
		return regionFacade;
	}

	/**
	 * Gets the report facade.
	 *
	 * @return the report facade
	 */
	public ReportFacade getReportFacade() {
		return reportFacade;
	}

	/**
	 * Gets the user facade.
	 *
	 * @return the user facade
	 */
	public UserFacade getUserFacade() {
		return userFacade;
	}
}
