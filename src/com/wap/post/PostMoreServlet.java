package com.wap.post;

import com.google.gson.Gson;
import org.mongodb.morphia.Datastore;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/PostMoreServlet")
public class PostMoreServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        List<PostData> userPosts = (List<PostData>) servletContext.getAttribute("UserPosts");

        PostDataRepository data_store = new PostDataRepository((Datastore) servletContext
                .getAttribute("DATA_STORE"));
        int length = (int) data_store.getlength();

        String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println("-----" + json);
        int more = new Gson().fromJson(json, GetMoreJson.class).more;

        if (userPosts.size() == length) {
            //TODO
            //have get all
        }

        if ((userPosts.size() + more) > length) {
            more = length - userPosts.size();
        }

        userPosts.addAll(data_store.getMorePostData(userPosts.size(), more));
        servletContext.setAttribute("UserPosts", userPosts);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("success");
    }
}