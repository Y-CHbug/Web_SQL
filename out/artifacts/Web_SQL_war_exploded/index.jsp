<%--
  Created by IntelliJ IDEA.
  User: 岳昌宏
  Date: 2021/1/29
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>开始页面</title>
    <base href="http://localhost:8080/Web_SQL_war_exploded/">
    <!-- 编辑样式 -->
    <style type="text/css">
      body{
        background-image: url("<%=request.getContextPath()%>/img/a.jpg");
        background-size:100% 100%;
        background-attachment: fixed;
      }
      h1{
        color:red;
      }

      button{
        margin: 20px;
        bottom: 40px;
        display: block;
        width: 200px;
        height: 60px;
        font: 900 30px '';
        text-decoration: none;
        line-height: 50px;
        border-radius: 30px;
        background-image: linear-gradient(to left,
        #9c88ff,#3cadeb);
        text-align: center;
      }
    </style>

  </head>
  <body>
  <div align="center">
  <h1>留言系统</h1>
  <button><a href="pages/login.jsp" id="id_1">登陆</a></button><br>
  <button><a href="pages/regist.jsp" id="id_2">注册</a></button>
  </div>
  </body>
</html>
