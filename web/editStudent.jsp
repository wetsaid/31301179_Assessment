<%@ page language="java" pageEncoding="UTF-8" %>
<%--<%--%>
<%--String path = request.getContextPath();--%>
<%--String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";--%>
<%--%>--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <%--<base href="<%=basePath%>">--%>

      <title>编辑学生信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
      <meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  	 <%@include file="top.jsp" %>
     <form action="student!updateInformation.action" method="post">

         姓名：<input type="text" name="student.studentName" value="${student.studentName}"/><br/>
         性别：
         <input type="radio" name="student.studentSex" value="男"
                <c:if test="${student.studentSex=='男'}">checked</c:if>/>男&nbsp;
         <input type="radio" name="student.studentSex" value="女"
                <c:if test="${student.studentSex=='女'}">checked</c:if>/>女<br/>
         入学日期：<input type="text" name="student.admissionDate" value="${student.admissionDate}"/><br/>
         行政班：<input type="text" name="student.administrativeClass" value="${student.administrativeClass}"/><br/>
         手机号：<input type="text" name="student.studentPhoneNumber" value="${student.studentPhoneNumber}"/><br/>
    	<input  type="submit" value="修改"/><br/>

         <input type="hidden" name="student.studentId" value="${student.studentId}"/>
         <input type="hidden" name="student.studentAccount" value="${student.studentAccount}"/>
         <input type="hidden" name="student.studentPassword" value="${student.studentPassword}"/>
         <input type="hidden" name="student.studentStatus" value="${student.studentStatus}"/>
    </form>
  </body>
</html>
