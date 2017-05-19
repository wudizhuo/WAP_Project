package com.wap.post;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PostSerlvet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Query<PostData> postDatas;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        postDatas = new PostDataRepository((Datastore) this.getServletContext().getAttribute("DATA_STORE")).getPostData();
        List<PostData> objs = postDatas.asList();
        PostData obj = objs.get(0);
        out.println(obj.getName());
        out.println(obj.getContent());
        out.println(obj.getLike());
        out.println(obj.getLocation().getLatitude());
        out.println(obj.getLocation().getLongitude());
        out.println(obj.getImage());
        for(Comment comment : obj.getComments()) {
            out.println(comment.getName());
            out.println(comment.getComment());
        }

        //request.getRequestDispatcher("postData.jsp").forward(request, response);
    }

}