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

    public void addSystemUser(SystemUser systemUser) {
        System.out.println("------SystemUserService.addSystemUser--------" + systemUser.getUserName());
        systemUserDAO.add(systemUser);
    }

    public void updateSystemUser(SystemUser systemUser) {
        System.out.println("------SystemUserService.updateSystemUser--------" + systemUser.getUserName());
        systemUserDAO.update(systemUser);
    }

    public void deleteSystemUser(SystemUser systemUser) {
        System.out.println("------SystemUserService.deleteSystemUser--------" + systemUser.getUserName());
        systemUserDAO.delete(systemUser.getUserId());
    }

    public List findByProperty(String propertyName, Object value) {
        return systemUserDAO.findByProperty(propertyName, value);
    }
}
