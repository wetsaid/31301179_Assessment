<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>学生个人管理中心页面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <script type="text/javascript">
        var deleteObj = function (id) {
            if (confirm("确认要退选此课程吗?")) {
                window.location = "chooseCourse!deleteChooseCourse.action?courseId=" + id;
            }
        }
    </script>

</head>

<body>

<%@include file="top.jsp" %>
<a target="_blank" href="user!showSingleUser.action?userId=${sessionScope.userId}">预览个人信息</a>
<a href="user!showEditUser.action">修改资料</a>
<a href="">修改密码</a>
<hr>

<form action="chooseCourse!addChooseCourse.action" method="post">
    <fieldset>
        <legend style="text-align: center">可选课程</legend>

        <table border="1" width="100%">
            <tr>
                <td>选课</td>
                <td>课程名称</td>
                <td>课程代码</td>
                <td>教师名称</td>
                <td>上课时间</td>
                <td>上课地点</td>
                <td>容量</td>
                <td>起始结束周</td>
            </tr>

            <c:forEach items="${courses}" var="course">
                <tr>
                    <td><input type="checkbox" value="${course.courseId}" name="ids"></td>
                    <td>${course.courseName}</td>
                    <td>${course.courseCode}</td>
                    <td>${course.teacherName}</td>
                    <td>${course.courseTime}</td>
                    <td>${course.courseLocation}</td>
                    <td>${course.courseCapacity}</td>
                    <td>${course.startEndWeek}</td>
                </tr>
            </c:forEach>

        </table>

        第${coursesCurrentPage}页/共${coursesTotalPage}页，共${coursesAllRow}条记录
        <a href="course!goToPage.action?p=first">首页</a>
        <a href="course!goToPage.action?p=previous">上一页</a>
        <a href="course!goToPage.action?p=next">下一页</a>
        <a href="course!goToPage.action?p=last">末页</a>
    </fieldset>
    <input type="submit" value="提交">
</form>

<fieldset>
    <legend style="text-align: center">学生已选课程信息列表 共${myCoursesAllRow}条记录！</legend>

    <table border="1" width="100%">
        <tr>
            <td>课程名称</td>
            <td>课程代码</td>
            <td>教师名称</td>
            <td>上课时间</td>
            <td>上课地点</td>
            <td>容量</td>
            <td>起始结束周</td>
            <td>退选</td>
        </tr>

        <c:forEach items="${myCourses}" var="course">
            <tr>
                <td><a href="">${course.courseName}</a></td>
                <td>${course.courseCode}</td>
                <td>${course.teacherName}</td>
                <td>${course.courseTime}</td>
                <td>${course.courseLocation}</td>
                <td>${course.courseCapacity}</td>
                <td>${course.startEndWeek}</td>
                <td>
                    <a onclick="deleteObj(${course.courseId});" href="#">退选</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</fieldset>

</body>
</html>
