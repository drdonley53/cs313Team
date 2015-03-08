<%-- 
    Document   : NewPost
    Created on : Mar 6, 2015, 1:40:39 PM
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
        <h1>Welcome to the Forum ${username}</h1>
        <h3>What is on your mind?</h3>
        <form action ="ListPosts" method="POST">
        <textarea name="newPost" rows="20" cols="50"></textarea><br />
        <input type="submit" value="post" />
        <input type="submit" value="View Posts" />
        </form>
        <h3>Would you like to log out?</h3>
        <form action="Logout">
            <input type="submit" value="Logout" />
        </form>
    </body>
</html>
