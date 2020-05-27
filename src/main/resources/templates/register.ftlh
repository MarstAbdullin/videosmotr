<!doctype html>
<#import "spring.ftl" as spring />
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="/js/validators.js"></script>
    <title>Registration</title>
</head>
<style>
    .error {
        color: #ff0000;
    }
</style>
<body>
<div align="center">
    <form action="/register" method="post">
        <h1>Registration</h1>
        <div class="form-group">
            <input type="email" name="email"
                   class="form-control"
                   placeholder="Email"
                   id="EmailForm"
                   oninput="validEmail()">
        </div>
        <div class="form-group">
            <input type="text"
                   name="username"
                   class="form-control"
                   placeholder="Username"
                   id="UsernameForm"
                   oninput="validUsername()">
        </div>
        <div class="form-group">
            <input type="password"
                   name="password"
                   class="form-control"
                   placeholder="Password"
                   onchange="validPassword()"
                   id="PasswordForm">
        </div>
        <div class="form-group">
            <input type="password"
                   class="form-control"
                   placeholder="Repeat password"
                   onchange="validPassword()"
                   id="RepeatPasswordForm">
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button type="submit" class="btn btn-warning">Register</button>
    </form>
    <a class="btn btn-primary"
       href="https://discord.com/api/oauth2/authorize?client_id=714485164281167895&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Fdiscord%2Fregister&response_type=code&scope=email%20identify%20connections%20guilds">Register
        by Discord</a>
    <form action="/register" method="post">
    <h1>Registration</h1>
    Email: <br>
    <@spring.formInput "registerForm.email"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Password: <br>
    <@spring.formInput "registerForm.password"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Username: <br>
    <@spring.formInput "registerForm.username"/>
    <@spring.showErrors "<br>","error"/>
    <br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <br>
    <input type="submit" value="Хотю зарегаться">
    </form>
</div>
</body>
</html>