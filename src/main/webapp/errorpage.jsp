<%--
  Created by IntelliJ IDEA.
  User: ostanislav
  Date: 10/30/20
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Pixelizator</title>
</head>
<body>
    <% String val = request.getScheme()+ "://";;
    String serverName = request.getServerName();
    String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
    String contextPath = request.getContextPath();
    %>
    <h2>Follow the link : </h2><%=val%><%=serverName%><%=serverPort%><%=contextPath%>
</body>
</html>
