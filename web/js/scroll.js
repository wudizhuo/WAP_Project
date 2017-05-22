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
  $.ajax({
    url: 'PostMoreServlet',
    type: 'POST',
    data: {data: num},
    success: function (data) {
      callback(data);
    },
    error: function (data) {
      callback(data);
    }
  });

  var callback = function (data) {
    isLoading = false;
    if (data.status === 200) {
      console.log("------");
      console.log(data);
      $("#post_data").hide().fadeIn('fast');
      //console.log(data);
      // location.reload();
    } else {
      alert("fail");
    }
  };
}

