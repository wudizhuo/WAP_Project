var num = 1;
var isLoading = false;
$(function () {
  $("#post_data").scroll(function () {
    if (($(this).scrollTop() + $(this).height() == $(this)[0].scrollHeight) && !isLoading) {
      isLoading = true;
      addPostDatas(num++);
    }
  });
});

function addPostDatas(num) {
  console.log("---addPostDatas---");

  var jsonStr = {
    more: num
  };

  $.ajax({
    dataType: 'text json',
    contentType: 'application/json; charset=utf-8',
    url: 'PostMoreServlet',
    type: 'POST',
    data: JSON.stringify(jsonStr),
    success: function (data) {
      callback(data);
    },
    error: function (data) {
      callback(data);
    }
  });

  var callback = function (data) {
    isLoading = false;
    console.log("------");
    console.log(data);
    if (data.status === 200) {
      $("#post_data").hide().fadeIn('fast');
      //console.log(data);
      // location.reload();
    } else {
      alert("fail");
    }
  };
}

