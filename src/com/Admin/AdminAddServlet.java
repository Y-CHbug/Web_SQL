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

@WebServlet("/AdminAddServlet")
public class AdminAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        // 当前登陆用户
        ss_1 user = (ss_1)session.getAttribute("user");

        System.out.println(user);

        String addname = request.getParameter("addname");
        String addpassword = request.getParameter("addpassword");
        String addemail = request.getParameter("addemail");

        session.setAttribute("add", "");

        int i = 0;
        if (! ( addname.equals(null) || addname.equals("") || addpassword.equals(null) || addpassword.equals(""))) {
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

    }
}
