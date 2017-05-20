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
    <!--link href="../CSS/login.css" type="text/css" rel="stylesheet"/-->
</head>
<body>

<form  id="post_page" action="/post">
    <c:forEach items = "${UserPosts}" var="UserPost">
        <p>"${UserPost.getName()}"</p>
        <p>"${UserPost.getContent()}"</p>
        <p>"${UserPost.getLike()}"</p>
        <p><img id = "image" src="${UserPost.getImage()}" alt="image"/></p>

        <%--<c:forEach items="${comments}" var="Comment">--%>
            <%--<p>${Comment.name}</p>--%>
            <%--<p>${Comment.comment}</p>--%>
        <%--</c:forEach>--%>
    </c:forEach>
</form>

</body>
</html>
