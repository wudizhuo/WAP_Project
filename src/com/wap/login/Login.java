package com.wap.login;

import org.mongodb.morphia.Datastore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            String name = request.getParameter("username");
            String password = request.getParameter("password");
            if (validateUser(name, password)) {
                response.sendRedirect("DashBoard.jsp");
            } else {
                out.println("Login Failure");
            }
        } finally {
            out.close();
        }
    }

    private boolean validateUser(String name, String password) {
        return new UserRepository((Datastore) this.getServletContext()
                .getAttribute("DATA_STORE")).validateUser(name, password);
    }
}