package com.sshhw.web;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import com.sshhw.core.User;
import com.sshhw.service.BlogService;
import com.sshhw.service.SqlService;
import com.sshhw.service.UserService;

public class UserAction extends BaseAction {

    private BlogService blogService;

    private SqlService sqlService;

    private int userId;

    private User user;

    private UserService userService;

    public BlogService getBlogService() {
        return blogService;
    }

    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    public SqlService getSqlService() {
        return sqlService;
    }

    public void setSqlService(SqlService sqlService) {
        this.sqlService = sqlService;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void register() throws IOException {
        user.setScore(100f);
        user.setRegisterTime(new Timestamp(System.currentTimeMillis()));
        userService.save(user);
        this.response.sendRedirect("login.jsp");
    }

    public void login() throws IOException {
        //获得页面上传来的用户名和密码
        String username = user.getUsername();
        String password = user.getPassword();

        //根据用户名获得用户对象集合
        List l = userService.findByUsername(username);

        if (l == null || l.size() < 1) {
            this.alertRedirect("用户名不存在", "login.jsp");
        } else {
            User oldUser = (User) l.get(0);

            if (password.equals(oldUser.getPassword())) {
                session.put("username", username);
                session.put("userId", oldUser.getId());
                this.response.sendRedirect("user!showManageCenter.action");
            } else {
                this.alertRedirect("密码错误", "login.jsp");
            }
        }

    }

    public void showManageCenter() {
        int userId = (int) session.get("userId");

        List l = blogService.getUserBlogsOrderByTime(userId);

        this.request.setAttribute("l", l);

        this.forward("manageCenter.jsp");
    }

    public void showSingleUser() {

        User user = userService.findById(userId);

        this.request.setAttribute("userx", user);
        this.forward("user.jsp");
    }

    public void showEditUser() {
        int userId = (int) session.get("userId");
        User user = userService.findById(userId);
        this.request.setAttribute("user", user);
        this.forward("editUser.jsp");
    }

    public void edit() throws IOException {

        User oldUser = userService.findById(user.getId());
        oldUser.setAgname(user.getAgname());
        sqlService.updateObject(oldUser);
        this.response.sendRedirect("user!showManageCenter.action");
    }

}
