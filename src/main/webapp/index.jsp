<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Pixelizator</h1>
    <p>Вберите изображение</p>

    <form id="form" method="post" enctype="multipart/form-data" action="#">
        <input type="file" name="file" />
        <input type="submit" onchange="show()" />
    </form>
    <script src="js/form.js"></script>
    <img src="http://localhost:8080/pixelizator_war/upload" alt="">
</body>
</html>
