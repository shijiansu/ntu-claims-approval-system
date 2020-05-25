package sg.edu.ntu.tera.v2.app.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import sg.edu.ntu.tera.v2.infr.model.AuditEntity;

/**
 * The Class Region.
 */
public class Region extends AuditEntity {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1667535338306284963L;

	/** The depts. */
	private Set<Department> depts = new HashSet<Department>(0);

	/** The id. */
	private Long id;

	/** The region name. */
	private String regionName;

	/**
	 * Instantiates a new region.
	 */
	public Region() {
	}

	/**
	 * Instantiates a new region.
	 *
	 * @param id the id
	 * @param regionName the region name
	 */
	public Region(Long id, String regionName) {
		this.id = id;
		this.regionName = regionName;
	}

	/**
	 * Instantiates a new region.
	 *
	 * @param id the id
	 * @param regionName the region name
	 * @param createBy the create by
	 * @param createTime the create time
	 * @param updateBy the update by
	 * @param updateTime the update time
	 * @param depts the depts
	 */
	public Region(Long id, String regionName, String createBy, Date createTime, String updateBy, Date updateTime, Set<Department> depts) {
		this.id = id;
		this.regionName = regionName;
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
		this.depts = depts;
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
	 * Gets the region name.
	 *
	 * @return the region name
	 */
	public String getRegionName() {
		return this.regionName;
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
	 * Sets the region name.
	 *
	 * @param regionName the new region name
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
}
