/**
 * Created by hongleyou on 5/21/17.
 */
var num = 1;
var flag = true;
$(function () {
    $(window).scroll(function () {
        event.preventDefault();
        if ($(window).scrollTop() >= $(document).height() * 0.9 && flag == true) {
            addPostDatas(num++);
            flag = false;
        }
    });
});

function addPostDatas(num) {
    $.ajax({
        url: 'PostMoreServlet',
        type: 'POST',
        data: {data:num},
        success: function (data) {
            console.log("------");
            console.log(data);
            $("#post_data").hide().fadeIn('fast');
            //console.log(data);
            // location.reload();
            flag = true;
        }
    });
}

