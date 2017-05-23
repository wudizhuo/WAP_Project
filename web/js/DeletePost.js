/**
 * Created by yangyangli on 5/21/17.
 */
$(function () {
    $(".deleteLike").click(deleteLike);
});
function deleteLike() {
var myPostId = $(this).attr("myAttr");
var jsonStrLike = {
        "postId": myPostId,
    };
    $.ajax({
        url: 'DeletePostServlet',
        type: 'POST',
        dataType: 'text json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(jsonStrLike),
        success: function (data) {
            callback(data);
        },
        error: function (data) {
            callback(data);
        }
    });

    var callback = function (data) {
        if (data.status == 200) {
            location.reload();
        } else {
            alert("fail");
        }
    };
}


