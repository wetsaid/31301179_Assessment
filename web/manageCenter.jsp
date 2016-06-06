<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>用户个人管理中心页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script type="text/javascript">
		
	var deleteObj = function(id)
	{
		b =  confirm("确认要删除此条记录吗?");
		if(b)
		{
			window.location="blog!delete.action?blogId="+id;
		}
		
		//blog!delete.action?blogId=${blog.id}
	}
		
	</script>

  </head>
  
  <body>
     <%@include file="top.jsp" %>
     <a target="_blank"  href="user!showSingleUser.action?userId=${sessionScope.userId}">预览个人信息</a>
     <a href="user!showEditUser.action">修改资料</a>
     <a href="">修改密码</a>
     
     <hr>
     博文目录 当前页：第 5 页 总页数 10 页
     <a href="publishBlog.jsp">发表新文章</a>
     
     <br>
     <br>
     
     <table border="1">
     		<tr>
     			<td>文章标题</td>
     			<td>发表时间</td>
     			<td>用户操作</td>
     		</tr>
     
     <c:forEach items="${l}" var="blog">
     		<tr>
     			<td><a href="">${blog.title}</a></td>
     			<td>${blog.publishTime}</td>
     			<td>
     				<a href="">修改</a>
     				<a onclick="deleteObj(${blog.id});" href="#">删除</a>
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
