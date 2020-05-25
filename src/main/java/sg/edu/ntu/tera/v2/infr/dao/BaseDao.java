/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.tera.v2.infr.dao;

import java.util.List;

import sg.edu.ntu.tera.v2.infr.model.BaseEntity;

/**
 * The Interface BaseDao.
 *
 * @param <E> the element type
 */
public interface BaseDao<E extends BaseEntity> {
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
	 * Gets the entity class.
	 *
	 * @return the entity class
	 */
	public abstract Class<E> getEntityClass();

	/**
	 * Gets the native query result.
	 *
	 * @param sql the sql
	 * @param params the params
	 * @return the native query result
	 */
	public abstract List<ResultSetPojo> getNativeQueryResult(String sql, Object[] params);

	/**
	 * Gets the query result.
	 *
	 * @param queryName the query name
	 * @param params the params
	 * @return the query result
	 */
	public abstract List<E> getQueryResult(String queryName, Object[] params);

	/**
	 * Gets the query single result.
	 *
	 * @param queryName the query name
	 * @param params the params
	 * @return the query single result
	 */
	public abstract E getQuerySingleResult(String queryName, Object[] params);

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
