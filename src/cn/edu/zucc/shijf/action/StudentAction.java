package cn.edu.zucc.shijf.action;

import cn.edu.zucc.shijf.entity.Student;
import cn.edu.zucc.shijf.page.PageBean;
import cn.edu.zucc.shijf.service.ChooseCourseService;
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
    private ChooseCourseService chooseCourseService;

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

    public ChooseCourseService getChooseCourseService() {
        return chooseCourseService;
    }

    public void setChooseCourseService(ChooseCourseService chooseCourseService) {
        this.chooseCourseService = chooseCourseService;
    }

    public void login() throws IOException {
        String account = (String) session.get("account");
        String password = (String) session.get("password");
        session.clear();
        List list = studentService.findByProperty(ACCOUNT, account);
        if (list == null || list.size() < 1) {
            this.alertRedirect("学生账号不存在", "login.jsp");
        } else {
            Student oldStudent = (Student) list.get(0);
            if (!password.equals(oldStudent.getStudentPassword())) {
                this.alertRedirect("密码错误！", "login.jsp");
            } else {
                session.put("studentId", oldStudent.getStudentId());
                session.put("studentName", oldStudent.getStudentName());
                session.put("userType", "student");

                this.getStudentInformation();
                this.response.sendRedirect("index.jsp");
            }
        }
    }

    public void register() throws IOException {
        String account = (String) session.get("account");
        String password = (String) session.get("password");
        String name = (String) session.get("name");
        session.clear();
        List list = studentService.findByProperty(ACCOUNT, account);
        if (list.size() >= 1) {
            this.alertRedirect("学生账号已存在！", "register.jsp");
            return;
        }
        student = new Student();
        student.setStudentAccount(account);
        student.setStudentPassword(password);
        student.setStudentName(name);
        studentService.addStudent(student);
        this.alertRedirect("注册成功！", "register.jsp");
    }

    public void showManageCenter() {
        //获取全部可选课程
        PageBean pageBean = courseService.loadAllCourseByPage(pageSize, page);
        session.put("courses", pageBean.getList());
        session.put("coursesTotalPage", pageBean.getTotalPage());
        session.put("coursesAllRow", pageBean.getAllRow());
        session.put("coursesPageSize", pageBean.getPageSize());
        session.put("coursesCurrentPage", pageBean.getCurrentPage());

        this.forward("manageCenterStudent.jsp");
    }

    private void getStudentInformation() {
        int studentId = (int) session.get("studentId");
        Student student = studentService.getStudent(studentId);
        session.put("student", student);

        //我的课程
        List myCourses = chooseCourseService.loadMyCourse(studentId);
        session.put("myCourses", myCourses);
        session.put("myCoursesAllRow", myCourses.size());
    }

    public void updateInformation() {
        studentService.updateStudent(student);
        session.put("studentName", student.getStudentName());
        this.alertRedirect("修改成功！", "manageCenterStudent.jsp");
    }
}
