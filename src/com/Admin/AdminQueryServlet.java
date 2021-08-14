package com.Admin;

import bean.ss_1;
import com.ServletMethod.ServletMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AdminQueryServlet")
public class AdminQueryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        // 当前登陆用户
        ss_1 user = (ss_1)session.getAttribute("user");

        System.out.println(user);

        String username = request.getParameter("username");
        System.out.println(">>>>>>" + username);

        // 要查询的用户
        ss_1 user2 = ServletMethod.query(username);

        System.out.println(user2);

        // 查询功能
        if (user2 == null)
        {
            session.setAttribute("error_null", "查无此人");
            request.getRequestDispatcher("pages/admin.jsp").forward(request, response);
        }else
        {
            session.setAttribute("error_null", "");

            String name2 = user2.getName();
            String password2 = user2.getPassword();
            String email2 = user2.getEmail();

            session.setAttribute("name2", name2);
            session.setAttribute("password2", password2);
            session.setAttribute("email2", email2);

            request.getRequestDispatcher("pages/admin_query.jsp").forward(request, response);
        }
    }
}
