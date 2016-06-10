package cn.edu.zucc.shijf.action;

import cn.edu.zucc.shijf.entity.Student;
import cn.edu.zucc.shijf.service.StudentService;

import java.io.IOException;
import java.util.List;

/**
 * Created by wetsaid on 2016/6/10.
 */
public class StudentAction extends BaseAction {

    private static final String STUDENT = "Student";
    private static final String ACCOUNT = "studentAccount";
    private Student student;
    private StudentService studentService;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public String addStudent() {
        System.out.println("-------StudentAction.addStudent--------" + student.getStudentName());
        studentService.addStudent(student);
        return "success";
    }

    public String updateStudent() {
        System.out.println("-------StudentAction.updateStudent--------" + student.getStudentName());
        studentService.updateStudent(student);
        return "success";
    }

    public String deleteStudent() {
        System.out.println("-------StudentAction.deleteStudent--------" + student.getStudentName());
        studentService.deleteStudent(student);
        return "success";
    }

    public void login() throws IOException {
        List list = studentService.findByProperty(STUDENT, ACCOUNT, student.getStudentAccount());
        System.out.println("end");
        if (list == null || list.size() < 1) {
            this.alertRedirect("学生账号不存在", "index.jsp");
        } else {
            Student oldStudent = (Student) list.get(0);
            if (student.getStudentPassword().equals(oldStudent.getStudentPassword())) {
                this.response.sendRedirect("top.jsp");
            } else {
                this.alertRedirect("错误！", "fail.jsp");
            }
        }
    }

    public void register() throws IOException {
        studentService.addStudent(student);
        this.response.sendRedirect("index.jsp");
    }
}
