<%--
  Created by IntelliJ IDEA.
  com.gyx.entity.User: 高
  Date: 2022/11/10
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>欢迎会员登录</h1>
<span style="color: red">
    ${errorMsg}
</span>
<form action="user?func=userLogin" method="post">
    用户名：<input type="text" name="username" placeholder="请输入用户名">
    密码：<input type="password" name="password" placeholder="请输入密码">
    <input type="submit" value="登录">
</form>
</body>
</html>
