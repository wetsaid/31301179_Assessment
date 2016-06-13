package cn.edu.zucc.shijf.action;

import cn.edu.zucc.shijf.entity.Teacher;
import cn.edu.zucc.shijf.page.PageBean;
import cn.edu.zucc.shijf.service.CourseService;
import cn.edu.zucc.shijf.service.TeacherService;

import java.io.IOException;
import java.util.List;

/**
 * Created by wetsaid on 6/5/2016.
 */
public class TeacherAction extends BaseAction {

    private static final String ACCOUNT = "teacherAccount";
    private int pageSize;
    private int page;
    private Teacher teacher;
    private TeacherService teacherService;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public TeacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    public void login() throws IOException {
        List list = teacherService.findByProperty(ACCOUNT, teacher.getTeacherAccount());
        if (list == null || list.size() < 1) {
            this.alertRedirect("教师账号不存在", "loginTeacher.jsp");
        } else {
            Teacher oldTeacher = (Teacher) list.get(0);
            if (teacher.getTeacherPassword().equals(oldTeacher.getTeacherPassword())) {
                session.put("teacherId", oldTeacher.getTeacherId());
                session.put("teacherName", oldTeacher.getTeacherName());
                session.put("userType", "teacher");
                this.response.sendRedirect("index.jsp");
            } else {
                this.alertRedirect("密码错误！", "loginTeacher.jsp");
            }
        }
    }

    public void register() throws IOException {
        if ("".equals(teacher.getTeacherAccount()) || teacher.getTeacherAccount() == null) {
            this.alertRedirect("教师帐号不得为空！", "registerTeacher.jsp");
            return;
        }

        List list = teacherService.findByProperty(ACCOUNT, teacher.getTeacherAccount());
        if (list.size() >= 1) {
            this.alertRedirect("教师账号已存在！", "registerTeacher.jsp");
            return;
        }

        teacherService.addTeacher(teacher);
        this.response.sendRedirect("index.jsp");
    }

    public void showManageCenter() {
        int teacherId = (int) session.get("teacherId");
        PageBean pageBean = courseService.loadTeachersCoursesByPage(teacherId, pageSize, page);
        session.put("courses", pageBean.getList());
        session.put("coursesTotalPage", pageBean.getTotalPage());
        session.put("coursesAllRow", pageBean.getAllRow());
        session.put("coursesPageSize", pageBean.getPageSize());
        session.put("coursesCurrentPage", pageBean.getCurrentPage());
        this.forward("manageCenterTeacher.jsp");
    }

    public void showEditTeacher() {
        int teacherId = (int) session.get("teacherId");
        Teacher teacher = teacherService.getTeacher(teacherId);
        request.setAttribute("teacher", teacher);
        this.forward("editTeacher.jsp");
    }

    public void updateInformation() {
        teacherService.updateTeacher(teacher);
        session.put("teacherName", teacher.getTeacherName());
        this.alertRedirect("修改成功！", "manageCenterTeacher.jsp");
    }
}
