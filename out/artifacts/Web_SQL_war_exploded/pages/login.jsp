<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>登陆</title>
<base href="http://localhost:8080/Web_SQL_war_exploded/">
<!-- 编辑样式 -->
<style type="text/css">
	body{
		 /*设置背景渐变 */
		/*background-image: linear-gradient(to left,*/
		/*#9c88ff,#3cadeb);*/
		background-image: url("<%=request.getContextPath()%>/img/a.jpg");
		background-size:100% 100%;
		background-attachment: fixed;

	}

	h1{
		color:red;
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

	#id_username,#id_password{
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

</style>
<%--	使用jQuery需要引入jQuery的库--%>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">

	$(function(){
		$("#id_username").focus(function(){
			$("#id_span").html("<font color='red'>请输入用户名称</font>")
		})
		$("#id_username").blur(function(){
			$("#id_span").text("")
		})
	});
	
</script>
</head>
<body>
	<table align="center">
		<h1 align="center">登陆 留言系统</h1>
		<form action="LoginServlet" method="post">
			<tr>
				<td>用户名称：</td>
				<td><input type="text" placeholder="USER NAME" name="username" id="id_username"> <span id="id_span"> ${error} </span> </td>
			</tr>
			<tr>
				<td>用户密码：</td>
				<td><input type="password" placeholder="PASSWORD" name="password" id="id_password"> <br> </td>
			</tr>
			<tr>
				<td><input type="submit" value="登陆" id="sub"></td>
				<td><a href="pages/regist.jsp" id="sub2">注册</a></td>
			</tr>
		</form>
	</table>
</body>
</html>