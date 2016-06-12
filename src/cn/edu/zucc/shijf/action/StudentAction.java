package cn.edu.zucc.shijf.action;

import cn.edu.zucc.shijf.entity.Student;
import cn.edu.zucc.shijf.page.PageBean;
import cn.edu.zucc.shijf.service.CourseService;
import cn.edu.zucc.shijf.service.StudentService;

import java.io.IOException;
import java.util.List;

/**
 * Created by wetsaid on 2016/6/10.
 */
public class StudentAction extends BaseAction {

    private static final String ACCOUNT = "studentAccount";
    private int pageSize;
    private int page;
    private Student student;
    private StudentService studentService;
    private CourseService courseService;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

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

    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
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
        List list = studentService.findByProperty(ACCOUNT, student.getStudentAccount());
        if (list == null || list.size() < 1) {
            this.alertRedirect("学生账号不存在", "loginStudent.jsp");
        } else {
            Student oldStudent = (Student) list.get(0);
            if (student.getStudentPassword().equals(oldStudent.getStudentPassword())) {
                session.put("studentId", oldStudent.getStudentId());
                session.put("studentName", oldStudent.getStudentName());
                session.put("userType", "student");
                this.response.sendRedirect("index.jsp");
            } else {
                this.alertRedirect("密码错误！", "loginStudent.jsp");
            }
        }
    }

    public void register() throws IOException {
        if ("".equals(student.getStudentAccount()) || student.getStudentAccount() == null) {
            this.alertRedirect("学生帐号不得为空！", "registerStudent.jsp");
            return;
        }

        List list = studentService.findByProperty(ACCOUNT, student.getStudentAccount());
        if (list.size() >= 1) {
            this.alertRedirect("学生账号已存在！", "registerStudent.jsp");
            return;
        }

        studentService.addStudent(student);
        this.response.sendRedirect("index.jsp");
    }

    public void showManageCenter() {
        PageBean pageBean = courseService.loadAllCourseByPage(pageSize, page);
        session.put("courses", pageBean.getList());
        session.put("coursesTotalPage", pageBean.getTotalPage());
        session.put("coursesAllRow", pageBean.getAllRow());
        session.put("coursesPageSize", pageBean.getPageSize());
        session.put("coursesCurrentPage", pageBean.getCurrentPage());
        this.forward("manageCenterStudent.jsp");
    }
}
