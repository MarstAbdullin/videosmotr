<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Отправка файлов в HTML5</title>
</head>
<body>
<form enctype="multipart/form-data" method="post" action="/adminka">
    <p>
        <input type="file" name="video" placeholder="add video"/>
    </p>
    <p>
        <input type="file" name="preview" placeholder="add preview"/>
    </p>
    <p>
        <input type="text" name="videoName" placeholder="write video name"/>
    </p>
    <p>
        <input type="text" name="description" placeholder="description to video"/>
    </p>
    <p>
        <input type="submit" value="Отправить" />
    </p>
</form>
<br>
<form method="post" action="/adminka">
    <p>
        <input type="text" name="category" />
    </p>
    <p>
        <input type="submit" value="Отправить" />
    </p>
</form>
<br>
<form method="post" action="/adminka">
    <p>
        <input type="number" name="userId" placeholder="write user id to delete"/>
    </p>
    <p>
        <input type="submit" value="Отправить" />
    </p>
</form>
<br>
<form method="post" action="/adminka">
    <p>
        <input type="number" name="videoId" placeholder="write video id to delete"/>
    </p>
    <p>
        <input type="submit" value="Отправить" />
    </p>
</form>
</body>
</html>