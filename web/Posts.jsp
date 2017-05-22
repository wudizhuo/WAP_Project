<%@ page import="com.wap.post.PostDataRepository" %>
<%@ page import="org.mongodb.morphia.Datastore" %>
<%@ page import="com.wap.post.PostData" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hongleyou
  Date: 2017/5/18
  Time: 下午2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Post Page</title>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/map.js"></script>
    <script src="js/scroll.js"></script>
    <script type="text/javascript"src="AddComments.js"></script>
    <script type="text/javascript"src="AddLike.js"></script>
    <script type="text/javascript"src="DeletePost.js"></script>
    <!--link href="../CSS/login.css" type="text/css" rel="stylesheet"/-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <link href="../CSS/postData.css" type="text/css" rel="stylesheet"/>

</head>
<body>
<% List<PostData> posts = new PostDataRepository((Datastore) application.getAttribute("DATA_STORE")).getPostData();
    application.setAttribute("UserPosts", posts);
    pageContext.setAttribute("posts", posts);
%>
<div class="post_data" style="overflow: scroll; height: 100%;">
    <%@include file="postContent.jsp" %>
</div>
</body>
</html>
