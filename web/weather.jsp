<!DOCTYPE html>
<html lang="en">
    
    <head>
        <meta charset="utf-8">
 		<meta http-equiv="X-UA-Compatible" content="IE=edge">
 		<meta name="viewport" content="width=device-width, initial-scale=1">
        <title>WAP Project - Weather</title>
        
        <!-- Bootstrap -->
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- Material Design Lite -->
        <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
        <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
        <!-- Material Design icon font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link href="CSS/dashboard.css" type="text/css" rel="stylesheet"/>
        
        <!-- Custome CSS -->
        <link rel="stylesheet" href="CSS/weather.css">
    </head>
    
    <body>
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
    <header class="mdl-layout__header" id="head">
        <div class="mdl-layout__header-row">
            <!-- Title -->
            <span class="mdl-layout-title">WAP Project</span>
            <div class="container">
                <div class="navbar-header">
                    <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#head">Current time</a></li>
                        <li><a href="#hourly">Next 5 days</a></li>
                    </ul>

                    <form class="navbar-form navbar-right" id="search-form">
                        <div class="form-group">
                            <input type="text" placeholder="Enter Location" class="form-control" id="search-term"/>
                        </div>
                        <button type="submit" class="btn btn-primary" id="search">Get Weather</button>
                    </form>
                </div>
            </div>
        </div>
    </header>


        
        <div class="container content" id="home">
            <header class="jumbotron hero-spacer jumbo">
                <h2 id="jumbo-content">Fetching your location</h2>
            </header>
            <div class="panel panel-primary">
                <div class="panel-heading" id="panel-head">Current in</div>
                <div class="panel-body" id="panel-content">
                    <table class="table table-striped table-bordered">
                        <tr>
                            <td>Pressure</td>
                            <td id="pressure">NA</td>
                        </tr>
                        <tr>
                            <td>Humidity</td>
                            <td id="humidity">NA</td>
                        </tr>
                        <tr>
                            <td>Min Temperature</td>
                            <td id="min-temp">NA</td>
                        </tr>
                        <tr>
                            <td>Max Temperature</td>
                            <td id="max-temp">NA</td>
                        </tr>
                    </table>
                </div>
            </div>
            <div id="saved-search"></div>
        </div>
        
        <div class="container content" id="hourly"><br>
            <a href="#head">Back to current</a>
            <div class="panel panel-primary" id="hourly-panel">
                <div class="panel-heading" id="panel-hourly-head">Next 5 days in</div>
                <div class="panel-body" id="panel-hourly-content">
                    <table class="table table-striped table-bordered text-center" id="5days-table">
                    </table>
                </div>
            </div>
        </div>
        

        
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

        <!-- Latest compiled Bootstrap JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
        <script type="text/javascript" src="js/weather.js"></script>

    <div class="mdl-layout__drawer">
        <span class="mdl-layout-title">WAP Project</span>
        <nav class="mdl-navigation">
            <a class="mdl-navigation__link" href="./DashBoard.jsp">All post</a>
            <a class="mdl-navigation__link" href="./createPost.jsp">Create</a>
            <a class="mdl-navigation__link" href="./weather.jsp">Weather</a>
            <a class="mdl-navigation__link" href="./UserProfile.jsp">User Profile</a>
        </nav>
    </div>

        <script>

            $(".content").css("min-height",$(window).height());

        </script>
    </div>
    </body>
    
</html>