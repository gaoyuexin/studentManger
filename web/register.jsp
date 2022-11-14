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
    <h1>欢迎光临学生管理系统</h1>
    <span style="color: red">
        ${errorMsg}
    </span>
    <form action="user?func=registerUser" method="post">
        姓名<input type="text" name="uname" placeholder="请输入姓名">
        用户名<input type="text" name="username" placeholder="请输入姓名">
        密码<input type="password" name="password" placeholder="请输入姓名">
        <input type="submit" value="注册">
    </form>
</head>
<body>

</body>
</html>
