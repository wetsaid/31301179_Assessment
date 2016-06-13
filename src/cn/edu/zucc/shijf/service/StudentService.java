package cn.edu.zucc.shijf.service;

import cn.edu.zucc.shijf.dao.StudentDAO;
import cn.edu.zucc.shijf.entity.Student;

import java.util.List;

/**
 * Created by wetsaid on 2016/6/10.
 */
public class StudentService {

    private StudentDAO studentDAO;

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public Student getStudent(int studentId) {
        return studentDAO.get(studentId);
    }

    public void addStudent(Student student) {
        studentDAO.add(student);
    }

    public void updateStudent(Student student) {
        studentDAO.update(student);
    }

    public void deleteStudent(Student student) {
        studentDAO.delete(student.getStudentId());
    }

    public List findByProperty(String propertyName, Object value) {
        return studentDAO.findByProperty(propertyName, value);
    }

    public String modifyPassword(int studentId, String oldPassword, String newPassword) {
        Student student = studentDAO.get(studentId);
        if (oldPassword.equals(student.getStudentPassword())) {
            student.setStudentPassword(newPassword);
            studentDAO.update(student);
            return "";
        } else {
            return "原密码错误！";
        }
    }
}
