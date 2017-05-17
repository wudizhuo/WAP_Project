/**
 * Created by hongleyou on 2017/5/16.
 */
function getCurrentLocation() {
    if (navigator.geolocation) {
        //get current position
        navigator.geolocation.getCurrentPosition(function (position) {
                var coords = position.coords;
                //console.log(position);
                //you can use latitude and longitude to set position yourself.
                var latlng = new google.maps.LatLng(coords.latitude, coords.longitude);
                var myOptions = {
                    zoom: 18,    //the number controls the magnification.
                    center: latlng,  //Set the map center by using specify the coordinates of the point.
                    mapTypeId: google.maps.MapTypeId.ROADMAP //Set the map type.
                };
                //Create map.
                var map = new google.maps.Map(document.getElementById("map"), myOptions);
                //Mark the map.
                var marker = new google.maps.Marker({
                    position: latlng,    //Mark the set point.
                    map: map
                });
                //Mark window info.
                var infoWindow = new google.maps.InfoWindow({
                    content: "current location:<br/>longitude:" + latlng.lat() + "<br/>latitude:" + latlng.lng()
                });
                //open window info.
                infoWindow.open(map, marker);
            },
            function (error) {
                switch (error.code) {
                    case 1:
                        alert("Location service is denied.");
                        break;
                    case 2:
                        alert("Can't get location information temporarily.");
                        break;
                    case 3:
                        alert("time out.");
                        break;
                    default:
                        alert("Unknow error.");
                        break;
                }
            });
    } else {
        alert("Your browser does not support HTML 5 to get the geographic location information.");
    }
}

function getSpecifiedLocation(latitude, longitude) {
    var latlng = new google.maps.LatLng(latitude, longitude);

    var map = new google.maps.Map(document.getElementById('map'), {
        center: latlng,
        zoom: 18
    });

    var marker = new google.maps.Marker({
        position: latlng,    //Mark the set point.
        map: map
    });
    //Mark window info.
    var infoWindow = new google.maps.InfoWindow({
        content: "current location:<br/>longitude:" + latlng.lat() + "<br/>latitude:" + latlng.lng()
    });
    //open window info.
    infoWindow.open(map, marker);
}