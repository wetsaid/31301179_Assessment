<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<c:if test="${sessionScope.userType==null}">
    <% response.sendRedirect("login.jsp");%>
</c:if>

<c:if test="${sessionScope.userType=='teacher'}">
    <% response.sendRedirect("teacher!showManageCenter.action?pageSize=10");%>
</c:if>

<c:if test="${sessionScope.userType=='student'}">
    <% response.sendRedirect("student!showManageCenter.action?pageSize=10");%>
</c:if>
