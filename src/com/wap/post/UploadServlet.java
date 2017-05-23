package com.wap.post;

import com.wap.common.MultipartMap;
import com.wap.user.User;
import org.mongodb.morphia.Datastore;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/UploadServlet")
@MultipartConfig(location = PostData.fileSavePath, maxFileSize = 10485760L)
public class UploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        request.getRequestDispatcher("./createPost.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        if (!(new File(PostData.fileSavePath)).exists()) {
            (new File(PostData.fileSavePath)).mkdir();    // creates the directory if it does not exist
        }
        PrintWriter out = response.getWriter();

        MultipartMap map = new MultipartMap(request, this);
        PostData post = new PostData();
        post.setTitle(map.getParameter("post_title"));
        post.setContent(map.getParameter("post_content"));

        List<String> images_tmp = map.getFileNames("file");
        List<String> images = new ArrayList<String>();
        for (String img : images_tmp) {
            images.add("images/" + img);
        }

        post.setImages(images);

        Location lc = new Location(Double.parseDouble(map.getParameter("post_longitude")), Double.parseDouble(map.getParameter("post_latitude")));
        post.setLocation(lc);

        User user;
        HttpSession session = request.getSession();
        if (session.getAttribute("User") != null) {
            user = (User) session.getAttribute("User");
        } else {
            user = new User();
        }

        post.setName(user.getName());

        new PostDataRepository((Datastore) this.getServletContext()
                .getAttribute("DATA_STORE")).save(post);

        out.println("Create Success");

        this.getServletContext().setAttribute("hasNew", true);

        request.getRequestDispatcher("./createPost.jsp").forward(request, response);
    }


}