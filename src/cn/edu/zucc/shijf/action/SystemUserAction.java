package cn.edu.zucc.shijf.action;

import cn.edu.zucc.shijf.entity.SystemUser;
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
    private String userType;
    private String account;
    private String password;
    private String name;
    private String oldPassword;
    private String newPassword1;
    private String newPassword2;
    private SystemUser systemUser;
    private SystemUserService systemUserService;
    private TeacherService teacherService;
    private StudentService studentService;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
        if (userType == null) {
            this.alertRedirect("请选择账户类型", "login.jsp");
            return;
        }
        if ("teacher".equals(userType) || "student".equals(userType)) {
            session.put("account", account);
            session.put("password", password);
            this.response.sendRedirect(userType + "!login.action");
            return;
        }

        List list = systemUserService.findByProperty(ACCOUNT, account);
        if (list == null || list.size() < 1) {
            this.alertRedirect("管理员账号不存在", "login.jsp");
        } else {
            SystemUser oldSystemUser = (SystemUser) list.get(0);
            if (password.equals(oldSystemUser.getUserPassword())) {
                session.put("userId", oldSystemUser.getUserId());
                session.put("userName", oldSystemUser.getUserName());
                session.put("userType", "systemUser");
                this.response.sendRedirect("index.jsp");
            } else {
                this.alertRedirect("密码错误！", "login.jsp");
            }
        }
    }

    public void register() throws IOException {
        if ("".equals(account) || account == null) {
            this.alertRedirect("帐号不得为空！", "register.jsp");
            return;
        }
        if ("".equals(password) || password == null) {
            this.alertRedirect("密码不得为空！", "register.jsp");
            return;
        }
        if ("teacher".equals(userType) || "student".equals(userType)) {
            session.put("account", account);
            session.put("password", password);
            session.put("name", name);
            this.response.sendRedirect(userType + "!register.action");
            return;
        }

        List list = systemUserService.findByProperty(ACCOUNT, account);
        if (list.size() >= 1) {
            this.alertRedirect("管理员账号已存在！", "register.jsp");
            return;
        }
        systemUser = new SystemUser();
        systemUser.setUserAccount(account);
        systemUser.setUserPassword(password);
        systemUser.setUserName(name);
        systemUserService.addSystemUser(systemUser);
        this.alertRedirect("注册成功！", "register.jsp");
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
            this.alertBack("你的密码已更新！");
        }
    }
}
