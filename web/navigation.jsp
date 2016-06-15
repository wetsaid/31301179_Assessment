<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

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
            <a href="#" class="dropdown-toggle avatar" data-toggle="dropdown"><img src="images/6.png"></a>
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

<c:if test="${sessionScope.userType=='teacher'}">
    <%@include file="informationTeacher.jsp" %>
</c:if>
<c:if test="${sessionScope.userType=='student'}">
    <%@include file="informationStudent.jsp" %>
</c:if>
