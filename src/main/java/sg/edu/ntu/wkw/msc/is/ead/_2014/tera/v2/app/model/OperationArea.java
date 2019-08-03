package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.app.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.model.AuditEntity;

/**
 * The Class OperationArea.
 */
public class OperationArea extends AuditEntity {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3231658078759147932L;

	/** The area name. */
	private String areaName;

	/** The depts. */
	private Set<Department> depts = new HashSet<Department>(0);

	/** The id. */
	private Long id;

	/** The is financial. */
	private String isFinancial;

	/**
	 * Instantiates a new operation area.
	 */
	public OperationArea() {
	}

	/**
	 * Instantiates a new operation area.
	 *
	 * @param id the id
	 * @param areaName the area name
	 * @param isFinancial the is financial
	 */
	public OperationArea(Long id, String areaName, String isFinancial) {
		this.id = id;
		this.areaName = areaName;
		this.isFinancial = isFinancial;
	}

	/**
	 * Instantiates a new operation area.
	 *
	 * @param id the id
	 * @param areaName the area name
	 * @param isFinancial the is financial
	 * @param createBy the create by
	 * @param createTime the create time
	 * @param updateBy the update by
	 * @param updateTime the update time
	 * @param depts the depts
	 */
	public OperationArea(Long id, String areaName, String isFinancial, String createBy, Date createTime, String updateBy, Date updateTime, Set<Department> depts) {
		this.id = id;
		this.areaName = areaName;
		this.isFinancial = isFinancial;
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
		this.depts = depts;
	}

	/**
	 * Gets the area name.
	 *
	 * @return the area name
	 */
	public String getAreaName() {
		return this.areaName;
	}

	/**
	 * Gets the depts.
	 *
	 * @return the depts
	 */
	public Set<Department> getDepts() {
		return this.depts;
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
	 * Gets the checks if is financial.
	 *
	 * @return the checks if is financial
	 */
	public String getIsFinancial() {
		return this.isFinancial;
	}

	/**
	 * Sets the area name.
	 *
	 * @param areaName the new area name
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * Sets the depts.
	 *
	 * @param depts the new depts
	 */
	public void setDepts(Set<Department> depts) {
		this.depts = depts;
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
	 * Sets the checks if is financial.
	 *
	 * @param isFinancial the new checks if is financial
	 */
	public void setIsFinancial(String isFinancial) {
		this.isFinancial = isFinancial;
	}
}
