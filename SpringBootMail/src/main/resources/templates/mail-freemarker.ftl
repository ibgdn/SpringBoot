<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <title>mail-thymeleaf</title>
</head>
<body>
<div>hello ${username}，欢迎加入</div>
您的入职信息如下：
<table border="1">
    <tr>
        <td>职位</td>
        <td>${position}</td>
    </tr>
    <tr>
        <td>职称</td>
        <td>${joblevel}</td>
    </tr>
    <tr>
        <td>薪水</td>
        <td>${salary}</td>
    </tr>
    <tr>
        <td>部门</td>
        <td>${dep}</td>
    </tr>
</table>
<div style="color: #ff1a17; font-size: 20px">希望在未来的日子里，携手共进！</div>

</body>
</html>