<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liunian
  Date: 2017/6/27
  Time: 下午7:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <base target="main">
    <title>客户管理系统</title>
  </head>
  <body style="text-align: center">
  <h1 >客户管理系统</h1>
  <a href="<c:url value="/add.jsp"/>">添加客户</a>
  <a href="">查询客户</a>
  <a href="query.jsp">高级搜索</a>
  </body>
</html>
