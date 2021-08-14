package com.MessBoard;

import bean.messageboard;
import bean.ss_1;
import com.ServletMethod.ServletMethod2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/SeeServlet")
public class SeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        ss_1 user = (ss_1)session.getAttribute("user");

        List<messageboard> list = ServletMethod2.query();

        if (list != null)
        {
            int index = 1;
            int count = list.size();
            // 获取最新的三条数据
            for (int i = count - 3; i<count; i++)
            {
                String username = list.get(i).getUsername(); // 获取用户名
                String time = list.get(i).getTime(); // 获取时间
                String message = list.get(i).getMessage(); // 获取留言

                session.setAttribute("username" + index, username);
                session.setAttribute("time" + index, time);
                session.setAttribute("message" + index, message);
                index++;
            }
            request.getRequestDispatcher("pages/see_messboard.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
