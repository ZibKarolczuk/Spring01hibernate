<%--
  Created by IntelliJ IDEA.
  User: Edu
  Date: 07.08.2018
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add person</title>
</head>
<body>
    <form method="post">
        <div>
            <label for="login">Login</label>
            <input type="text" name="login" id="login">
        </div>
        <div>
            <label for="password">Password</label>
            <input type="password" name="password" id="password">
        </div>
        <div>
            <label for="email">Email</label>
            <input type="email" name="email" id="email">
        </div>

        <div><input type="submit"> </div>
    </form>
</body>
</html>
