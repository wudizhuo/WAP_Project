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
    <p>"${name}"</p>
    <p>"${content}"</p>
    <p>"${like}"</p>
    <p><img id = "image" src="${image}" alt="image"/></p>

    <c:forEach items="${comments}" var="Comment">
        <p>${Comment.name}</p>
        <p>${Comment.comment}</p>
    </c:forEach>
</form>

</body>
</html>
