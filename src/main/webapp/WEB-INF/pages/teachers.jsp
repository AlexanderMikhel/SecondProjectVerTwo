<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Teachers Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="http://localhost:8888/school-web/school.jsp">Back to start page</a>

<br/>
<br/>

<h1>Teachers List</h1>

<c:if test="${!empty teachers}">
<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">firstname</th>
        <th width="120">lastname</th>
        <th width="120">Subject</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${teachers}" var="teacher">
        <tr>
            <td>${teacher.id}</td>
            <td>${teacher.firstName}</td>
            <td>${teacher.lastName}</td>
            <td>${teacher.subject.name}</td>
            <td><a href="<c:url value='/teacherController/remove/${teacher.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</c:if>

