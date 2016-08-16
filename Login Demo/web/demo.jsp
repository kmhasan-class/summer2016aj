<%-- 
    Document   : demo
    Created on : Jul 25, 2016, 9:19:18 AM
    Author     : kmhasan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%!
            public class Calculator {
                public int add(int x, int y) {
                    int z = x + y;
                    return z;
                }
            }
        %>
        <%
            int i = 12;
            int j = 22;
            Calculator c = new Calculator();
            int k = c.add(i, j);
        %>
        <h3>Value is <%=k %></h3>
    </body>
</html>
