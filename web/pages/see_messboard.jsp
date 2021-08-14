<%--
  Created by IntelliJ IDEA.
  User: 岳昌宏
  Date: 2021/6/26
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看留言板</title>
    <base href="http://localhost:8080/Web_SQL_war_exploded/">
    <style type="text/css">
        body{
            background-image: url("<%=request.getContextPath()%>/img/a.jpg");
            background-size:100% 100%;
            background-attachment: fixed;
        }
        h{
            color: red;
            size: A4;
        }

        table{
            align-content: center;
            size: A3;
        }
    </style>
</head>
<body>
    <h>留言板</h> <br>
    <table>
        <tr><td>${username1}${time1}:  ${message1}</td></tr>
        <tr><td>${username2}${time2}:  ${message2}</td></tr>
        <tr><td>${username3}${time3}:  ${message3}</td></tr>
        <tr><td><a href="<%=request.getContextPath()%>/pages/messboard.jsp">返回</a></td></tr>
    </table>
</body>
</html>
