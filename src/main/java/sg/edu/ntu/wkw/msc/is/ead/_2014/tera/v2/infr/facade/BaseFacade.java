/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade;

import java.util.List;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao.BaseDao;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.model.BaseEntity;

/**
 * The Interface BaseFacade.
 *
 * @param <E> the element type
 * @param <D> the generic type
 */
public interface BaseFacade<E extends BaseEntity, D extends BaseDao<E>> {
	/**
	 * Delete.
	 *
	 * @param entity the entity
	 */
	public abstract void delete(E entity);

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public abstract void delete(Long id);

	/**
	 * Gets the dao.
	 *
	 * @return the dao
	 */
	public abstract D getDao();

	/**
	 * Insert.
	 *
	 * @param entity the entity
	 */
	public abstract void insert(E entity);

	/**
	 * Select all.
	 *
	 * @return the list
	 */
	public abstract List<E> selectAll();

	/**
	 * Select all.
	 *
	 * @param orderBys the order bys
	 * @param isAsc the is asc
	 * @return the list
	 */
	public abstract List<E> selectAll(String[] orderBys, boolean isAsc);

	/**
	 * Select by id.
	 *
	 * @param entity the entity
	 * @return the e
	 */
	public abstract E selectById(E entity);

	/**
	 * Select by id.
	 *
	 * @param id the id
	 * @return the e
	 */
	public abstract E selectById(Long id);

	/**
	 * Update.
	 *
	 * @param entity the entity
	 */
	public abstract void update(E entity);
}
