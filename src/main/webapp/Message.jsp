<%--
  Created by IntelliJ IDEA.
  User: mp
  Date: 28.11.2017
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<center>
    <h3><%=request.getAttribute("Message")%></h3>
</center>
</body>

<div>
    <button onclick="location.href='/add'">Back to add</button>
    <button onclick="location.href='/'">Back to main</button>

</div>
</html>
