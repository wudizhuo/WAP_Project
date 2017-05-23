<%--
  Created by IntelliJ IDEA.
  User: Cao Ha
  Date: 5/19/2017
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- Material Design Lite -->
    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
    <!-- Material Design icon font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link href="CSS/createPost.css" type="text/css" rel="stylesheet"/>
    <title>Traveling is the best wonderful of my life</title>
</head>
<body>
<!-- Always shows a header, even in smaller screens. -->
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
    <header class="mdl-layout__header">
        <div class="mdl-layout__header-row">
            <!-- Title -->
            <span class="mdl-layout-title">WAP Project</span>
        </div>
    </header>

    <div class="content">

        <form action="UploadServlet" method="post" enctype="multipart/form-data">
            <label for="post_title">Post title</label>
            <div class="post">
                <input id="post_title" name="post_title" type="text" data-length="10">
            </div>
            <div class="post_date">
                <label for="post_date">Date travelled</label>
                <div class="post">
                    <input type="date" id = "post_date" class="datepicker">
                </div>
                <div >
                    <div class="post_content">
                        <label for="post_content">Post content</label>
                        <div class="post">
                        <textarea id="post_content" name = "post_content"
                                  class="materialize-textarea" data-length="500"></textarea>
                        </div>
                    </div>
                </div>
            <input type="file" id="file" name="file" accept="image/*"  multiple="muliple" required/>
            <c:if test="${not empty parts.file}"> Files successfully uploaded!</c:if>


            <div>
                <input id="post_longitude" name="post_longitude" type="hidden" data-length="10">
                <input id="post_latitude" name="post_latitude" type="hidden" data-length="10">
            </div>
            <script>
                var y = document.getElementById("post_longitude");
                var x = document.getElementById("post_latitude");

                navigator.geolocation.getCurrentPosition(success, fail);

                function success(position) {
                    y.value = position.coords.longitude;
                    x.value = position.coords.latitude;
                }

                function fail(msg) {
                    console.log(msg.code + msg.message); // TODO: Change to use information from User
                }

            </script>

                <br>
                <input type="submit"/>
                <br><br> ${requestScope.message}
        </form>

    </div>

    <div class="mdl-layout__drawer">
        <span class="mdl-layout-title">WAP Project</span>
        <nav class="mdl-navigation">
            <a class="mdl-navigation__link" href="./createPost.jsp">Create</a>
            <a class="mdl-navigation__link" href="./weather.jsp">Weather</a>
            <a class="mdl-navigation__link" href="">User Profile</a>
        </nav>
    </div>
    <main class="mdl-layout__content">
        <div class="page-content"><!-- Your content goes here --></div>
    </main>
</div>
</body>
</html>
