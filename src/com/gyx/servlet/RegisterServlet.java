package com.gyx.servlet;

import com.gyx.entity.User;
import com.gyx.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class RegisterServlet extends BaseServlet {
    private UserService userService = new UserService();

    private void checkUsername(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        boolean isRegist = userService.checkUsername(username);
        PrintWriter writer = resp.getWriter();
        writer.print(isRegist);
    }

    private void loggingUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username, password);
        HttpSession session = req.getSession();
        boolean isSuccess = userService.loggingUser(user,session);
        if (isSuccess){
//        resp.setHeader("refresh","0;url=student.jsp");
            resp.sendRedirect("student.jsp");
        }else {
//            resp.setHeader("refresh","0;url=logging.jsp");
            req.setAttribute("errorMsg","登陆失败请重新登录");
            req.getRequestDispatcher("logging.jsp").forward(req,resp);
        }
    }

    private void registerUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String uname = req.getParameter("uname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(uname, username, password);
        boolean isSuccess = userService.registerUser(user);
        if (isSuccess) {
//            resp.setHeader("refresh", "0;url=logging.jsp");
            resp.sendRedirect("logging.jsp");
        } else {
//            resp.setHeader("refresh", "0;url=register.jsp");
            req.setAttribute("errorMsg","注册失败请重新注册");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }

    }
}
