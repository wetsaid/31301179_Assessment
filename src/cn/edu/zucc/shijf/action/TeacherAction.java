package cn.edu.zucc.shijf.action;

import cn.edu.zucc.shijf.entity.Teacher;
import cn.edu.zucc.shijf.service.TeacherService;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

/**
 * Created by wetsaid on 6/5/2016.
 */
public class TeacherAction extends ActionSupport {

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
}
