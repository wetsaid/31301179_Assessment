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
        <div class="graphs">
            <div class="xs">
                <h3>添加课程</h3>
                <div class="tab-content">
                    <div class="tab-pane active" id="horizontal-form">

                        <form action="course!addCourse.action" method="post" name="form" class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">课程类型</label>
                                <div class="col-sm-8">
                                    <select id="types" onchange="getCourseType()" class="form-control1">
                                        <option value="">单击选择</option>
                                        <option value="A">必修课</option>
                                        <option value="B">限选课</option>
                                        <option value="C">公选课</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">课程代码</label>
                                <div class="col-sm-8">
                                    <input name="course.courseCode" id="code" type="text" class="form-control1"
                                           placeholder="请先选择课程类型">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">课程名称</label>
                                <div class="col-sm-8">
                                    <input name="course.courseName" type="text" class="form-control1">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">课程时间</label>
                                <div class="col-sm-8">
                                    <input name="course.courseTime" type="text" class="form-control1">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">课程地点</label>
                                <div class="col-sm-8">
                                    <input name="course.courseLocation" type="text" class="form-control1">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">容量</label>
                                <div class="col-sm-8">
                                    <input name="course.courseCapacity" type="text" value="70" class="form-control1">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">起始周</label>
                                <div class="col-sm-8">
                                    <input name="startWeek" type="text" value="1" class="form-control1">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">结束周</label>
                                <div class="col-sm-8">
                                    <input name="endWeek" type="text" value="17" class="form-control1">
                                </div>
                            </div>
                            <div class="panel-footer">
                                <div class="row">
                                    <div class="col-sm-8 col-sm-offset-2">
                                        <input class="btn-success btn" type="submit" value="添加">
                                        <input class="btn-inverse btn" type="reset" value="重置">
                                    </div>
                                </div>
                            </div>

                            <%--隐藏参数--%>
                            <input type="hidden" value="${sessionScope.teacherId}" name="course.teacherId"/>
                            <input type="hidden" value="A" name="course.courseStatus"/>
                        </form>

                    </div>
                </div>
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
