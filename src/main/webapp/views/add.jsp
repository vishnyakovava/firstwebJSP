<%--
  Created by IntelliJ IDEA.
  User: mp
  Date: 29.11.2017
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>

<html>
<head>
    <title>Add data</title>
</head>

<body>
    <div>
        <div>
            <div>
                <h1>Add string to database</h1>
            </div>
            <table border="0">
                <form action = "addservlet" method="post">
                    <tr>
                        <td>
                            Input string:
                        </td>
                        <td>
                            <input type="text" name="input" size="50"/>
                        </td>
                    </tr>
                    <tr>
                        <td><button type="submit">Save</button></td>
                    </tr>
                </form>
            </table>

        </div>
    </div>
</body>
</html>
