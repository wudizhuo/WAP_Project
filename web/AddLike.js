/**
 * Created by yangyangli on 5/21/17.
 */
$(function () {
    $(".addLike").click(addLike);
});
function addLike() {
var myPostId = $(this).attr("myAttr");
alert(myPostId);
var jsonStrLike = {
        "postId": myPostId,
    };

    $.ajax({
        url: 'LikeServlet',
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


// $.ajax({
//         url: 'LikeServlet',
//         type: 'POST',
//         dataType: 'text json',
//         contentType: 'application/json; charset=utf-8',
//         data: JSON.stringify(json_LikeStr),
//     success: function (data) {
//         callback(data);
//     },
//     error: function (data) {
//         callback(data);
//     }
// });
//
//     var callback = function (data) {
//         if (data.status == 200) {
//             location.reload();
//         } else {
//             alert("fail");
//         }
//     };
// }