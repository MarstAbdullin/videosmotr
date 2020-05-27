<!doctype html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form action="/login" method="post">
        <h1>Login</h1>
        <br>
        <input type="email" name="email" placeholder="Email">
        <br>
        <input type="password" name="password" placeholder="Password">
        <br>
        <label>
            <input type="checkbox" name="remember me">Запомни меня пж
        </label>
        <input type="submit" value="Хотю зайти">
    </form>
    <a class="btn btn-primary" href="https://discord.com/api/oauth2/authorize?client_id=714485164281167895&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Fdiscord%2Fauth&response_type=code&scope=identify%20email%20connections%20guilds">Login by Discord</a>
</div>
</body>
</html>