package cn.edu.zucc.shijf.action;

import cn.edu.zucc.shijf.entity.SystemUser;
import cn.edu.zucc.shijf.service.SystemUserService;

import java.io.IOException;
import java.util.List;

/**
 * Created by wetsaid on 2016/6/10.
 */
public class SystemUserAction extends BaseAction {

    private static final String STSTEMUSER = "SystemUser";
    private static final String ACCOUNT = "userAccount";
    private SystemUser systemUser;
    private SystemUserService systemUserService;

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

    public String addSystemUser() {
        System.out.println("-------SystemUserAction.addSystemUser--------" + systemUser.getUserName());
        systemUserService.addSystemUser(systemUser);
        return "success";
    }

    public String updateSystemUser() {
        System.out.println("-------SystemUserAction.updateSystemUser--------" + systemUser.getUserName());
        systemUserService.updateSystemUser(systemUser);
        return "success";
    }

    public String deleteSystemUser() {
        System.out.println("-------SystemUserAction.deleteSystemUser--------" + systemUser.getUserName());
        systemUserService.deleteSystemUser(systemUser);
        return "success";
    }

    public void login() throws IOException {
        List list = systemUserService.findByProperty(STSTEMUSER, ACCOUNT, systemUser.getUserAccount());
        if (list == null || list.size() < 1) {
            this.alertRedirect("管理员账号不存在", "index.jsp");
        } else {
            SystemUser oldSystemUser = (SystemUser) list.get(0);
            if (systemUser.getUserPassword().equals(oldSystemUser.getUserPassword())) {
                this.response.sendRedirect("top.jsp");
            } else {
                this.alertRedirect("错误！", "fail.jsp");
            }
        }
    }

    public void register() throws IOException {
        systemUserService.addSystemUser(systemUser);
        this.response.sendRedirect("index.jsp");
    }
}
