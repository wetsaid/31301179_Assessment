package com.sshhw.core;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for Blog
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see Blog
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class BlogDAO {
	private static final Logger log = LoggerFactory.getLogger(BlogDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String CONTEXT = "context";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Blog transientInstance) {
		log.debug("saving Blog instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Blog persistentInstance) {
		log.debug("deleting Blog instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Blog findById(Integer id) {
		log.debug("getting Blog instance with id: " + id);
		try {
			Blog instance = (Blog) getCurrentSession().get(
					"com.sshhw.core.Blog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Blog> findByExample(Blog instance) {
		log.debug("finding Blog instance by example");
		try {
			List<Blog> results = (List<Blog>) getCurrentSession()
					.createCriteria("com.sshhw.core.Blog")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Blog instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Blog as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Blog> findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List<Blog> findByContext(Object context) {
		return findByProperty(CONTEXT, context);
	}

	public List findAll() {
		log.debug("finding all Blog instances");
		try {
			String queryString = "from Blog";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Blog merge(Blog detachedInstance) {
		log.debug("merging Blog instance");
		try {
			Blog result = (Blog) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Blog instance) {
		log.debug("attaching dirty Blog instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Blog instance) {
		log.debug("attaching clean Blog instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BlogDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BlogDAO) ctx.getBean("BlogDAO");
	}
}