package com.wap.commet;

import com.google.gson.Gson;
import com.wap.commet.Comment;
import com.wap.post.PostData;
import com.wap.post.PostDataRepository;
import com.wap.user.User;
import org.mongodb.morphia.Datastore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * Created by yangyangli on 5/21/17.
 */
@WebServlet("/ComtServlet")
public class ComtServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        CommentJson commentJson = new Gson().fromJson(json, CommentJson.class);
        Comment e = new Comment(user.getName(), commentJson.content);

        PostDataRepository postDataRepository = new PostDataRepository((Datastore) this.getServletContext().getAttribute("DATA_STORE"));
        PostData post = postDataRepository.getPost(commentJson.postId);
        post.getComments().add(e);
        postDataRepository.save(post);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("success");
    }
}
