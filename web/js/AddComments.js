/**
 * Created by yangyangli on 5/20/17.
 */
$(function () {
    $("#addComs").click(addComments);

});

function addComments(event) {
    //event.preventDefault();

    alert($("#comArea").val());
        $("#comArea").css({"backgroundColor" :"red"});
        var comtname = $("input[name='nikeName']").val();
        var comts = $("#comArea").val();

    var myPostId = $(this).attr("myAttr");
    alert("var = " + myPostId);


    $.post("ComtServlet", {
                               "name" : comtname,
                               "comments":comts,
                              }
                   )
        .done(function() {
            $(".cmtname").text(comtname);
            $(".cmtcontext").text(comts);
        })
        .fail()
}
