package com.wap.login;

import com.wap.user.User;
import com.wap.user.UserRepository;
import org.mongodb.morphia.Datastore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new UserRepository((Datastore) this.getServletContext()
                .getAttribute("DATA_STORE")).get(name, password);
        if (user != null) {
            request.getSession().setAttribute("User", user);
            response.sendRedirect("DashBoard.jsp");
        } else {
            out.println("Login Failure");
        }
    }

}