// getting location
window.onload = function() {
    if (navigator.geolocation) {
        var startPos;
        var lat;
        var long;
        var geoSuccess = function(position) {
            startPos = position;
            lat = startPos.coords.latitude;
            long = startPos.coords.longitude;
            
            var url1 = "http://api.openweathermap.org/data/2.5/weather?appid=2d1f9e63df3c55ec5baff678f275ebf9&mode=JSON&units=imperial&lat="+lat+"&lon="+long;
            $.getJSON( url1, function( data1 ) {
                var city_name = data1.name;
                var icon = "http://openweathermap.org/img/w/"+data1.weather[0].icon+".png";
                var temp = data1.main.temp;
                document.getElementById('jumbo-content').innerHTML = 'Weather in the city of '+city_name+'<br><img src="'+icon+'"/>&nbsp;&nbsp;'+temp+' &deg;F';
                
                document.getElementById('panel-head').innerHTML = 'Current in '+city_name;
                
                var pres = data1.main.pressure;
                var hum = data1.main.humidity;
                var min_temp = data1.main.temp_min;
                var max_temp = data1.main.temp_max;
                document.getElementById('pressure').innerHTML = pres+' atm';
                document.getElementById('humidity').innerHTML = hum+' %';
                document.getElementById('min-temp').innerHTML = min_temp+' &deg;F';
                document.getElementById('max-temp').innerHTML = max_temp+' &deg;F';
            });
            
            var url2 = "http://api.openweathermap.org/data/2.5/forecast?lat="+lat+"&lon="+long+"&appid=2d1f9e63df3c55ec5baff678f275ebf9&mode=JSON&units=imperial";
            $.getJSON( url2, function( data2 ) {
                var city = data2.city.name;
                document.getElementById('panel-hourly-head').innerHTML = 'Next 5 days in '+city;
                 
                var listArray = data2.list;
                
                // Next 5 days details
                var hourly_table = document.getElementById('5days-table');
                for (var i=0; i<listArray.length; i++) {
                    if (i % 3 == 0) {
                        var row = hourly_table.insertRow(-1);
                    }
                    var cell1 = row.insertCell(-1);
                    cell1.innerHTML = listArray[i].dt_txt;
                    var cell2 = row.insertCell(-1);
                    var icon_hourly = "http://openweathermap.org/img/w/"+listArray[i].weather[0].icon+".png";
                    cell2.innerHTML = '<img src="'+icon_hourly+'"/>&nbsp;&nbsp;'+listArray[i].main.temp+' &deg;F';
                }
            });
            

                      
        };
        navigator.geolocation.getCurrentPosition(geoSuccess); 
    } else {
        document.getElementById('jumbo-content').innerHTML = "Geolocation is not supported by this browser.";
    }
    
}

var saved_search = "";
saved_search = '<div class="panel panel-primary">';
saved_search += '<div class="panel-heading" id="panel-ss-head">Recent Searches</div>';
saved_search += '<div class="panel-body" id="panel-ss-content">';
saved_search += '</div></div>';


$("#search-form").submit(function searchFunction(e) {
    e.preventDefault();
    var term = document.getElementById('search-term').value;

    var url1 = "http://api.openweathermap.org/data/2.5/weather?appid=2d1f9e63df3c55ec5baff678f275ebf9&mode=JSON&units=imperial&q="+term+",us";
    $.getJSON( url1, function( data1 ) {
        var city_name = data1.name;
        var icon = "http://openweathermap.org/img/w/"+data1.weather[0].icon+".png";
        var temp = data1.main.temp;
        document.getElementById('jumbo-content').innerHTML = 'Weather in the city of '+city_name+'<br><img src="'+icon+'"/>&nbsp;&nbsp;'+temp+' &deg;F';

        document.getElementById('panel-head').innerHTML = 'Current in '+city_name;

        var pres = data1.main.pressure;
        var hum = data1.main.humidity;
        var min_temp = data1.main.temp_min;
        var max_temp = data1.main.temp_max;
        document.getElementById('pressure').innerHTML = pres+' atm';
        document.getElementById('humidity').innerHTML = hum+' %';
        document.getElementById('min-temp').innerHTML = min_temp+' &deg;F';
        document.getElementById('max-temp').innerHTML = max_temp+' &deg;F';
    });

    var url2 = "http://api.openweathermap.org/data/2.5/forecast?q="+term+",us&appid=2d1f9e63df3c55ec5baff678f275ebf9&mode=JSON&units=imperial";
    $.getJSON( url2, function( data2 ) {
        var city = data2.city.name;
        document.getElementById('panel-hourly-head').innerHTML = 'Next 5 days in '+city;

        var listArray = data2.list;

        // hourly details
        document.getElementById('5days-table').innerHTML="";
        var hourly_table = document.getElementById('5days-table');
        for (var i=0; i<listArray.length; i++) {
            if (i % 3 == 0) {
                var row = hourly_table.insertRow(-1);
            }
            var cell1 = row.insertCell(-1);
            cell1.innerHTML = listArray[i].dt_txt;
            var cell2 = row.insertCell(-1);
            var icon_hourly = "http://openweathermap.org/img/w/"+listArray[i].weather[0].icon+".png";
            cell2.innerHTML = '<img src="'+icon_hourly+'"/>&nbsp;&nbsp;'+listArray[i].main.temp+' &deg;F';
        }
    });
    
    
    // saving searches
    var save_search_button = "";
    if(typeof(Storage) !== "undefined") {

		localStorage.setItem("searchTerm",term);
        save_search_button = '<button class="btn btn-primary" id="search" onclick="searchFunction()">'+localStorage.getItem("searchTerm")+'</button>';
    }
        document.getElementById("saved-search").innerHTML = saved_search;
        document.getElementById("panel-ss-content").innerHTML += save_search_button;
 
});
