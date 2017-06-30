<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="string" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 29.06.2017
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <spring:form modelAttribute="userFromServer" method="post" action="/school/users/check">
            <string:input path="name"/>
            <string:input path="password"/>
            <spring:button>check user</spring:button>
        </spring:form>
</body>
</html>
