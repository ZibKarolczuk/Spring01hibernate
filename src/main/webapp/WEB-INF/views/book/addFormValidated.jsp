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
            <form:errors path="title"></form:errors>
        </div>
        <div>
            <form:label path="authors">Authors</form:label>
            <form:select path="authors" items="${authors}"
                         itemValue="id" itemLabel="fullName"
            multiple="true"></form:select>
            <form:errors path="authors"></form:errors>
        </div>
        <div>
            <form:label path="publisher">Publisher</form:label>
            <form:select path="publisher.id" items="${publishers}"
                         itemLabel="name" itemValue="id"></form:select>
            <form:errors path="publisher"></form:errors>
        </div>
        <div>
            <form:label path="rating">Rating</form:label>
            <form:input path="rating" type="number"></form:input>
            <form:errors path="rating"></form:errors>
        </div>
        <div>
            <form:label path="description">Description</form:label>
            <form:textarea path="description"></form:textarea>
            <form:errors path="description"></form:errors>
        </div>
        <div>
            <form:label path="pages">Number of pages</form:label>
            <form:input path="pages" type="number"></form:input>
            <form:errors path="pages"></form:errors>
        </div>
        <div>
            <div style="border: solid 1px red;">
                <form:errors path="*"></form:errors>
            </div>
            <input type="submit">
        </div>
    </form:form>
</body>
</html>
