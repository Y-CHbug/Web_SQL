<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<base href="http://localhost:8080/Web_SQL_war_exploded/">
	<!-- 编辑样式 -->
	<style type="text/css">
		body {
			background-image: url("<%=request.getContextPath()%>/img/a.jpg");
			background-size:100% 100%;
			background-attachment: fixed;
		}

		h1{
			color:red;
		}
		body{
			background-color: cornflowerblue;
		}
		input{
			color:black;
			width: 200px;
			margin: 20px 0;
			outline: none;
			border: 0;
			padding: 10px;
			border-bottom: 3px solid rgb(80,80,170);
			font: 900 16px '';
		}
		a{
			color:seagreen;
		}
		#sub{
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
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#id_username").focus(function(){
				$("#id_span").html("<font color='red'>请输入3-6位的字母，数字，下划线组成的用户名</font>")
			})
			$("#id_username").blur(function(){
				$("#id_span").text("")
			})



		});
	</script>
</head>

<body>
<table align="center">
	<tr><h1 align="center">注册 留言系统</h1></tr>
	<form action="RegistServlet" method="post">
		<tr>
			<td>用户名：</td>
			<td><input type="text" placeholder="USER NAME" name="username" id="id_username"> <span id="id_span"></span><br></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" placeholder="PASSWORD" name="password1"> <br> </td>
		</tr>
		<tr>
			<td>请重新输入：</td>
			<td><input type="password" placeholder="AGAIN" name="password2" id=""> <br></td>
		</tr>
		<tr>
			<td>邮箱：</td>
			<td><input type="email" placeholder="EMAIL" name="email"> <br></td>
		</tr>
		<tr>
			<td><input type="submit" value="提交" id="sub"></td>
			<td><a href="pages/login.jsp">登陆</a></td>
		</tr>
	</form>
</table>
</body>
</html>