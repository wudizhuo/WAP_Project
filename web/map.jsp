<!DOCTYPE html>
<!--Created by hongleyou on 2017/5/16.-->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Get google map position.</title>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
    <script type="text/javascript"src="js/map.js"></script>
    <link href="../CSS/map.css" type="text/css" rel="stylesheet"/>
</head>
<body onload="getSpecifiedLocation(<%= request.getParameter("longitude")%>,<%= request.getParameter("latitude")%>)">
<div id="map"></div>
</body>
</html>