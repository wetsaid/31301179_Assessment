<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>用户注册</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<%@include file="top.jsp" %>
<form action="systemUser!register.action" method="post">
    用户名：<input type="text" name="systemUser.userAccount"/><br/>
    密码：<input type="text" name="systemUser.userPassword"/><br/>
    姓名：<input type="text" name="systemUser.userName"/><br/>
    <input type="submit" value="注册"/><br/>
</form>

</body>
</html>
