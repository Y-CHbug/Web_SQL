package com.User;

import bean.ss_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/BasicInfoServlet")
public class BasicInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        ss_1 user = (ss_1)session.getAttribute("user");

        String name = user.getName();
        String password = user.getPassword();
        String email = user.getEmail();

        session.setAttribute("nameinfo", name);
        session.setAttribute("passwordinfo", password);
        session.setAttribute("emailinfo", email);

        request.getRequestDispatcher("pages/basicinfo.jsp").forward(request, response);

    }

}
