/*******************************************************************************
 * Copyright (c) 2014, Shijian Su. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shijian Su. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with him.
 ******************************************************************************/
package sg.edu.ntu.tera.v2.infr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.criterion.Order;
import org.hibernate.engine.SessionFactoryImplementor;

import sg.edu.ntu.tera.v2.infr.model.BaseEntity;

/**
 * The Class BaseDaoBean.
 *
 * @param <E> the element type
 */
public abstract class BaseDaoBean<E extends BaseEntity> implements BaseDao<E> {
	/** The Constant SESSION_FACTORY. */
	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

	/**
	 * Builds the session factory.
	 *
	 * @return the session factory
	 */
	public static SessionFactory buildSessionFactory() {
		SessionFactory result;
		try {
			result = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
		return result;
	}

	/**
	 * Close session.
	 *
	 * @param session the session
	 */
	public void closeSession(Session session) {
		try {
			if (session != null && session.isOpen()) {
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao.BaseDao#delete(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.model.BaseEntity)
	 */
	public void delete(E entity) {
		if (entity != null) {
			Session session = getSession();
			try {
				session.beginTransaction();
				session.delete(entity);
				session.flush();
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally {
				closeSession(session);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao.BaseDao#delete(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	public void delete(Long id) {
		Session session = getSession();
		E entity = null;
		try {
			if (id != null) {
				entity = (E) session.get(getEntityClass(), id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		if (entity != null) {
			delete(entity);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao.BaseDao#getNativeQueryResult(java.lang.String, java.lang.Object[])
	 */
	public List<ResultSetPojo> getNativeQueryResult(String sql, Object[] params) {
		List<ResultSetPojo> resultSetPojoList = new ArrayList<>();
		if (params != null) {
			int size = params.length;
			for (int i = 0; i < size; i++) {
				sql = sql.replace("?" + (i + 1), params[i] == null ? "''" : params[i].toString());
			}
		}
		// System.out.println(sql);
		ResultSet resultSet;
		Connection connection = null;
		try {
			ConnectionProvider cp = ((SessionFactoryImplementor) SESSION_FACTORY).getConnectionProvider();
			connection = cp.getConnection();
			Statement createStatement = connection.createStatement();
			resultSet = createStatement.executeQuery(sql);
			int columnCount = resultSet.getMetaData().getColumnCount();
			while (resultSet.next()) {
				ResultSetPojo resultSetPojo = new ResultSetPojo();
				for (int i = 1; i <= columnCount; i++) {
					resultSetPojo.getValue().add(resultSet.getObject(i));
				}
				resultSetPojoList.add(resultSetPojo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultSetPojoList;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao.BaseDao#getQueryResult(java.lang.String, java.lang.Object[])
	 */
	public List<E> getQueryResult(String queryName, Object[] params) {
		return returnNamedQuery(queryName, params);
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao.BaseDao#getQuerySingleResult(java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	public E getQuerySingleResult(String queryName, Object[] params) {
		Object o = null;
		List<E> list = getQueryResult(queryName, params);
		if (list != null && list.size() > 0) {
			o = list.get(0);
		}
		return (E) o;
	}

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	public Session getSession() {
		return SESSION_FACTORY.openSession();
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao.BaseDao#insert(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.model.BaseEntity)
	 */
	public void insert(E entity) {
		Session session = getSession();
		try {
			session.beginTransaction();
			session.save(entity);
			session.flush();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			closeSession(session);
		}
	}

	/**
	 * Return named query.
	 *
	 * @param queryName the query name
	 * @param params the params
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	private List<E> returnNamedQuery(String queryName, Object[] params) {
		Session session = getSession();
		Query query = null;
		try {
			query = session.getNamedQuery(queryName);
			if (params != null) {
				int size = params.length;
				for (int i = 0; i < size; i++) {
					query.setParameter(i, params[i]);
				}
			}
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao.BaseDao#selectAll()
	 */
	public List<E> selectAll() {
		return selectAll(null, false);
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao.BaseDao#selectAll(java.lang.String[], boolean)
	 */
	@SuppressWarnings("unchecked")
	public List<E> selectAll(String[] orderBys, boolean isAsc) {
		Session session = getSession();
		try {
			Criteria cq = session.createCriteria(getEntityClass());
			if (orderBys != null) {
				for (String orderBy : orderBys) {
					if (isAsc) {
						cq.addOrder(Order.asc(orderBy));
					} else {
						cq.addOrder(Order.desc(orderBy));
					}
				}
			}
			return cq.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao.BaseDao#selectById(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.model.BaseEntity)
	 */
	public E selectById(E entity) {
		if (entity != null && entity.getId() != null) {
			return selectById(entity.getId());
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao.BaseDao#selectById(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	public E selectById(Long id) {
		Session session = getSession();
		try {
			E entity = null;
			if (id != null) {
				entity = ((E) session.get(getEntityClass(), id));
			}
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao.BaseDao#update(sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.model.BaseEntity)
	 */
	public void update(E entity) {
		Session session = getSession();
		try {
			session.beginTransaction();
			session.merge(entity);
			session.flush();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			closeSession(session);
		}
	}
}
