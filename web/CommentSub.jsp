<%--
  Created by IntelliJ IDEA.
  User: yangyangli
  Date: 5/20/17
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SubComments</title>

</head>
<body>

<div class="comments">
    <c:forEach var = "Post_comments" items = "${UserPost.comments}">
        <p>${Post_comments.name} </p>
        <p>${Post_comments.comment}</p>
    </c:forEach>
</div>
<div class="cmtname"></div>
<br/>
<div class="cmtcontext"></div>
<div>
   <P style="font-style: italic" > NickName: <input id="nkName" type="text" name="nikeName"></P>
    <textarea id="comArea" name="comtcontent" rows="6" cols="65"></textarea>
    <button id="addComs" type="button" myAttr="${UserPost._id}"> Add</button>
</div>
<hr/>
</body>
</html>