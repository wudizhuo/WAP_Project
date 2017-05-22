/**
 * Created by hatc1 on 5/21/2017.
 */
navigator.geolocation.getCurrentPosition(success, fail);

function success(position) {
    console.log('Longitude:' + position.coords.longitude );
    console.log('Latitude:' + position.coords.latitude );
}

function fail(msg) {
    console.log(msg.code + msg.message); // Log the error
}