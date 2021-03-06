<html>
<head>
    <!-- Material Design Lite -->
    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
    <!-- Material Design icon font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link href="CSS/dashboard.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/map.js"></script>
    <script src="js/scroll.js"></script>
    <script type="text/javascript" src="js/AddComments.js"></script>
    <script type="text/javascript" src="js/AddLike.js"></script>
    <script type="text/javascript" src="js/DeletePost.js"></script>
    <script type="text/javascript" src="js/dashboard.js"></script>
    <link href="CSS/postData.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<!-- Always shows a header, even in smaller screens. -->
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
    <header class="mdl-layout__header">
        <div class="mdl-layout__header-row">
            <!-- Title -->
            <span class="mdl-layout-title">WAP Project</span>
        </div>
    </header>
    <div class="mdl-layout__drawer">
        <span class="mdl-layout-title">WAP Project</span>
        <nav class="mdl-navigation">
            <a class="mdl-navigation__link" href="./createPost.jsp">Create</a>
            <a class="mdl-navigation__link" href="./weather.jsp">Weather</a>
            <a class="mdl-navigation__link" href="./UserProfile.jsp">User Profile</a>
        </nav>
    </div>
    <main class="mdl-layout__content">
        <div class="page-content">
            <%@ include file="Posts.jsp" %>
        </div>
    </main>
</div>
</body>
</html>