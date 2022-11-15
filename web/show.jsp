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
<%--<%@include file="loginControl.jsp"%>--%>
<table border="1" cellspacing="0" cellpadding="10" width="1000" align="center">
    <caption>
        <h2>学生信息表</h2>
    </caption>
    <tr>
        <th>
            全选
            <input type="checkbox" id="all">
        </th>
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
            <td>
<%--                将每个学生的id绑定在复选框中，根据id批量删除学生--%>
                <input type="checkbox" class="one" value="${stu.sid}">
            </td>
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
    <tr>
        <td colspan="8" align="center">
            <button>批量删除</button>
            共${pageTool.totalCount}条数据，${pageTool.currentPage}/${pageTool.pageCount}页。
            <a href="student?func=findAllStudent&currentPage=1">首页</a>
            <a href="student?func=findAllStudent&currentPage=${pageTool.lastPage}">上一页</a>
            <a href="student?func=findAllStudent&currentPage=${pageTool.nextPage}">下一页</a>
            <a href="student?func=findAllStudent&currentPage=${pageTool.pageCount}">尾页</a>
        </td>
    </tr>
</table>
</body>
<script src="js/jquery-3.6.1.js"></script>
<script>
    //全选和全不选的实现
    $("#all").click(function () {
        //将当前点击复选框的选中状态赋予其余所有复选框的选中状态
        $(".one").prop("checked",$(this).prop("checked"));
    })
    //批量删除按钮事件
    $("button").click(function () {
        var ids = [];
        $(".one:checked").each(function () {
            ids.push($(this).val())
        })
        //异常处理
        if (ids.length == 0){
            alert("小伙子你还未选择删除对象")
        }else {
            if (confirm("小伙子不要后悔")){
                window.location = "student?func=batchDelete&ids="+ids;
            }
        }
    })

</script>
</html>
