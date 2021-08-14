<%--
  Created by IntelliJ IDEA.
  User: 岳昌宏
  Date: 2021/6/26
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言板</title>
    <base href="http://localhost:8080/Web_SQL_war_exploded/">
    <style type="text/css">
        body{
            background-image: url("<%=request.getContextPath()%>/img/a.jpg");
            background-size:100% 100%;
            background-attachment: fixed;
        }
    </style>
</head>
<body>

<form action="MessBoardServlet" method="post">
    <div align="center">
        <table>
            <h>留言版</h>
        </table>

<%--        下面用来提交留言--%>
        <table>
            <tr><td>留言内容：</td></tr>
            <tr>
                <td><input type="text" name="liuyan"/></td>
                <td><input type="submit" value="提交"/> ${mess}</td>
            </tr>
            <tr>
                <td><a href="<%=request.getContextPath()%>/SeeServlet">查看留言</a></td>
                <td><a href="<%=request.getContextPath()%>/pages/login_success.jsp">返回</a></td>
            </tr>

        </table>

    </div>

</form>


</body>
</html>
