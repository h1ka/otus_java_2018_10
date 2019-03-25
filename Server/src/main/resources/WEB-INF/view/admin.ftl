<html xmlns="http://www.w3.org/1999/xhtml" content="text/html;" lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Admin page</title>
</head>
<body>
<!--<div>Hello admin</div>-->
    <#--<div><#list users as user>-->
            <#--<p>ID : ${user.id}</p>-->
            <#--</br>-->
            <#--<p>Name : ${user.name}</p>-->
            <#--</br>-->
            <#--<p>Age : ${user.age}</p>-->
        <#--<#else>-->
        <#--<p>No users</p>-->
    <#--</#list>-->

        <table border=1>
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Age</td>
            </tr>
            <#list users as user>

            <tr>
                <td>${user.id} ID
                <td>${user.name}
                <td>${user.age} Age


            </tr>
            </#list>
        </table>
</div>

<div>
    <form action="admin" method="post">
        Id : <input type="text" name="id">
        Name : <input type="text" name="name">
        Age : <input type="text" name="age">
        <input type="submit" name="send">
    </form>
</div>
</body>
</html>