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

    public void addStudent(Student student) {
        System.out.println("------StudentService.addStudent--------" + student.getStudentName());
        studentDAO.add(student);
    }

    public void updateStudent(Student student) {
        System.out.println("------StudentService.updateStudent--------" + student.getStudentName());
        studentDAO.update(student);
    }

    public void deleteStudent(Student student) {
        System.out.println("------StudentService.deleteStudent--------" + student.getStudentName());
        studentDAO.delete(student.getStudentId());
    }

    public List findByProperty(String tableName, String propertyName, Object value) {
        return studentDAO.findByProperty(tableName, propertyName, value);
    }
}
