package cn.edu.zucc.shijf.action;

import cn.edu.zucc.shijf.entity.Teacher;
import cn.edu.zucc.shijf.service.TeacherService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by wetsaid on 6/5/2016.
 */
public class TeacherAction extends BaseAction {

    private static final String TEACHER = "Teacher";
    private static final String ACCOUNT = "teacherAccount";
    private Teacher teacher;

    @Resource
    private TeacherService teacherService;

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

    public String addTeacher() {
        System.out.println("-------TeacherAction.addTeacher--------" + teacher.getTeacherName());
        teacherService.addTeacher(teacher);
        return "success";
    }

    public String updateTeacher() {
        System.out.println("-------TeacherAction.updateTeacher--------" + teacher.getTeacherName());
        teacherService.updateTeacher(teacher);
        return "success";
    }

    public String deleteTeacher() {
        System.out.println("-------TeacherAction.deleteTeacher--------" + teacher.getTeacherName());
        teacherService.deleteTeacher(teacher);
        return "success";
    }

    public void login() throws IOException {
        List list = teacherService.findByProperty(TEACHER, ACCOUNT, teacher.getTeacherAccount());
        if (list == null || list.size() < 1) {
            this.alertRedirect("教师账号不存在", "index.jsp");
        } else {
            Teacher oldTeacher = (Teacher) list.get(0);
            if (teacher.getTeacherPassword().equals(oldTeacher.getTeacherPassword())) {
                this.response.sendRedirect("top.jsp");
            } else {
                this.alertRedirect("错误！", "fail.jsp");
            }
        }
    }

    public void register() throws IOException {
        teacherService.addTeacher(teacher);
        this.response.sendRedirect("index.jsp");
    }
}
