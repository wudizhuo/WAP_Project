$(function () {
  setInterval(getNotification, 3000);

  function getNotification() {
    $.get("/notification", function (data) {
      if (data === 'true') {
        alert("You have new posts lol");
        changeNotification();
        location.reload();
      }
    });
  }

  function changeNotification() {
    $.post("/notification", function (data) {
      console.log(data);
    });
  }
});