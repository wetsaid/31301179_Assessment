<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<h1>SSH综合作业--用户，博客相关功能</h1>
<div style="text-align: right;">
	<c:if test="${sessionScope.username==null}">
	<a href="register.jsp">注册</a>
	<a href="login.jsp">登录</a>
	</c:if>
	
	<c:if test="${sessionScope.username!=null}">
	欢饮${sessionScope.username}回来！
	<a href="user!showManageCenter.action">管理中心</a>
	<a href="#">注销</a>
	</c:if>
	
</div>
<hr>
