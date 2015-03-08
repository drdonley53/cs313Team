<%-- 
    Document   : AllPosts
    Created on : Mar 7, 2015, 1:25:26 PM
    Author     : daviddonley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Here are all of the Posts From all of the Users</h1>
        <h3>Add another entry?</h3>
        <form action="NewPost.jsp">
            <input type="submit" value="Yes" />
        </form>
        <h3>Logout?</h3>
        <form action="Logout">
            <input type="submit" value="Logout" />
        </form>
        <br />
        <c:forEach var="entry" items="${entry}">
            Author: ${entry.user}<br />
            Post Date: ${entry.time}<br />
            Entry <br /><br />
            <textarea>${entry.entry}</textarea><br /><br />
        </c:forEach>
    </body>
</html>
