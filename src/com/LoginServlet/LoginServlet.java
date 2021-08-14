package com.LoginServlet;

import bean.ss_1;
import com.ServletMethod.ServletMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 获取用户登陆信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 当输入空白时，进行过滤
        if (username.length() == 0 || password.length() == 0)
        {
            request.setAttribute("error", "用户名或密码错误");
            request.getRequestDispatcher("pages/login.jsp").forward(request, response);
        }

        System.out.println(username);
        System.out.println(password);
        ss_1 user = ServletMethod.query(username);
        System.out.println(user);

        // 进入管理员页面的筛选条件
        if(user.getPassword().equals(password) && user.getName().equals("岳昌宏"))
        {
            HttpSession session = request.getSession();
            session.setAttribute("name", "管理员");
            session.setAttribute("user", user);
            // 转发
            request.getRequestDispatcher("pages/admin.jsp").forward(request, response);
        }

        // 进入普通用户页面
        if (user.getPassword().equals(password))
        {
            HttpSession session = request.getSession();
            session.setAttribute("name", user.getName());
            session.setAttribute("user", user);
            // 转发
            request.getRequestDispatcher("pages/login_success.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "用户名或密码错误");
            request.getRequestDispatcher("pages/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
