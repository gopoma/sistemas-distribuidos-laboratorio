<%-- 
    Document   : test
    Created on : Jun 4, 2024, 4:20:45 AM
    Author     : anthony
--%>
<%@ page isErrorPage="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <%-- Recibe el vector de mensajes --%>
        <% String[] messages = (String[]) request.getAttribute("messages"); %>

        <%-- Muestra los mensajes --%>
        <ul>
            <% for (String message : messages) { %>
                <li><%= message %></li>
            <% } %>
        </ul>

        <%-- Muestra la información de la excepción si corresponde --%>
        <% if(exception != null) { %>
            <h2>Exception Information</h2>
            <p><%= exception.getMessage() %></p>
            <pre><%= exception.getStackTrace() %></pre>
        <% } %>
    </body>
</html>
