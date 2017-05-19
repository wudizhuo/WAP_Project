<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="./CSS/login.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <title>Login Page</title>
    <link href="../CSS/login.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<a href="signup.jsp" id="signup">SignUp</a>

<p id="logintext">"life is short and you deserve to be happy."</p>

<form id="loginform" action="/login" method="post">
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <input class="mdl-textfield__input" type="text" id="name" name="username">
        <label class="mdl-textfield__label" for="name">Username</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <input class="mdl-textfield__input inline" type="password" id="pd" name="password">
        <label class="mdl-textfield__label" for="pd">Password</label>
    </div>
    <div id="submitcontainer">
        <br/>
        <input id="but" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect" type="submit"
               value="Login"/>
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