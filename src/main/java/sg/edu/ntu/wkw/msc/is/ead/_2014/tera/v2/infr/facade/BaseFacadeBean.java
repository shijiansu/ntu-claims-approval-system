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
 * The Class BaseFacadeBean.
 *
 * @param <E> the element type
 * @param <D> the generic type
 */
public abstract class BaseFacadeBean<E extends BaseEntity, D extends BaseDao<E>> implements BaseFacade<E, D> {
	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade#delete(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.model.BaseEntity)
	 */
	public void delete(E entity) {
		getDao().delete(entity);
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade#delete(java.lang.Long)
	 */
	public void delete(Long id) {
		getDao().delete(id);
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade#insert(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.model.BaseEntity)
	 */
	public void insert(E entity) {
		getDao().insert(entity);
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade#selectAll()
	 */
	public List<E> selectAll() {
		return getDao().selectAll();
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade#selectAll(java.lang.String[], boolean)
	 */
	public List<E> selectAll(String[] orderBys, boolean isAsc) {
		return getDao().selectAll(orderBys, isAsc);
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade#selectById(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.model.BaseEntity)
	 */
	public E selectById(E entity) {
		return getDao().selectById(entity);
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade#selectById(java.lang.Long)
	 */
	public E selectById(Long id) {
		return getDao().selectById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.BaseFacade#update(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.model.BaseEntity)
	 */
	public void update(E entity) {
		getDao().update(entity);
	}
}
