<%--
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
    <script type="text/javascript"src="map.js"></script>
    <!--link href="../CSS/login.css" type="text/css" rel="stylesheet"/-->
</head>
<body>


    <c:forEach items = "${UserPosts}" var="UserPost">
    <form  id="post_page" method="post" action="map.jsp">
        <p>"${UserPost.getName()}"</p>
        <p>"${UserPost.getContent()}"</p>
        <p>"${UserPost.getLike()}"</p>
        <p><img id = "image" src="${UserPost.getImage()}" alt="image"/></p>
        <input type="hidden" name="longitude" value="${UserPost.getLocation().getLongitude()}">
        <input type="hidden" name="latitude" value="${UserPost.getLocation().getLatitude()}">
        <p><button type="submit">Get localtion</button></p>
        <%@include file="CommentSub.jsp"%>
    </form>
    </c:forEach>

</body>
</html>
