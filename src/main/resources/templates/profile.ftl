<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Users</title>
</head>
<body>
<#if (user)??>
    <div>
        <hr>
        Firstname:${user.getFirstname()}<hr>
        Lastname:${user.getLastname()}<hr>
        Nickname:${user.getNickname()}<hr>
        Email:${user.getEmail()}<hr>
        Age:${user.getAge()}<hr>
        Password:${user.getPassword()}<hr>
    </div>
    <div class="logOut" style="align-items: center;max-width: 50px;border: solid black">
        <a href="/logout">Logout</a>
    </div>
</#if>
</body>
</html>