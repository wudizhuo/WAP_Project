package com.wap.post;

import org.mongodb.morphia.Datastore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<PostData> postDatas;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        postDatas = new PostDataRepository((Datastore) this.getServletContext().getAttribute("DATA_STORE")).getPostData();

        this.getServletContext().setAttribute("UserPosts", postDatas);

//        request.setAttribute("name", obj.getName());
//        request.setAttribute("content", obj.getContent());
//        request.setAttribute("like", obj.getLike());
//        //System.out.println(obj.getImage());
//        request.setAttribute("image", obj.getImage());
//        request.setAttribute("comments", obj.getComments());
        request.getRequestDispatcher("postData.jsp").forward(request, response);
    }

}