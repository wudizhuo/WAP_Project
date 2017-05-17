package com.wap.servlets;

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

    private boolean validateUser(String name, String passKey) {
        return true;
    }

//    protected boolean validateUser(String userName, String passKey) {
//        connect userAuthenticationConnection = new connect();
//        ResultSet rs = null;
//        boolean test = userAuthenticationConnection.doConnection();
//        if (test == true) {
//            Connection con = userAuthenticationConnection.getConnect();
//            PreparedStatement stmt = null;
//            String sql = "select password from users where user_name = ?";
//            try {
//
//                stmt = con.prepareStatement(sql);
//                stmt.setString(1, userName);
//                rs = stmt.executeQuery();
//                if (!rs.first()) {
//                    return false;
//                }
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
//            String passWord = null;
//            try {
//
//                passWord = rs.getString("password");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            if (passWord.equals(passKey)) {
//                userAuthenticationConnection.closeConnection();
//                return true;
//            }
//        }
//        return false;
//    }
}