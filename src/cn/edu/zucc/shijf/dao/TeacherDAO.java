package cn.edu.zucc.shijf.dao;

import cn.edu.zucc.shijf.entity.Teacher;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by wetsaid on 6/2/2016.
 */
public class TeacherDAO {

    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addTeacher(Teacher teacher) {
        System.out.println("-------TeacherDAO.addTeacher-----------" + teacher.getTeacherName());
        getSession().save(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        System.out.println("-------TeacherDAO.updateTeacher-----------" + teacher.getTeacherName());
        getSession().update(teacher);
    }

    public void deleteTeacher(Teacher teacher) {
        System.out.println("-------TeacherDAO.deleteTeacher-----------" + teacher.getTeacherName());
        getSession().delete(teacher);
    }

    public List findByProperty(String propertyName, Object value) {
        String queryString = "from Teacher as model where model." + propertyName + "= ?";
        Query queryObject = getSession().createQuery(queryString);
        queryObject.setParameter(0, value);
        return queryObject.list();
    }
}
