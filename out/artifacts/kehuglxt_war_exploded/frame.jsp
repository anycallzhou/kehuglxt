<%--
  Created by IntelliJ IDEA.
  User: liunian
  Date: 2017/6/28
  Time: 下午4:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<frameset rows="20%,*">
    <frame src = "<c:url value="/top.jsp"/>" name = "top"/>
    <frame src = "<c:url value="/welcome.jsp"/>" name = "main"/>

</frameset>
</body>
</html>
