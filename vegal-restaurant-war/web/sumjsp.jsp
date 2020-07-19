<%-- 
    Document   : sumjsp
    Created on : Jul 19, 2020, 9:20:37 PM
    Author     : makut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="TestServlet" method="POST">
            <input type="text" name="num1">
            <input type="text" name="num2">
            <input type="submit" value="sum">
        </form>
    </body>
</html>
