package com.wap.post;

import java.io.File;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.Part;
import com.oreilly.servlet.multipart.FilePart;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.wap.user.User;
import com.wap.post.PostData;
import com.wap.user.UserRepository;
import org.mongodb.morphia.Datastore;
import com.wap.common.MultipartMap;
import java.util.Arrays;


@WebServlet("/UploadServlet")
@MultipartConfig(location = PostData.fileSavePath, maxFileSize = 10485760L)
public class UploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException
    {
        request.getRequestDispatcher("./createPost.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException
    {
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
            for (String img: images_tmp) {
                images.add(PostData.fileSavePath+ img);
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

        request.getRequestDispatcher("./createPost.jsp").forward(request, response);
    }


}