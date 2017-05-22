package com.wap.post;

import java.io.File;
import javax.servlet.*;
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


@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {

    private String fileSavePath;
    private static final String UPLOAD_DIRECTORY = "Upload";

    public void init() {
        //fileSavePath = getServletContext().getRealPath("/") + File.separator + UPLOAD_DIRECTORY;/*save uploaded files to a 'Upload' directory in the web app*/
    	fileSavePath ="C:/uploads";
    	if (!(new File(fileSavePath)).exists()) {
            (new File(fileSavePath)).mkdir();    // creates the directory if it does not exist        
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        String resp = "";
        int i = 1;
        resp += "<br>Here is information about uploaded files.<br>";
        try {
            MultipartParser parser = new MultipartParser(request, 1024 * 1024 * 1024);  /* file limit size of 1GB*/
            Part _part;
            while ((_part = parser.readNextPart()) != null) {
                if (_part.isFile()) {
                    FilePart fPart = (FilePart) _part;  // get some info about the file
                    String name = fPart.getFileName();
                    if (name != null) {
                        long fileSize = fPart.writeTo(new File(fileSavePath));
                        resp += i++ + ". " + fPart.getFilePath() + "[" + fileSize / 1024 + " KB]<br>";
                    } else {
                        resp = "<br>The user did not upload a file for this part.";
                    }
                }
            }// end while


            PrintWriter out = response.getWriter();

            PostData post = new PostData();
            post.setTitle(request.getParameter("post_title"));
            post.setContent(request.getParameter("post_content"));
            //post.setContent("fake content");
            post.setName("fake name");

            new PostDataRepository((Datastore) this.getServletContext()
                    .getAttribute("DATA_STORE")).save(post);

            out.println("Create Success");


        } catch (java.io.IOException ioe) {
            resp = ioe.getMessage();
        }
        request.setAttribute("message", resp);
        getServletContext().getRequestDispatcher("/createPost.jsp").forward(request, response);
    }


}