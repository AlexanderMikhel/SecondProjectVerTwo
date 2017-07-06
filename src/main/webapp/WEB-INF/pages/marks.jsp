<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Marks Page</title>

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

<h1>Marks List</h1>

<c:if test="${!empty marks}">
<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">value</th>
        <th width="120">data</th>
        <th width="120">subject</th>
        <th width="120">teacher</th>
        <th width="120">student</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${marks}" var="mark">
        <tr>
            <td><a href="markData/${mark.id}" target="_blank">${mark.id}</a></td>
            <td>${mark.value}</td>
            <td>${mark.date}</td>
            <td>${mark.subject.name}</td>
            <td>${mark.teacher.firstName}</td>
            <td>${mark.student.firstName}</td>
            <td><a href="<c:url value='/markController/edit/${mark.id}'/>">Edit</a></td>
            <td><a href="<c:url value='/markController/remove/${mark.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</c:if>


<h1>Add Mark</h1>

<c:url var="addAction" value="/markController/marks/add"/>

<form:form action="${addAction}" commandName="mark">
    <table>
        <c:if test="${!empty mark.valueString()}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="value">
                    <spring:message text="value"/>
                </form:label>
            </td>
            <td>
                <form:input path="value"/>

            </td>
        </tr>
        <tr>
            <td>
                <form:label path="teacher">
                    <spring:message text="teacher.id"/>
                </form:label>
            </td>
            <td>
                <form:input path="teacher.id"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="subject">
                    <spring:message text="subject.id"/>
                </form:label>
            </td>
            <td>
                <form:input path="subject.id"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="student">
                    <spring:message text="student.id"/>
                </form:label>
            </td>
            <td>
                <form:input path="student.id"/>
            </td>
        </tr>

    <tr>
        <td colspan="2">
            <c:if test="${!empty mark.valueString()}">
                <input type="submit"
                       value="<spring:message text="Edit Mark"/>"/>
            </c:if>
            <c:if test="${empty mark.valueString()}">
                <input type="submit"
                       value="<spring:message text="Add Mark"/>"/>
            </c:if>
        </td>
        </tr>
    </table>
</form:form>
</body>
</html>