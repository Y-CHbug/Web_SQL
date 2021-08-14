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

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

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

        // 添加功能
        String addname = request.getParameter("addname");
        String addpassword = request.getParameter("addpassword");
        String addemail = request.getParameter("addemail");

        session.setAttribute("add", "");

        int i = 0;
        if (addname != null || addpassword != null || addemail != null) {
            i = ServletMethod.insert(addname, addpassword, addemail);
        }

        if (i > 0)
        {
            session.setAttribute("add", "添加成功");
            request.getRequestDispatcher("pages/admin.jsp").forward(request, response);
        }else
        {
            session.setAttribute("add", "添加失败");
            request.getRequestDispatcher("pages/admin.jsp").forward(request, response);
        }

        // 删除用户
        String delname = request.getParameter("delname");

        session.setAttribute("del", "");

        int i2 = ServletMethod.DelUser(delname);

        if (i2 > 0)
        {
            session.setAttribute("del", "删除成功");
            request.getRequestDispatcher("pages/admin.jsp").forward(request, response);
        }else
        {
            session.setAttribute("del", "删除失败");
            request.getRequestDispatcher("pages/admin.jsp").forward(request, response);
        }
    }
}
