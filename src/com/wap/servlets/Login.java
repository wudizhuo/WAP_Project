package com.wap.servlets;

import com.mongodb.MongoClient;
import com.wap.repositories.UserRepository;

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
                out.println("<h1>Welcome </h1>" + name);
            } else {
                out.println("Login Failure");
            }
        } finally {
            out.close();
        }
    }

    private boolean validateUser(String name, String password) {
        UserRepository mongo_client = new UserRepository((MongoClient) this.getServletContext()
                .getAttribute("MONGO_CLIENT"));
        return mongo_client.validateUser(name, password);
    }
}