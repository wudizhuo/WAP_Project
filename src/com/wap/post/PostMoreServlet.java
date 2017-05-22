package com.wap.post;

/**
 * Created by hongleyou on 2017/5/21.
 */

import org.mongodb.morphia.Datastore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/PostMoreServlet")
public class PostMoreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PostData postData;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//
//        postDatas = new PostDataRepository((Datastore) this.getServletContext().getAttribute("DATA_STORE")).getPostData();
//
//        request.setAttribute("UserPosts", postDatas);
//
////        request.setAttribute("name", obj.getName());
////        request.setAttribute("content", obj.getContent());
////        request.setAttribute("like", obj.getLike());
////        //System.out.println(obj.getImage());
////        request.setAttribute("image", obj.getImage());
////        request.setAttribute("comments", obj.getComments());
//        request.getRequestDispatcher("postData.jsp").forward(request, response);
//
        postData = new PostDataRepository((Datastore) this.getServletContext()
                .getAttribute("DATA_STORE")).getMorePostData(Integer.valueOf(request.getParameter("data")));
        System.out.println(postData.getContent());

        List<PostData> userPosts = (List<PostData>) this.getServletContext().getAttribute("UserPosts");
        userPosts.add(postData);
        //System.out.println(userPosts.size());
        this.getServletContext().setAttribute("UserPosts", userPosts);
        response.setStatus(HttpServletResponse.SC_OK);
        request.getRequestDispatcher("postData.jsp").forward(request, response);
        //request.setAttribute("postData", postData);
        //response.getWriter().println("success");

    }

}