<%@ page import="java.util.List" %>
<%@ page import="com.gyx.entity.Student" %><%--
  Created by IntelliJ IDEA.
  com.gyx.entity.User: 高
  Date: 2022/11/10
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="loginControl.jsp"%>
<table border="1" cellspacing="0" cellpadding="10" width="1000" align="center">
    <caption>
        <h2>学生信息表</h2>
    </caption>
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>爱好</th>
        <th>学历</th>
        <th>简介</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${stus}" var="stu" varStatus="i">
        <tr align="center">
            <td>${i.count}</td>
            <td>${stu.sname}</td>
            <td>${stu.gender}</td>
            <td>${stu.hobby.substring(1,stu.hobby.length() -1)}</td>
            <td>${stu.degree}</td>
            <td>${stu.mark}</td>
            <td><a href="student?func=deleteStudentById&sid=${stu.sid}">删除</a></td>
            <td><a href="student?func=findStudentById&sid=${stu.sid}">修改</a></td>
        </tr>
    </c:forEach>


</table>
</body>
</html>
