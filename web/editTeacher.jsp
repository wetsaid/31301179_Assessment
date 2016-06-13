<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>编辑教师信息</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

</head>

<body>
<%@include file="top.jsp" %>
<form action="teacher!updateInformation.action" method="post">

    姓名：<input type="text" name="teacher.teacherName" value="${teacher.teacherName}"/><br/>
    性别：
    <input type="radio" name="teacher.teacherSex" value="男" <c:if test="${teacher.teacherSex=='男'}">checked</c:if>/>男&nbsp;
    <input type="radio" name="teacher.teacherSex" value="女"
           <c:if test="${teacher.teacherSex=='女'}">checked</c:if>/>女<br/>
    学位：<input type="text" name="teacher.teacherDegree" value="${teacher.teacherDegree}"/><br/>
    职位：<input type="text" name="teacher.teacherPosition" value="${teacher.teacherPosition}"/><br/>
    职称：<input type="text" name="teacher.professionalTitle" value="${teacher.professionalTitle}"/><br/>
    手机号：<input type="text" name="teacher.teacherPhoneNumber" value="${teacher.teacherPhoneNumber}"/><br/>
    <input type="submit" value="修改"/><br/>

    <input type="hidden" name="teacher.teacherId" value="${teacher.teacherId}"/>
    <input type="hidden" name="teacher.teacherAccount" value="${teacher.teacherAccount}"/>
    <input type="hidden" name="teacher.teacherPassword" value="${teacher.teacherPassword}"/>
    <input type="hidden" name="teacher.teacherStatus" value="${teacher.teacherStatus}"/>
</form>
</body>
</html>
