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
    <!-- Navigation -->
    <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">选课系统</a>
        </div>
        <!-- /.navbar-header -->
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle avatar" data-toggle="dropdown"><img src="images/3.png"></a>
                <ul class="dropdown-menu">
                    <li class="dropdown-menu-header text-center">
                        <strong>设置</strong>
                    </li>
                    <li class="m_2"><a href="#" data-toggle="modal" data-target="#myModal"><i class="fa fa-user"></i>
                        个人信息</a></li>
                    <li class="m_2"><a href="modifyPassword.jsp"><i class="fa fa-wrench"></i> 修改密码</a></li>
                    <li class="divider"></li>
                    <li class="m_2"><a href="base!logout.action"><i class="fa fa-lock"></i> 注销</a></li>
                </ul>
            </li>
        </ul>
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <c:if test="${sessionScope.userType=='systemUser'}"></c:if>
                    <c:if test="${sessionScope.userType=='teacher'}">
                        <li>
                            <a href="#">
                                <i class="fa fa-laptop nav_icon"></i>课程管理
                                <span class="fa arrow"></span>
                            </a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="teacher!showManageCenter.action?pageSize=10">查看课程</a>
                                </li>
                                <li>
                                    <a href="courseAdd.jsp">添加课程</a>
                                </li>
                            </ul>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.userType=='student'}">
                        <li>
                            <a href="#">
                                <i class="fa fa-laptop nav_icon"></i>课程管理
                                <span class="fa arrow"></span>
                            </a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="student!showManageCenter.action?pageSize=10">选课</a>
                                </li>
                                <li>
                                    <a href="myCourses.jsp">我的课程</a>
                                </li>
                            </ul>
                        </li>
                    </c:if>
                    <li>
                        <a href="#"><i class="fa fa-indent nav_icon"></i>备用<span
                                class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#">备用</a>
                            </li>
                            <li>
                                <a href="#">备用</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>
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
<c:if test="${sessionScope.userType=='teacher'}">
    <%@include file="informationTeacher.jsp" %>
</c:if>
<c:if test="${sessionScope.userType=='student'}">
    <%@include file="informationStudent.jsp" %>
</c:if>
</body>
</html>
