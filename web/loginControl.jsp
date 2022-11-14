<%--
  Created by IntelliJ IDEA.
  User: 高
  Date: 2022/11/14
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //控制登录页面
    Object object = session.getAttribute("user");
    if (object==null){
        request.setAttribute("errorMsg","小伙子先登录");
        request.getRequestDispatcher("logging.jsp").forward(request,response);
    }
%>
</body>
</html>
