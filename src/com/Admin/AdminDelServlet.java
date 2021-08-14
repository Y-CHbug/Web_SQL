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

@WebServlet("/AdminDelServlet")
public class AdminDelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        // 当前登陆用户
        ss_1 user = (ss_1)session.getAttribute("user");

        System.out.println(user);
        String delname = request.getParameter("delname");

        session.setAttribute("del", "");

        int i2 = 0;
        if (! delname.equals("岳昌宏")) {
            i2 = ServletMethod.DelUser(delname);
        }

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
