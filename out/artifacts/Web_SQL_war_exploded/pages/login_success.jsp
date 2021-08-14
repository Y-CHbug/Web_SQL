<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
	<base href="http://localhost:8080/Web_SQL_war_exploded/">


<style type="text/css">
	h1{
		color:red;
	}
	body{
		background-image: url("<%=request.getContextPath()%>/img/a.jpg");
		background-size:100% 100%;
		background-attachment: fixed;
	}

	#sub,#sub3,#sub4{
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

	#sub2{
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

	td{
		align-content: center;
	}

</style>
</head>
<body>
<table align="center">
	<tr><td><h1>${name}登陆成功！</h1></tr></td>
	<tr><td><button id="sub"><a href="<%=request.getContextPath()%>/pages/changepassword.jsp">修改密码</a></button></tr></td>
	<tr><td><button id="sub2"><a href="<%=request.getContextPath()%>/BasicInfoServlet">基本信息</a></button></tr></td>
	<tr><td><button id="sub3"><a href="<%=request.getContextPath()%>/pages/messboard.jsp">留言板</a></button></tr></td>
	<tr><td><button id="sub4"><a href="<%=request.getContextPath()%>/QuitServlet">退出</a></button></tr></td>
</table>
</body>
</html>