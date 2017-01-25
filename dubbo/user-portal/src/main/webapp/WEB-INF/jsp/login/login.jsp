<%--
  Created by IntelliJ IDEA.
  User: leihang
  Date: 2017/1/17
  Time: 10:00
  登陆测试
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Portal</title>
</head>
<body>
    <form action="${basePath}/security/doLogin" method="post" >
        <input type="text" name="userId">
        <input type="text" name="password">
        <input type="submit">
    </form>
</body>
</html>
