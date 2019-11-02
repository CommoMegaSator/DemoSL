<#import "/spring.ftl" as spring/>
<#setting locale="en">
<!DOCTYPE html>
<html lang="en" >

<head>
    <meta charset="UTF-8">
    <title>Versatile Development</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="shortcut icon" href="/images/Versatile.ico" />
</head>

<body>
<div class="logimage"><img src="/images/Versatile.ico" alt="dont working now"></div>
<div id="boxForm">
    <h2 id="title"><span class="Versatile">Versatile</span> is waiting for u)</h2>
    <form method="post">
        <div class="logpass">
            <input class='sign-text' type='text' name='nickname' placeholder='Login' autocomplete="off" >
            <input class='sign-text' type='password' name="password" id='pwd'  placeholder='Password' required minlength="6" maxlength="23"><!--  oninvalid="this.setCustomValidity('Invalid password')"> -->
            <label class="container"><span class="remember">Can we remember u?</span>
<#--                <@spring.messageText "login.remember", "login.remember"/>-->
                <input type="checkbox" id="rememberMe">
                <span class="checkmark"></span>
            </label>
        </div>

        <div class="buttons">
            <input class='sing_submit shake' type='submit' value='Come in'>
            <input class='familiar shake' type='button' value='Not familiar?' onclick="location.href='registration';">
        </div>
    </form>
</div>

</body>

</html>