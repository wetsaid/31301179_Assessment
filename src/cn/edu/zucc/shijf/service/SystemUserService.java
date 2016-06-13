package cn.edu.zucc.shijf.service;

import cn.edu.zucc.shijf.dao.SystemUserDAO;
import cn.edu.zucc.shijf.entity.SystemUser;

import java.util.List;

/**
 * Created by wetsaid on 2016/6/10.
 */
public class SystemUserService {

    private SystemUserDAO systemUserDAO;

    public SystemUserDAO getSystemUserDAO() {
        return systemUserDAO;
    }

    public void setSystemUserDAO(SystemUserDAO systemUserDAO) {
        this.systemUserDAO = systemUserDAO;
    }

    public SystemUser getUser(int userId) {
        return systemUserDAO.get(userId);
    }

    public void addSystemUser(SystemUser systemUser) {
        systemUserDAO.add(systemUser);
    }

    public void updateSystemUser(SystemUser systemUser) {
        systemUserDAO.update(systemUser);
    }

    public void deleteSystemUser(int systemUserId) {
        systemUserDAO.delete(systemUserId);
    }

    public List findByProperty(String propertyName, Object value) {
        return systemUserDAO.findByProperty(propertyName, value);
    }

    public String modifyPassword(int userId, String oldPassword, String newPassword) {
        SystemUser user = systemUserDAO.get(userId);
        if (oldPassword.equals(user.getUserPassword())) {
            user.setUserPassword(newPassword);
            systemUserDAO.update(user);
            return null;
        } else {
            return "原密码错误！";
        }
    }
}
