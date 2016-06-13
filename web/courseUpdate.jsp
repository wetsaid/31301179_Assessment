<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>修改课程</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

    <script type="text/javascript">
        //为下拉框选默认值
        function check() {
            document.getElementById("types").value = "${type}"
        }
        function getCourseType() {
            var value = document.getElementById("types").value
            document.getElementById("code").value = value
        }
    </script>

</head>

<body onload="check()">
<%@include file="top.jsp" %>
<form action="course!updateCourse.action" method="post" name="form">
    课程类型：
    <select id="types" disabled onchange="getCourseType()">
        <option value="">请选择</option>
        <option value="A">必修课</option>
        <option value="B">限选课</option>
        <option value="C">公选课</option>
    </select><br/>
    课程代码：<input id="code" type="text" readonly value="${course.courseCode}" name="course.courseCode"/><br/>
    课程名称：<input type="text" value="${course.courseName}" name="course.courseName"/><br/>
    课程时间：<input type="text" value="${course.courseTime}" name="course.courseTime"/><br/>
    课程地点：<input type="text" value="${course.courseLocation}" name="course.courseLocation"/><br/>
    容量：<input type="text" value="${course.courseCapacity}" name="course.courseCapacity"/><br/>
    起始结束周：<input type="text" readonly value="${start}" name="startWeek"/>
    -<input type="text" readonly value="${end}" name="endWeek"/><br/>
    <input type="submit" value="修改"/><br/>

    <%--隐藏参数--%>
    <input type="hidden" value="${course.courseId}" name="course.courseId"/>
    <input type="hidden" value="${sessionScope.teacherId}" name="course.teacherId"/>
    <input type="hidden" value="A" name="course.courseStatus"/>
</form>
</body>
</html>
