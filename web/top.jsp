<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<h1>31301179_教学质量评估系统</h1>
<div style="text-align: right;">

	<c:if test="${sessionScope.userType==null}">
		<a href="register.jsp">注册</a>
		<a href="loginStudent.jsp">登录</a>
	</c:if>
	
	<c:if test="${sessionScope.userType=='systemUser'}">
		欢迎${sessionScope.systemUserName}回来！
		<a href="user!showManageCenter.action">管理中心</a>
		<a href="#">注销</a>
	</c:if>

    <c:if test="${sessionScope.userType=='teacher'}">
        欢迎${sessionScope.teacherName}回来！
        <a href="teacher!showManageCenter.action?pageSize=15&page=1">管理中心</a>
        <a href="#">注销</a>
    </c:if>

    <c:if test="${sessionScope.userType=='student'}">
        欢迎${sessionScope.studentName}回来！
        <a href="user!showManageCenter.action">管理中心</a>
        <a href="#">注销</a>
    </c:if>
	
</div>
<hr>
