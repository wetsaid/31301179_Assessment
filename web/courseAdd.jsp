<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>添加课程</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

    <script type="text/javascript">
        function getCourseType() {
            var value = document.getElementById("types").value
            document.getElementById("code").value = value
        }
    </script>

</head>

<body>
<%@include file="top.jsp" %>
<form action="course!addCourse.action" method="post" name="form">
    课程类型：
    <select id="types" onchange="getCourseType()">
        <option value="">请选择</option>
        <option value="A">必修课</option>
        <option value="B">限选课</option>
        <option value="C">公选课</option>
    </select><br/>
    课程代码：<input id="code" type="text" value="请先选择课程类型" name="course.courseCode"/><br/>
    课程名称：<input type="text" name="course.courseName"/><br/>
    课程时间：<input type="text" name="course.courseTime"/><br/>
    课程地点：<input type="text" name="course.courseLocation"/><br/>
    容量：<input type="text" value="70" name="course.courseCapacity"/><br/>
    起始结束周：<input type="text" value="1" name="startWeek"/>
    -<input type="text" value="17" name="endWeek"/><br/>
    <input type="submit" value="添加"/><br/>

    <%--隐藏参数--%>
    <input type="hidden" value="${sessionScope.teacherId}" name="course.teacherId"/>
    <input type="hidden" value="A" name="course.courseStatus"/>
</form>
</body>
</html>
