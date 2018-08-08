<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Edu
  Date: 07.08.2018
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
isELIgnored="false" %>
<html>
<head>
    <title>Book list</title>
</head>
<body>
<ul>
    <c:forEach var="book" items="${books}">
        <li>${book.title} <a href="<c:url value='/book/edit/${book.id}'/>">Edit</a> </li>
    </c:forEach>
</ul>
</body>
</html>
