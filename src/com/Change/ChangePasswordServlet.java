package com.Change;

import bean.ss_1;
import com.ServletMethod.ServletMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String oldpassword = request.getParameter("oldpassword");
        String newpassword = request.getParameter("newpassword");
        String newpassword2 = request.getParameter("newpassword2");

        HttpSession session = request.getSession();
        ss_1 user = (ss_1)session.getAttribute("user");
        System.out.println(user);

        System.out.println(oldpassword);
        System.out.println(newpassword);
        System.out.println(newpassword2);

        if (user.getPassword().equals(oldpassword))
        {
            System.out.println("进行修改密码操作>>>>>>");

            int i = ServletMethod.UpdatePassword(newpassword, user.getName());

            System.out.println(i);

            if (i == 1)
            {
                response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
            }else
            {
                request.setAttribute("error2", "修改失败");
                request.getRequestDispatcher("/pages/changepassword").forward(request, response);
            }


        }else
        {
            request.setAttribute("error2", "原密码输入错误");
            request.getRequestDispatcher("/pages/changepassword.jsp").forward(request, response);

        }

    }
}
