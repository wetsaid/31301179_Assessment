package com.sshhw.web;

import java.io.IOException;

import org.hibernate.Query;

import com.sshhw.core.Blog;
import com.sshhw.core.User;
import com.sshhw.service.BlogService;
import com.sshhw.service.SqlService;
import com.sshhw.service.UserService;

public class BlogAction extends BaseAction {

	private int blogId;
	private UserService userService;
	private Blog blog;
	private BlogService blogService;
	private SqlService sqlService;

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

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

	public void publish() throws IOException {

		int userId = (int) session.get("userId");
		User user = new User();
		user.setId(userId);
		blog.setUser(user);
		blogService.save(blog);
		this.response.sendRedirect("user!showManageCenter.action");
	}

	public void delete() throws IOException {
		sqlService.executeDelete("blog", blogId);
		this.response.sendRedirect("user!showManageCenter.action");
	}

	

}
