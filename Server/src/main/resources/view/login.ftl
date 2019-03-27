<html xmlns="http://www.w3.org/1999/xhtml" content="text/html;" lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div>
    <form action="/login" method="post">
        Name:<input type="text" name="name"/><br/>
        Password:<input type="password" name="password"/><br/>

        <input type="submit" value="login">
        <p><#if message??>${message}</#if></p>
    </form>
</div>
</body>
</html>