<%@ page import="com.wap.post.PostDataRepository" %>
<%@ page import="org.mongodb.morphia.Datastore" %>
<%@ page import="com.wap.post.PostData" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% List<PostData> posts = new PostDataRepository((Datastore) application.getAttribute("DATA_STORE")).getPostData();
    application.setAttribute("UserPosts", posts);
    pageContext.setAttribute("posts", posts);
%>
<div class="post_data" style="overflow: scroll; height: 100%;">
    <c:forEach items="${posts}" var="UserPost">
        <%@include file="postContent.jsp" %>
    </c:forEach>
</div>
