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

    public Teacher getTeacher(int teacherId) {
        return teacherDAO.get(teacherId);
    }

    public void addTeacher(Teacher teacher) {
        teacherDAO.add(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        teacherDAO.update(teacher);
    }

    public void deleteTeacher(int teacherId) {
        teacherDAO.delete(teacherId);
    }

    public List findByProperty(String propertyName, Object value) {
        return teacherDAO.findByProperty(propertyName, value);
    }

    public String modifyPassword(int teacherId, String oldPassword, String newPassword) {
        Teacher teacher = teacherDAO.get(teacherId);
        if (!oldPassword.equals(teacher.getTeacherPassword())) {
            return "原密码错误！";
        } else {
            teacher.setTeacherPassword(newPassword);
            teacherDAO.update(teacher);
            return null;
        }
    }
}
