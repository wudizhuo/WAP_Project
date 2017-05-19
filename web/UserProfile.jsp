<%@ page import="com.wap.user.User" %>
<html>
<head>
    <title>User Profile</title>
    <!-- Material Design Lite -->
    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
    <!-- Material Design icon font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link href="CSS/UserProfile.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="content">
    <%
        User user = (User) session.getAttribute("User");
    %>
    <form id="profile" action="userprofile" method="post">
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label one-line">
            <input class="mdl-textfield__input" type="text" id="sample3" name="UserName" value="<%=user.getName()%>">
            <label class="mdl-textfield__label" for="sample3">UserName</label>
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label one-line">
            <input class="mdl-textfield__input" type="text" pattern="(?=\d+)(?=[az]*)(?=[A-Z]*).{6,}" id="sample4"
                   name="Password"
                   value="<%=user.getPassword()%>">
            <label class="mdl-textfield__label" for="sample4">Password</label>
            <span class="mdl-textfield__error">Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters</span>
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label one-line">
            <input class="mdl-textfield__input" type="text" id="Gender" name="Gender" value="<%=user.getGender()%>">
            <label class="mdl-textfield__label" for="Gender">Gender</label>
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label one-line">
            <input class="mdl-textfield__input" type="text" id="State" name="State" value="<%=user.getState()%>">
            <label class="mdl-textfield__label" for="State">State</label>
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label one-line">
            <input class="mdl-textfield__input" type="text" id="City" name="City" value="<%=user.getCity()%>">
            <label class="mdl-textfield__label" for="City">City</label>
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label one-line">
            <input class="mdl-textfield__input" type="text" id="Street" name="Street" value="<%=user.getState()%>">
            <label class="mdl-textfield__label" for="Street">Street</label>
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label one-line">
            <input class="mdl-textfield__input" type="number" id="Zipcode" name="Zipcode" value="<%=user.getZip()%>">
            <label class="mdl-textfield__label" for="Zipcode">Zip code</label>
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label one-line">
            <input class="mdl-textfield__input" type="number" id="Birthyear" name="BirthYear"
                   value="<%=user.getBirthyear()%>">
            <label class="mdl-textfield__label" for="BirthYear">Birth Year</label>
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label one-line">
            <input class="mdl-textfield__input" type="email" id="email" name="email" value="<%=user.getEmail()%>">
            <label class="mdl-textfield__label" for="email">Email</label>
        </div>
        <button class="mdl-button mdl-js-button mdl-button--raised">
            Save
        </button>
    </form>
</div>
</body>
</html>