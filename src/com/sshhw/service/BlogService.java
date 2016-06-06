package com.sshhw.service;

import java.util.List;

import org.hibernate.Query;

import com.sshhw.core.BlogDAO;

public class BlogService extends BlogDAO {

	private SqlService sqlService;

	public SqlService getSqlService() {
		return sqlService;
	}

	public void setSqlService(SqlService sqlService) {
		this.sqlService = sqlService;
	}

	/**
	 * 根据用户id获得该用户所有文章,倒序
	 * @param userId
	 * @return
	 */
	public List getUserBlogsOrderByTime(int userId) {

		String hql = "from Blog as b where user.id = ? order by b.publishTime Desc";

		Query query = sqlService.getSessionFactory().getCurrentSession()
				.createQuery(hql);

		query.setParameter(0, userId);

		return query.list();

	}
}
