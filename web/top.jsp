<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<h1>31301179_教学质量评估系统</h1>
<div style="text-align: right">

    <c:if test="${sessionScope.userType==null}">
        <a href="registerStudent.jsp">注册</a>
        <a href="loginStudent.jsp">登录</a>
    </c:if>

    <c:if test="${sessionScope.userType=='systemUser'}">
        欢迎${sessionScope.userName}回来！
        <a href="systemUser!showManageCenter.action?pageSize=10">管理中心</a>
        <a href="base!logout.action">注销</a>
    </c:if>

    <c:if test="${sessionScope.userType=='teacher'}">
        欢迎${sessionScope.teacherName}老师回来！
        <a href="teacher!showManageCenter.action?pageSize=10">课程管理</a>
        <a href="base!logout.action">注销</a>
    </c:if>

    <c:if test="${sessionScope.userType=='student'}">
        欢迎${sessionScope.studentName}同学回来！
        <a href="student!showManageCenter.action?pageSize=10">课程管理</a>
        <a href="evaluate.jsp">教学评价</a>
        <a href="base!logout.action">注销</a>
    </c:if>

</div>
<hr>
