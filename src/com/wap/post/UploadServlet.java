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
import java.util.List;
import com.wap.user.User;
import com.wap.post.PostData;
import com.wap.user.UserRepository;
import org.mongodb.morphia.Datastore;
import com.wap.common.MultipartMap;
import java.util.Arrays;


@WebServlet("/UploadServlet")
@MultipartConfig(location = "C:/uploads/", maxFileSize = 10485760L)
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
        PrintWriter out = response.getWriter();

        MultipartMap map = new MultipartMap(request, this);
        PostData post = new PostData();
        post.setTitle(map.getParameter("post_title"));
        post.setContent(map.getParameter("post_content"));

        post.setImages(map.getFileNames("file"));
        System.out.println(map.getParameterValues("post_longitude"));



        post.setName("fake name");

        new PostDataRepository((Datastore) this.getServletContext()
                .getAttribute("DATA_STORE")).save(post);

        out.println("Create Success");

        request.getRequestDispatcher("./createPost.jsp").forward(request, response);
    }


}