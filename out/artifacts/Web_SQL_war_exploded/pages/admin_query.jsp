<%--
  Created by IntelliJ IDEA.
  User: 岳昌宏
  Date: 2021/6/25
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询页面</title>
    <style type="text/css">
        body{
            background-image: url("<%=request.getContextPath()%>/img/b.jpg");
            background-size:100% 100%;
            background-attachment: fixed;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <td>姓名：</td>
            <td>${name2}</td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>${password2}</td>
        </tr>
        <tr>
            <td>邮箱：</td>
            <td>${email2}</td>
        </tr>
    </table>
    <a href="<%=request.getContextPath()%>/pages/admin.jsp">返回</a>
</body>
</html>
