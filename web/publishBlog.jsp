<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>发表新文章</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%@include file="top.jsp" %>
    <form action="blog!publish.action" method="post">
    	文章标题：<input  type="text" name="blog.title"/><br/>
    	文章内容：
    			<textarea rows="" cols="" name="blog.context"></textarea>
    	<br/>
    	<input  type="submit" value="发表"/><br/>
    </form>
  </body>
</html>
