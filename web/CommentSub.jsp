<div class="commentsstype">
    <c:forEach var="Post_comments" items="${UserPost.comments}">
        <div>
            <span class="cmtnamestyle">${Post_comments.name} </span>:
            <span class="cmtcontstyle">${Post_comments.comment}</span>
        </div>
    </c:forEach>
</div>
<%--<div id="'cmtname'+${UserPost._id}"></div>--%>
<%--<br/>--%>
<%--<div id="'cont'+${UserPost._id}"></div>--%>
<div>
    <textarea id="${UserPost._id}" name="comtcontent" rows="6" cols="65"></textarea>
    <button class="addComs" type="button" myAttr="${UserPost._id}"> Add</button>
</div>
<hr/>