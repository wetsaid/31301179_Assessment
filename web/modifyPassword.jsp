<%@ page language="java"  pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>修改密码</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

</head>

<body>
<%@include file="top.jsp" %>
<form action="systemUser!modifyPassword.action" method="post">
    原密码：<input type="password" name="oldPassword"/><br/>
    新密码：<input type="password" name="newPassword1"/><br/>
    重复新密码：<input type="password" name="newPassword2"/><br/>
    <input type="submit" value="确认"/>
    <input type="reset" value="清空"/><br/>
</form>
</body>
</html>
