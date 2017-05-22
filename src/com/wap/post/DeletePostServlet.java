package com.wap.post;

import com.google.gson.Gson;
import com.wap.like.LikeJson;
import org.mongodb.morphia.Datastore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yangyangli on 5/22/17.
 */
@WebServlet("/DeletePostServlet")
public class DeletePostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsonLike = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        PostJson postJson = new Gson().fromJson(jsonLike, PostJson.class);
        String PostId =  postJson.postId;
        PostDataRepository postDataRepository = new PostDataRepository((Datastore) this.getServletContext().getAttribute("DATA_STORE"));
        List<PostData> posts = postDataRepository.getAllPostData();
        System.out.println(PostId);
        for (PostData p :posts) {
            System.out.println(p);
            if(p.get_id().equals(PostId)) {
                System.out.println(posts);
                System.out.println(PostId);
                postDataRepository.delete(p);
            }
        }
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("success");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
