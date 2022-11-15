<%--
  Created by IntelliJ IDEA.
  com.gyx.entity.User: 高
  Date: 2022/11/10
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%@include file="loginControl.jsp"%>--%>
<h1>学生注册中心</h1>
<span style="color: red">
    ${errorMsg}
</span>
<form action="student?func=insertStudent" method="post">
    姓名：<input type="text" name="sname" placeholder="请输入姓名"><br>
    性别：男<input type="radio" name="gender" value="男">女<input type="radio" name="gender" value="女"><br>
    爱好：唱<input type="checkbox" name="hobby" value="唱">跳<input type="checkbox" name="hobby" value="跳">rap<input type="checkbox" name="hobby" value="rap">
    篮球<input type="checkbox" name="hobby" value="篮球"><br>
    学历：<select name="degree" >
    <option value="本科">本科</option>
    <option value="专科">专科</option>
    <option value="小本">小本</option>
    <option value="幼儿园">幼儿园</option>
</select>
    <br>
    个人简介：<textarea name="mark" style="resize: none" >

</textarea>
    <input type="submit" value="提交信息">



</form>
</body>
</html>
