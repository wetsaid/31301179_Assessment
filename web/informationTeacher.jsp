<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>教师信息</title>

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
    学位：<br/>
    职位：<br/>
    职称：<br/>
    手机号：<br/>
</div>
<div class="right">
    ${teacher.teacherName}<br/>
    ${teacher.teacherSex}<br/>
    ${teacher.teacherDegree}<br/>
    ${teacher.teacherPosition}<br/>
    ${teacher.professionalTitle}<br/>
    ${teacher.teacherPhoneNumber}<br/>
</div>

</body>
</html>
