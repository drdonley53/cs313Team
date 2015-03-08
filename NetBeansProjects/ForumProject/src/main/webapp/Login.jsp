<%-- 
    Document   : Login
    Created on : Mar 5, 2015, 9:36:13 AM
    Author     : daviddonley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello and welcome to the forum</h1>
        <h2>Please login with you username and password.</h2>
        <form action="ValidateLogin" method="POST">
        Username: <input type="text" name="username" />
        Password: <input type="text" name="password" />
        <input type="submit" value="Login" />
        </form>
    </body>
</html>
