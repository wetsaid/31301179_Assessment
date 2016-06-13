<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>用户注册</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

</head>

<body>

<%@include file="top.jsp" %>
<a href="registerSystemUser.jsp">管理员</a>|
<a href="registerTeacher.jsp">教师</a>|
<a href="registerStudent.jsp">学生</a>
<form action="student!register.action" method="post">
    学生账号：<input type="text" name="student.studentAccount"/><br/>
    学生密码：<input type="password" name="student.studentPassword"/><br/>
    学生昵称：<input type="text" name="student.studentName"/><br/>
    <input type="submit" value="注册"/><br/>
</form>

</body>
</html>
