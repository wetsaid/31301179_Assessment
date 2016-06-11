package cn.edu.zucc.shijf.service;

import cn.edu.zucc.shijf.dao.TeacherDAO;
import cn.edu.zucc.shijf.entity.Teacher;

import java.util.List;

/**
 * Created by wetsaid on 6/5/2016.
 */
public class TeacherService {

    private TeacherDAO teacherDAO;

    public TeacherDAO getTeacherDAO() {
        return teacherDAO;
    }

    public void setTeacherDAO(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public void addTeacher(Teacher teacher) {
        System.out.println("------TeacherService.addTeacher--------" + teacher.getTeacherName());
        teacherDAO.add(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        System.out.println("------TeacherService.updateTeacher--------" + teacher.getTeacherName());
        teacherDAO.update(teacher);
    }

    public void deleteTeacher(Teacher teacher) {
        System.out.println("------TeacherService.deleteTeacher--------" + teacher.getTeacherName());
        teacherDAO.delete(teacher.getTeacherId());
    }

    public List findByProperty(String propertyName, Object value) {
        return teacherDAO.findByProperty(propertyName, value);
    }
}
