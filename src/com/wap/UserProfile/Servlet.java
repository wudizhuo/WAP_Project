package com.wap.UserProfile;

import com.wap.user.User;
import com.wap.user.UserRepository;
import org.mongodb.morphia.Datastore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        User user;
        HttpSession session = request.getSession();
        if (session.getAttribute("User") != null) {
            user = (User) session.getAttribute("User");
        } else {
            user = new User();
        }
        user.setName(request.getParameter("UserName"));
        user.setPassword(request.getParameter("Password"));
        user.setGender(request.getParameter("Gender"));
        user.setState(request.getParameter("State"));
        user.setCity(request.getParameter("City"));
        user.setStreet(request.getParameter("Street"));
        user.setZip(request.getParameter("Zipcode"));
        user.setBirthyear(request.getParameter("Birthyear"));
        user.setEmail(request.getParameter("email"));

        new UserRepository((Datastore) this.getServletContext()
                .getAttribute("DATA_STORE")).save(user);

        out.println("Create Success");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        response.sendRedirect("login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
