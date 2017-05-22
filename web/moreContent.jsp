<%@ page import="com.wap.post.PostData" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    List<PostData> posts = (List<PostData>) application.getAttribute("morePost");
    pageContext.setAttribute("posts", posts);
%>
<%@include file="postContent.jsp" %>