package cn.edu.zucc.shijf.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import cn.edu.zucc.shijf.page.PageBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wetsaid on 2016/6/10.
 */
@SuppressWarnings("unchecked")
public class BaseDAO<T> {

    private Class<T> clazz;

    /**
     * 通过构造方法指定DAO的具体实现类
     */
    public BaseDAO() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
        //	System.out.println("DAO的真实实现类是：" + this.clazz.getName());
    }

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {

        //事务必须是开启的(Required)，否则获取不到
        return sessionFactory.getCurrentSession();
    }

    public void save(T entity) {
        this.getSession().save(entity);
    }

    public void update(T entity) {
        this.getSession().update(entity);
    }

    public void delete(Serializable id) {
        this.getSession().delete(this.get(id));
    }

    public T get(Serializable id) {
        return (T) this.getSession().get(this.clazz, id);
    }

    public List<T> findByHQL(String hql, Object[] params) {
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
        return query.list();
    }

    public int getAllRowCount(String hql , final Object[] params ){
        Query query = getSession().createQuery(hql.toString());
        for (int i = 0; params != null && i < params.length; i++)
        {
            query.setParameter( i , params[i]);
        }
        return query.list().size();

    }

    /**
     * 使用hql 语句进行分页查询操作
     * @param hql 需要查询的hql语句
     * @param params 如果hql有多个个参数需要传入，params就是传入的参数数组
     * @param offset 第一条记录索引
     * @param length 每页需要显示的记录数
     * @return 当前页的所有记录
     */
    public List<T> queryForPage(final String hql, final Object[] params ,final int offset,final int length){
        Query query = getSession().createQuery(hql);
        for (int i = 0; params != null && i < params.length; i++)
        {
            query.setParameter( i , params[i]);
        }
        query.setFirstResult(offset);
        query.setMaxResults(length);
        List<T> list = query.list();
        return list;
    }

    public PageBean findForPage(String hql , final Object[] values, int pageSize, int page){
        int allRow = getAllRowCount(hql,values);    //总记录数
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数
        final int currentPage = PageBean.countCurrentPage(page);
        final int offset = PageBean.countOffset(pageSize, currentPage);    //当前页开始记录
        final int length = pageSize;    //每页记录数

        List<T> list = queryForPage(hql,values,offset, length);
        //把分页信息保存到Bean中
        PageBean pageBean = new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currentPage);
        pageBean.setAllRow(allRow);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(list);
        pageBean.init();
        return pageBean;
    }
}
