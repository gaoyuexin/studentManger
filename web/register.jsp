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
</head>
<body>
<h1>欢迎光临学生管理系统</h1>
<span style="color: red">
    ${errorMsg}
</span>
<form action="user?func=registerUser" method="post">
    姓名<input type="text" name="uname"  placeholder="请输入姓名"><br>
    用户名<input type="text" name="username" id="username1" placeholder="请输入用户名">
    <span id="usernameInfo"></span><br>
    密码<input type="password" name="password" placeholder="请输入密码"><br>
    <input type="submit" value="注册">
</form>
</body>
<script src="js/jquery-3.6.1.js"></script>
<script>
    $("#username1").blur(function () {
        var val = $("#username1").val();
        if (val == "" || val.trim() == "") {
            $("#usernameInfo").text("用户名不能为空").css("color", "red");
        } else {
            $.ajax({
                url: "user",
                type: "post",
                data: {"username": val, "func": "checkUsername"},
                dataType: "json",
                success: function (isRegist) {
                    if (isRegist) {
                        $("#usernameInfo").text("用户名已经存在").css("color", "red");
                    } else {
                        $("#usernameInfo").text("用户名ok").css("color", "green");
                    }
                }
            })
        }
    })

</script>
</html>
