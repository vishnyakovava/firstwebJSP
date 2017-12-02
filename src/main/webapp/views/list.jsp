<%--
  Created by IntelliJ IDEA.
  User: mp
  Date: 29.11.2017
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>lists</title>
</head>
<body>
<h1>Database:</h1>
</div>
<%Iterator itr;%>
<%
    List<String> dataList = (List<String>) request.getAttribute("data");
    for(itr=dataList.iterator(); itr.hasNext();){
        %> <tr><td align="center"><%=itr.next()%><br></td></tr>
<%}%>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
