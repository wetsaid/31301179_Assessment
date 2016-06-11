package cn.edu.zucc.shijf.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;
import java.sql.ResultSet;
import java.util.SortedMap;

/**
 * SQL服务类
 *
 * Created by wetsaid on 6/2/2016.
 */
public class SqlService {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 更新对象
	 * @param instance
	 */
	public void updateObject(Object instance) {
		try {
			this.sessionFactory.getCurrentSession().update(instance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
	 * 执行更新
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executeUpdate(String sql, Object[] params) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(sql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		int i = query.executeUpdate();
		return i;
	}

	/**
	 * 执行查询
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public SortedMap[] executeQuery(String sql, Object[] params) {

		SortedMap[] sms;

		Session session = this.sessionFactory.getCurrentSession();
		MyReturningWork myReturningWork = new MyReturningWork();
		myReturningWork.setSql(sql);
		myReturningWork.setParams(params);
		ResultSet resultSet = session.doReturningWork(myReturningWork);

		// 转换结果集为jstl的Result
		Result r = ResultSupport.toResult(resultSet);

		// 最终转换成SortedMap数组，方便jstl页面直接使用
		// 页面上使用规则：el表达式 {表名.数据库列名}
		sms = r.getRows();

		return sms;
	}

	/**
	 * 根据id删除某表名中的一条数据
	 * 
	 * @param tableName
	 * @param id
	 * @return
	 */
	public int executeDelete(String tableName, int id) {
		Object[] params = { id };
		return this.executeUpdate("delete from " + tableName + " where id=?",
				params);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	SqlService sqlService = (SqlService) Testing.getBean("sqlService");
////		Object[] params = { 1 };
////		SortedMap[] sms = sqlService.executeQuery(
////				"select * from user where id = ?", params);
////		System.out.println(sms.length);
//		Object[] params2 = { "chenghui", "12345678", "程慧", "136578220" };
//
// sqlService.executeUpdate(
// "insert into user(username,password,agname,qq)values(?,?,?,?)",
// params2);

		// sqlService.executeDelete("user", 3);

	}

}
