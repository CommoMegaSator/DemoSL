<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Users</title>
</head>
<body>
<div class="userinfo"><h3>
        <ol>
        <table border="1">
            <thead>
            <tr>
                <th>#</th>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Nickname</th>
                <th>Email</th>
                <th>Age</th>
                <th>Password</th>
            </tr>
            </thead>
        <#if (users)??>
            <#list users as user>
                <tr><td><li>
                    <td>${user.getFirstname()}</td>
                    <td>${user.getLastname()}</td>
                    <td>${user.getNickname()}</td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getAge()}</td>
                    <td>${user.getPassword()}</td></li></td>
                </tr>
            </#list>
        <#else>
        <#--                <script>alert("Has no users")</script>-->
        </#if></table></ol>
    </h3>
</div>
</body>
</html>