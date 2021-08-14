package com.MessBoard;
/**
 * @descriptions: 留言板功能
 * @author: 岳昌宏
 * @Date: 2021/6/26
 */
import bean.messageboard;
import bean.ss_1;
import com.ServletMethod.ServletMethod2;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/MessBoardServlet")
public class MessBoardServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Date date = new Date();
        java.sql.Date date1 = new java.sql.Date(date.getTime()); // 获取当前的事件
        String time = date1.toString(); // 将当前的事件转化成字符串

        // 获取当前对象
        HttpSession session = request.getSession();
        ss_1 user = (ss_1)session.getAttribute("user");

        List<messageboard> list = ServletMethod2.query();
        System.out.println(list);

        // 留言功能
        String mess = request.getParameter("liuyan");

        messageboard mb = new messageboard(user.getName(), time, mess);

        int i = ServletMethod2.insert(mb);

        session.setAttribute("mess", "");

        if (i > 0)
        {
            session.setAttribute("mess", "留言成功！");
            System.out.println("留言成功");
            request.getRequestDispatcher("pages/messboard.jsp").forward(request, response);
        }else
        {
            System.out.println("留言失败");
        }

    }

}
