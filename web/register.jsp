<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>用户注册</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel='stylesheet' type='text/css'/>
    <!-- Custom CSS -->
    <link href="css/style.css" rel='stylesheet' type='text/css'/>
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- jQuery -->
    <script src="js/jquery.min.js"></script>
    <!----webfonts--->
    <link href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
    <!---//webfonts--->
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</head>

<body id="login">

<div class="login-logo">
    <h1 style="color: #2d2d2d">教学质量评估系统</h1>
</div>
<h2 class="form-heading">登录</h2>

<form action="systemUser!register.action" method="post" class="form-signin app-cam">
    <%--<div class="radio-inline"><label><input name="userType" type="radio" value="systemUser"> 管理员</label></div>--%>
    <div class="radio-inline"><label><input name="userType" type="radio" value="teacher"> 教师</label></div>
    <div class="radio-inline"><label><input name="userType" type="radio" value="student" checked> 学生</label></div>
    <input name="account" type="text" class="form-control1" placeholder="账号" autofocus="">
    <input name="password" type="password" class="form-control1" placeholder="密码" autofocus="">
    <input name="name" type="text" class="form-control1" placeholder="姓名" autofocus="">
    <button class="btn btn-lg btn-success1 btn-block" type="submit">注册</button>
    <div class="registration">
        已有账号？
        <a href="login.jsp">
            登录
        </a>
    </div>
</form>

</body>
</html>
