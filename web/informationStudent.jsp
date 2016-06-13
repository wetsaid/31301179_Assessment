<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>学生信息</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <style type="text/css">
        .left, .right {
            float: left;
        }
    </style>

</head>

<body>
<%@include file="top.jsp" %>

<div class="left">
    姓名：<br/>
    性别：<br/>
    入学日期：<br/>
    行政班：<br/>
    手机号：<br/>
</div>
<div class="right">
    ${student.studentName}<br/>
    ${student.studentSex}<br/>
    ${student.admissionDate}<br/>
    ${student.administrativeClass}<br/>
    ${student.studentPhoneNumber}<br/>
</div>

</body>
</html>
