<%--
  Created by IntelliJ IDEA.
  User: 岳昌宏
  Date: 2021/6/24
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/Web_SQL_war_exploded/">

    <style type="text/css">
        body{
            background-image: url("<%=request.getContextPath()%>/img/a.jpg");
            background-size:100% 100%;
            background-attachment: fixed;
        }

        #sub{
            margin: 10px;
            bottom: 20px;
            display: block;
            width: 150px;
            height: 40px;
            font: 900 30px '';
            text-decoration: none;
            line-height: 30px;
            border-radius: 30px;
            background-image: linear-gradient(to left,
            #9c88ff,#3cadeb);
            text-align: center;
        }

    </style>
</head>
<body>
<table align="center">

    <form action="ChangePasswordServlet" method="post">
        <tr>
            <td>
                请输入旧密码：
            </td>
            <td>
                <input type="password" name="oldpassword">${error2}
            </td>
        </tr>
        <tr>
            <td>
                请输入新密码：
            </td>
            <td>
                <input type="password" name="newpassword">
            </td>
        </tr>
        <tr>
            <td>
                请重新输入密码：
            </td>
            <td>
                <input type="password" name="newpassword2">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" id="sub">
            </td>
            <td>
                <a href="<%=request.getContextPath()%>/pages/login_success.jsp">返回</a>
            </td>
        </tr>
    </form>
</table>
</body>
</html>
