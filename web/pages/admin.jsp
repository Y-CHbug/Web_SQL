<%--
  Created by IntelliJ IDEA.
  User: 岳昌宏
  Date: 2021/6/25
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员</title>
    <base href="http://localhost:8080/Web_SQL_war_exploded/">
    <style type="text/css">
        h1{
            color:red;
        }
        body{
            background-image: url("<%=request.getContextPath()%>/img/b.jpg");
            background-size:100% 100%;
            background-attachment: fixed;
        }

    </style>
</head>
<body>
    <h2>欢迎${name}登陆</h2> <br>
    <table>
        <form action="AdminQueryServlet" method="post">
            <tr>
                <td><h4>查询用户</h4></td>
            </tr>
            <tr>
                <td>请输入你要查询用户的姓名：</td>
                <td><input type="text" name="username">${error_null}</td>
            </tr>
            <tr>
                <td><input type="submit" value="查询"></td>
            </tr>
        </form>
    </table>

    <hr>

    <table>
        <form action="AdminAddServlet" method="post">
            <tr>
                <td><h4>添加用户</h4></td>
            </tr>
            <tr>
                <td>用户姓名：</td>
                <td><input type="text" name="addname"> ${add}</td>
            </tr>
            <tr>
                <td>用户密码：</td>
                <td><input type="text" name="addpassword"></td>
            </tr>
            <tr>
                <td>用户邮箱</td>
                <td><input type="email" name="addemail"></td>
            </tr>
            <tr>
                <td><input type="submit" value="添加"></td>
            </tr>
        </form>
    </table>

    <hr>

    <table>
        <form action="AdminDelServlet" method="post">
            <tr>
                <td><h4>删除用户</h4></td>
            </tr>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="delname"></td>
            </tr>
            <tr>
                <td><input type="submit" value="删除"></td>
            </tr>
        </form>
    </table>

    <a href="<%=request.getContextPath()%>/QuitServlet">退出</a>

</body>
</html>
