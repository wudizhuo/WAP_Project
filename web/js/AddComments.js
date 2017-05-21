/**
 * Created by yangyangli on 5/20/17.
 */
$(function () {
    $("#addComs").click(addComments);

});

function addComments(event) {
    event.preventDefault();
    var comt = $("#comArea").val();
    var myPostId = $(this).attr("myAttr");
    var jsonStr = {
        "postId": myPostId,
        "content": comt,
    };
    $.ajax({
        url: 'ComtServlet',
        type: 'post',
        dataType: 'text json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(jsonStr),
        success: callback,
        error: callback,
    });

    var callback = function (data) {
        if (data.status == 200) {
            $(".cmtname").text(comtname);
            $(".cmtcontext").text(comt);
        } else {
            alert("Fail");
        }
    };
}
