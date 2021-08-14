<%--
  Created by IntelliJ IDEA.
  User: 岳昌宏
  Date: 2021/6/26
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基本信息</title>
    <style type="text/css">
        body{
            background-image: url("<%=request.getContextPath()%>/img/a.jpg");
            background-size:100% 100%;
            background-attachment: fixed;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <td>姓名：</td>
            <td>${nameinfo}</td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>${passwordinfo}</td>
        </tr>
        <tr>
            <td>邮箱：</td>
            <td>${emailinfo}</td>
        </tr>
    </table>

    <a href="<%=request.getContextPath()%>/pages/login_success.jsp">返回</a>
</body>
</html>
