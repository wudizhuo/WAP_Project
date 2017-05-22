package com.wap.like;


import com.google.gson.Gson;
import com.wap.commet.Comment;
import com.wap.commet.CommentJson;
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
@WebServlet("/LikeServlet")
public class LikeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsonLike = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        LikeJson likeJson = new Gson().fromJson(jsonLike, LikeJson.class);
        String PostId = likeJson.postId;
        System.out.println(PostId);
        PostDataRepository postDataRepository = new PostDataRepository((Datastore) this.getServletContext().getAttribute("DATA_STORE"));
        PostData post = postDataRepository.getPost(likeJson.postId);
        int likeNum = post.getLike();
        likeNum++;
        post.setLike(likeNum);
        postDataRepository.save(post);
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("success");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
