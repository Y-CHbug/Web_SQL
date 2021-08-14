package com.LoginServlet;

import com.ServletMethod.ServletMethod;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * 注册页面后台
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");


		int n = 0;
		if (username.length() > 0 && password1.length() > 0) {
			n = ServletMethod.insert(username, password1, email);
		}
		if (n > 0)
		{
			request.getRequestDispatcher("pages/login.jsp").forward(request, response);
		}else
		{
			request.getRequestDispatcher("pages/regist.jsp").forward(request, response);
			System.out.println("插入失败！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
