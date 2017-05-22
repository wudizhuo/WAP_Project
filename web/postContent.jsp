<c:forEach items="${posts}" var="UserPost">
    <form id="post_page" method="post" action="map.jsp">
        <p>"${UserPost.getImages().size()}"</p>
        <p>"${UserPost.getName()}"</p>
        <p>"${UserPost.getContent()}"</p>
        <c:forEach items="${UserPost.getImages()}" var = "image">
            <img id = "images" src="${image}" alt="image">
        </c:forEach>
        <p>"${UserPost.getLike()}"
            <button id="addLike" type="button" myAttr="${UserPost._id}">Like</button>
            <button class="deleteLike" type="button" myAttr="${UserPost._id}">Delete</button>
        </p>
            <%--<p><img id="image" src="${UserPost.getImage()}" alt="image"/></p>--%>
        <input type="hidden" name="longitude" value="${UserPost.getLocation().getLongitude()}">
        <input type="hidden" name="latitude" value="${UserPost.getLocation().getLatitude()}">
        <p>
            <button id="getLocation" type="submit"
                    class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">Get localtion
            </button>
        </p>
    </form>
    <%@include file="CommentSub.jsp" %>
</c:forEach>