<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>教师个人管理中心页面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <script type="text/javascript">
        var deleteObj = function(id)
        {
            b = confirm("确认要删除此课程吗?");
            if(b)
            {
                window.location="course!deleteCourse.action?courseId=" + id;
            }
        }
    </script>

</head>

<body>

    <%@include file="top.jsp" %>
    <a target="_blank"  href="user!showSingleUser.action?userId=${sessionScope.userId}">预览个人信息</a>
    <a href="user!showEditUser.action">修改资料</a>
    <a href="">修改密码</a>

    <hr>
    我的课程 第5页/共10页
    <a href="publishBlog.jsp">添加新课程</a>

    <br>
    <br>

    <table border="1">
            <tr>
                <td>课程名称</td>
                <td>课程代码</td>
                <td>上课时间</td>
                <td>上课地点</td>
                <td>操作</td>
            </tr>

        <c:forEach items="${courses}"  var="course">
            <tr>
                <td><a href="">${course.courseName}</a></td>
                <td>${course.courseCode}</td>
                <td>${course.courseTime}</td>
                <td>${course.courseLocation}</td>
                <td>
                    <a href="">修改</a>
                    <a onclick="deleteObj(${course.courseId});" href="#">删除</a>
                </td>
            </tr>
        </c:forEach>

    </table>

    <br>

    分页：
    <a href="">首页</a>
    <a href="">上一页</a>
    <a href="">下一页</a>
    <a href="">末页</a>

</body>

</html>
