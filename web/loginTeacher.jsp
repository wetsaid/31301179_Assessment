<%@ page language="java"  pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>用户登录</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

</head>

<body>
<%@include file="top.jsp" %>
<a href="loginSystemUser.jsp">管理员</a>|
<a href="loginTeacher.jsp">教师</a>|
<a href="loginStudent.jsp">学生</a><br/>
<form action="teacher!login.action" method="post">
    教师账号：<input type="text" name="teacher.teacherAccount"/><br/>
    教师密码：<input type="text" name="teacher.teacherPassword"/><br/>
    <input type="submit" value="登录"/><br/>
</form>
</body>
</html>
