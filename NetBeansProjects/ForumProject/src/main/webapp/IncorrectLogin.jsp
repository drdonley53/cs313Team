<%-- 
    Document   : IncorrectLogin
    Created on : Mar 6, 2015, 1:38:27 PM
    Author     : daviddonley
--%>

<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sorry, You have entered a Wrong Username or Password.  Please click the link and try again</h1>
        <form action="Login.jsp">
            <input type="submit" value="Login page" />
        </form>
    </body>
</html>
