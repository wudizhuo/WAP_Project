<!DOCTYPE html>
<!--Created by hongleyou on 2017/5/16.-->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Get google map position.</title>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
    <script type="text/javascript"src="map.js"></script>
</head>
<body onload="getSpecifiedLocation(<%= request.getParameter("longitude")%>,<%= request.getParameter("latitude")%>)">
<div id="map" style="width: 800px; height: 600px"></div>
</body>
</html>