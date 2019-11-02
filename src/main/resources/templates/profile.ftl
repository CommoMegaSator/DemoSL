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
        Firstname:${user.getFirstname()}<br><hr>
        Lastname:${user.getLastname()}<br><hr>
        Nickname:${user.getNickname()}<br><hr>
        Email:${user.getEmail()}<br><hr>
        Age:${user.getAge()}<br><hr>
        Password:${user.getPassword()}<br><hr>
    </div>
    <div class="logOut" style="align-items: center;max-width: 50px;border: solid black">
        <a href="/logout">Logout</a>
    </div>
</#if>
</body>
</html>