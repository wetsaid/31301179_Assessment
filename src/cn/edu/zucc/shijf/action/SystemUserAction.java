package cn.edu.zucc.shijf.action;

import cn.edu.zucc.shijf.entity.Student;
import cn.edu.zucc.shijf.entity.SystemUser;
import cn.edu.zucc.shijf.entity.Teacher;
import cn.edu.zucc.shijf.service.StudentService;
import cn.edu.zucc.shijf.service.SystemUserService;
import cn.edu.zucc.shijf.service.TeacherService;

import java.io.IOException;
import java.util.List;

/**
 * Created by wetsaid on 2016/6/10.
 */
public class SystemUserAction extends BaseAction {

    private static final String ACCOUNT = "userAccount";
    private String oldPassword;
    private String newPassword1;
    private String newPassword2;
    private SystemUser systemUser;
    private SystemUserService systemUserService;
    private TeacherService teacherService;
    private StudentService studentService;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword1() {
        return newPassword1;
    }

    public void setNewPassword1(String newPassword1) {
        this.newPassword1 = newPassword1;
    }

    public String getNewPassword2() {
        return newPassword2;
    }

    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    public SystemUserService getSystemUserService() {
        return systemUserService;
    }

    public void setSystemUserService(SystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }

    public TeacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void login() throws IOException {
        List list = systemUserService.findByProperty(ACCOUNT, systemUser.getUserAccount());
        if (list == null || list.size() < 1) {
            this.alertRedirect("管理员账号不存在", "loginSystemUser.jsp");
        } else {
            SystemUser oldSystemUser = (SystemUser) list.get(0);
            if (systemUser.getUserPassword().equals(oldSystemUser.getUserPassword())) {
                session.put("userId", oldSystemUser.getUserId());
                session.put("userName", oldSystemUser.getUserName());
                session.put("userType", "systemUser");
                this.response.sendRedirect("index.jsp");
            } else {
                this.alertRedirect("密码错误！", "loginSystemUser.jsp");
            }
        }
    }

    public void register() throws IOException {
        if ("".equals(systemUser.getUserAccount()) || systemUser.getUserAccount() == null) {
            this.alertRedirect("管理员帐号不得为空！", "registerSystemUser.jsp");
            return;
        }

        List list = systemUserService.findByProperty(ACCOUNT, systemUser.getUserAccount());
        if (list.size() >= 1) {
            this.alertRedirect("管理员账号已存在！", "registerSystemUser.jsp");
            return;
        }

        systemUserService.addSystemUser(systemUser);
        this.response.sendRedirect("index.jsp");
    }

    public void modifyPassword() {
        if (!newPassword1.equals(newPassword2)) {
            this.alertRedirect("两次密码不同！", "modifyPassword.jsp");
            return;
        }
        String userType = (String) session.get("userType");
        String result = null;
        if ("systemUser".equals(userType)) {
            int userId = (int) session.get("userId");
            result = systemUserService.modifyPassword(userId, oldPassword, newPassword1);
        } else if ("teacher".equals(userType)) {
            int teacherId = (int) session.get("teacherId");
            result = teacherService.modifyPassword(teacherId, oldPassword, newPassword1);
        } else if ("student".equals(userType)) {
            int studentId = (int) session.get("studentId");
            result = studentService.modifyPassword(studentId, oldPassword, newPassword1);
        }

        //判断结果
        if (result != null && !"".equals(result)) {
            this.alertRedirect(result, "modifyPassword.jsp");
        } else {
            this.alertRedirect("你的密码已更新！", "index.jsp");
        }
    }

    public void showUserInformation() {
        String userType = (String) session.get("userType");
        if ("systemUser".equals(userType)) {
            int userId = (int) session.get("userId");
            SystemUser systemUser = systemUserService.getUser(userId);
            request.setAttribute("systemUser", systemUser);
            this.forward("informationSystemUser.jsp");

        } else if ("teacher".equals(userType)) {
            int teacherId = (int) session.get("teacherId");
            Teacher teacher = teacherService.getTeacher(teacherId);
            request.setAttribute("teacher", teacher);
            this.forward("informationTeacher.jsp");

        } else if ("student".equals(userType)) {
            int studentId = (int) session.get("studentId");
            Student student = studentService.getStudent(studentId);
            request.setAttribute("student", student);
            this.forward("informationStudent.jsp");
        }
    }
}
