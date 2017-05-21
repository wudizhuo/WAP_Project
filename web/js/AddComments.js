/**
 * Created by yangyangli on 5/20/17.
 */
$(function () {
    $("#addComs").click(addComments);

});

function addComments(event) {
    event.preventDefault();
    $("#comArea").css({"backgroundColor" :"red"});
    $.post("AddComsServlet", {"comments":$("comArea").text()}).done(function(response) {
        if(response == "true"){
            // alert($("#comArea").val());
            $(".comments").html($("#comArea").val()).fail(function() {
                console.log("Failed");
            });
        }

    })
}
