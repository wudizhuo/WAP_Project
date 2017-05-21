/**
 * Created by yangyangli on 5/20/17.
 */
$(function () {
    $("#addComs").click(addComments);

});

function addComments(event) {
    event.preventDefault();
        $("#comArea").css({"backgroundColor" :"red"});
        var name = $("input[name='nikeName']").val();
        var comts = $("#comArea").val();
        $(".cmtname").text(name);
         $(".cmtcontext").text(comts);
    $.post("AddComsServlet", {
                               "name" : "name",
                               "comments":"comts"}).done(function(response) {
        if(response == "tue"){
            $(".comments").html($("#comArea").val()).fail(function() {
                console.log("Failed");
            });
        }

    })
}
