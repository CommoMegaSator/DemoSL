<!DOCTYPE html>
<html lang="en" >

<head>
    <meta charset="UTF-8">
    <title>Versatile Development</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="shortcut icon" href="/images/Versatile.ico" />
</head>

<body>
<div class="logimage"><img src="/images/Versatile.ico" alt=""></div>
<div id="boxForm">
    <h2 id="title">Nice to meet u)</h2>
    <form action="" method="POST" modelAttribute="user">
        <div class="logpass">
            <input type="text" class='sign-text' name="firstname" required placeholder="Enter your firstname" autocomplete="off" required>
            <input type="text" class='sign-text' name="lastname" required placeholder="Enter your lastname" autocomplete="off" required>
            <input type="text" class='sign-text' name="nickname" required placeholder="Enter your nickname" autocomplete="off" required>
            <input type="email" class='sign-text' name="email" required placeholder="Enter your email" autocomplete="off" required>
            <input type="number" class='sign-text' name="age" required placeholder="Enter your age" min="12" max="99" autocomplete="off" required>
            <input type="password" class='sign-text' id='pwd' name="password" required placeholder="Enter your password" autocomplete="off" required>
        </div>

        <div class="buttons">
            <input class='sing_submit shake' type='submit' value='Get acquainted'>
            <input class='familiar shake' type='button' value='<- Back' onclick="location.href='login';">
        </div>
    </form>
</div>

</body>

</html>