<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="./CSS/material.min.css">
    <link rel="stylesheet" href="./CSS/login.css">
    <script src="./CSS/material.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

    <title>Login Page</title>
    <link href="../CSS/login.css" type="text/css" rel="stylesheet"/>
</head>
<body>

<p id="logintext">"life is short and you deserve to be happy."</p>

<form id="loginform" action="/login" method="post">
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <input class="mdl-textfield__input" type="text" id="name">
        <label class="mdl-textfield__label" for="name">Username</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <input class="mdl-textfield__input inline" type="text" id="pd">
        <label class="mdl-textfield__label" for="pd">Password</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <input id="but" type="submit" value="Login"/>
    </div>
</form>

<%--<form  id="loginform" action="/login" method="post">--%>
    <%--Username: <input class="inline"type="text" name="username"/>--%>
    <%--Password: <input class="inline" type="password" name="password"/>--%>
    <%--<input id="but" class="inline" type="submit" value="Login"/>--%>
<%--</form>--%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>

</body>
</html>