<%--
  Created by IntelliJ IDEA.
  User: 高
  Date: 2022/11/14
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%@include file="loginControl.jsp"%>--%>
<h1>学生信息修改中心</h1>
<span style="color: red">
    ${errorMsg}
</span>
<form action="student?func=updateStudent&sid=${student.sid}" method="post">
    姓名：<input type="text" name="sname" value="${student.sname}" placeholder="请输入姓名"><br>

    性别：男<input type="radio" <c:if test="${student.gender == '男'}">checked</c:if> name="gender" value="男">女<input type="radio" <c:if test="${student.gender == '男'}">checked</c:if> name="gender" value="女"><br>
    爱好：唱<input type="checkbox" <c:if test="${student.hobby.contains('唱')}">checked</c:if> name="hobby" value="唱">
    跳<input type="checkbox" <c:if test="${student.hobby.contains('跳')}">checked</c:if> name="hobby" value="跳">
    rap<input type="checkbox" <c:if test="${student.hobby.contains('rap')}">checked</c:if> name="hobby" value="rap">
    篮球<input type="checkbox" <c:if test="${student.hobby.contains('篮球')}">checked</c:if> name="hobby" value="篮球"><br>
    学历：<select name="degree" >
    <option <c:if test="${student.degree == '本科'}">selected</c:if> value="本科">本科</option>
    <option <c:if test="${student.gender == '专科'}">selected</c:if> value="专科">专科</option>
    <option <c:if test="${student.gender == '小本'}">selected</c:if> value="小本">小本</option>
    <option <c:if test="${student.gender == '幼儿园'}">selected</c:if> value="幼儿园">幼儿园</option>
</select>
    <br>
    个人简介：<textarea name="mark" style="resize: none" >
</textarea>
    <input type="submit" value="提交信息">
</form>
</body>
</html>
