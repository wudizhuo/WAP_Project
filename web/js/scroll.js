var num = 1;
var isLoading = false;
$(function () {
  $(".post_data").scroll(function () {
    if (($(this).scrollTop() + $(this).height() === $(this)[0].scrollHeight)) {
      if (isLoading) {
        alert("Application is Loading...")
      } else {
        isLoading = true;
        addPostDatas(num++);
      }
    }
  });
});

function addPostDatas(num) {
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
    if (data === "no more data") {
      alert("no more data");
    } else {
      handleData(data);
    }
  };

  var handleData = function (datas) {
    $.each(datas, function (key, data) {
      $.get("postContent.jsp", function (html) {
        $(".post_data").append(html);
        setData(data);
      });
    });
  };

  function setData(data) {
    var c = document.getElementsByClassName("post_name");
    c[c.length - 1].innerHTML = data.name;

    var c = document.getElementsByClassName("post_content");
    c[c.length - 1].innerHTML = data.content;

    var c = document.getElementsByClassName("post_like");
    c[c.length - 1].innerHTML = data.like;

    var c = document.getElementsByClassName("post_image");
    c[c.length - 1].src = data.images[0];
  }
}

