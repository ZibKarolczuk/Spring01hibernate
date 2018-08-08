<%--
  Created by IntelliJ IDEA.
  User: Edu
  Date: 07.08.2018
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add Person taglib</title>
</head>
<body>
    <form:form method="post" modelAttribute="person">
        <div>
            <form:input path="personDetails.firstName"></form:input>
            <form:select path="personDetails.country" items="countries"></form:select>
        </div>

        <div>
            <form:label path="login">Login</form:label>
            <form:input path="login"></form:input>
        </div>
        <div>
            <form:label path="password">Password</form:label>
            <form:password path="password"></form:password>
        </div>
        <div>
            <form:label path="email">Email</form:label>
            <form:input type="email" path="email"></form:input>
        </div>

        <div><input type="submit"/> </div>
    </form:form>
</body>
</html>
