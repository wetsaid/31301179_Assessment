<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>选课系统</title>
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
    <!-- Graph CSS -->
    <link href="css/lines.css" rel='stylesheet' type='text/css'/>
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- jQuery -->
    <script src="js/jquery.min.js"></script>
    <!----webfonts--->
    <link href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
    <!---//webfonts--->
    <!-- Nav CSS -->
    <link href="css/custom.css" rel="stylesheet">
    <!-- Metis Menu Plugin JavaScript -->
    <script src="js/metisMenu.min.js"></script>
    <script src="js/custom.js"></script>
    <!-- Graph JavaScript -->
    <script src="js/d3.v3.js"></script>
    <script src="js/rickshaw.js"></script>

    <script src="js/_my.js"></script>
</head>
<body>
<div id="wrapper">
    <%@include file="navigation.jsp" %>
    <div id="page-wrapper">
        <div class="col-md-12 graphs">
            <div class="xs">
                <h3>可选课程</h3>

                <form action="chooseCourse!addChooseCourse.action" method="post">
                    <div class="bs-example4" data-example-id="contextual-table">
                        <table class="table">
                            <thead style="background-color: lightcyan">
                            <tr>
                                <th>#</th>
                                <td>选课</td>
                                <td>课程名称</td>
                                <td>课程代码</td>
                                <td>教师名称</td>
                                <td>上课时间</td>
                                <td>上课地点</td>
                                <td>容量</td>
                                <td>起始结束周</td>
                            </tr>
                            </thead>
                            <tbody>
                            <% int i = 0; %>
                            <c:forEach items="${courses}" var="course">
                                <% i += 1; %>
                                <tr class="<%=(i%2==0)?"active":""%>">
                                    <th scope="row"><%=i%>
                                    </th>
                                    <td><input type="checkbox" value="${course.courseId}" name="ids" class="checkbox">
                                    </td>
                                    <td>${course.courseName}</td>
                                    <td>${course.courseCode}</td>
                                    <td>${course.teacherName}</td>
                                    <td>${course.courseTime}</td>
                                    <td>${course.courseLocation}</td>
                                    <td>${course.courseCapacity}</td>
                                    <td>${course.startEndWeek}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <ul class="pagination pagination-lg">
                        <li><a href="course!goToPage.action?p=first" aria-label="Previous"><span
                                aria-hidden="true">«</span></a>
                        </li>
                        <li><a href="course!goToPage.action?p=previous"><i class="fa fa-angle-left"></i></a></li>
                        <li><a href="course!goToPage.action?p=next"><i class="fa fa-angle-right"></i></a></li>
                        <li><a href="course!goToPage.action?p=last" aria-label="Next"><span aria-hidden="true">»</span></a>
                        </li>
                    </ul>
                    <div class="panel-footer">
                        <div class="row">
                            <div align="center">
                                <input type="submit" value="提交" class="btn-success btn"></div>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
