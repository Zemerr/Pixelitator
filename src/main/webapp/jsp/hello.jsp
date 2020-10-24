<%--
  Created by IntelliJ IDEA.
  User: ostanislav
  Date: 10/23/20
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div align="center">
    <h2><c:out value="lol" /></h2>
    <h3><c:out value="pic" /></h3>
    <img src="data:image/jpg;base64,${pic.base64Image}" width="240" height="300"/>
</div>
</body>
</html>
