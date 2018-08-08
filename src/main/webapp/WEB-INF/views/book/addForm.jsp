<%--
  Created by IntelliJ IDEA.
  User: Edu
  Date: 07.08.2018
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
isELIgnored="false" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Add book form</title>
</head>
<body>
    <form:form method="post" modelAttribute="book">
        <div>
            <form:label path="title">Title</form:label>
            <form:input path="title"></form:input>
        </div>
        <div>
            <form:label path="authors">Authors</form:label>
            <form:select path="authors" items="${authors}"
                         itemValue="id" itemLabel="fullName"
            multiple="true"></form:select>
        </div>
        <div>
            <form:label path="publisher">Publisher</form:label>
            <form:select path="publisher.id" items="${publishers}"
                         itemLabel="name" itemValue="id"></form:select>
        </div>
        <div>
            <form:label path="rating">Rating</form:label>
            <form:input path="rating" type="number"></form:input>
        </div>
        <div>
            <form:label path="description">Description</form:label>
            <form:textarea path="description"></form:textarea>
        </div>
        <div>
            <input type="submit">
        </div>
    </form:form>
</body>
</html>
