<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>用户登录</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
    <script type="application/x-javascript">
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);
        function hideURLbar() {
            window.scrollTo(0, 1);
        } </script>
    <link href="css/bootstrap.min.css" rel='stylesheet' type='text/css'/>
    <link href="css/style.css" rel='stylesheet' type='text/css'/>
    <link href="css/font-awesome.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <link href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
    <script src="js/bootstrap.min.js"></script>
</head>

<body id="login">

<div class="login-logo">
    <h1 style="color: #2d2d2d">教学质量评估系统</h1>
</div>
<h2 class="form-heading">登录</h2>
<div class="app-cam">
    <form action="systemUser!login.action" method="post">
        <%--<div class="radio-inline"><label><input name="userType" type="radio" value="systemUser"> 管理员</label></div>--%>
        <div class="radio-inline"><label><input name="userType" type="radio" value="teacher"> 教师</label></div>
        <div class="radio-inline"><label><input name="userType" type="radio" value="student"> 学生</label></div>
        <input name="account" type="text" class="text" value="请填写账号" onfocus="this.value = '';"
               onblur="if (this.value == '') {this.value = '请填写账号';}">
        <input name="password" type="password" value="请填写密码" onfocus="this.value = '';"
               onblur="if (this.value == '') {this.value = '请填写密码';}">
        <div class="submit"><input type="submit" value="登录"></div>
        <ul class="new">
            <li class="new_left"><p><a href="#">忘记密码？</a></p></li>
            <li class="new_right"><p class="sign">没有账号？<a href="register.jsp">注册</a></p></li>
            <div class="clearfix"></div>
        </ul>
    </form>
</div>
</body>
</html>
