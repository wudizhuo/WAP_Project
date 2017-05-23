<form id="post_page" method="post" action="map.jsp">
    <p class="post_name">"${UserPost.getName()}"</p>
    <p class="post_content">"${UserPost.getContent()}"</p>
    <p class="post_like">"${UserPost.getLike()}"
        <button id="addLike" class="addLike" type="button" myAttr="${UserPost._id}">Like</button>
        <button id="deleteLike" class="deleteLike" type="button" myAttr="${UserPost._id}">Delete</button>
    </p>
    <c:forEach items="${UserPost.getImages()}" var="image">
        <img class="post_image" id="images" src="${image}" alt="image">
    </c:forEach>
    <input id="longitude" type="hidden" name="longitude" value="${UserPost.getLocation().getLongitude()}">
    <input id="latitude" type="hidden" name="latitude" value="${UserPost.getLocation().getLatitude()}">
    <p>
        <button id="getLocation" type="submit"
                class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">Get localtion
        </button>
    </p>
</form>
<%@include file="CommentSub.jsp" %>