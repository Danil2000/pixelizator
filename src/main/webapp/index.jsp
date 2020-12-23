<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
</head>
<body>
    <h1>Pixelizator</h1>
    <p>Вберите изображение</p>
    <div class="box">
        <label class="headers">Load image</label>
        <input id="file" class="buttons" type="file">
        <label>Pixel scale</label>
        <input type="range" id="volume" name="volume"
               min="1" max="50" onchange="setLblValue()">
        <label id="lblValue" for="volume"></label>
        <input id="fileClear" class="buttons" type="button" value="send" onclick="send()">
    </div>

    <script src="js/form.js"></script>
    <img id="imgAltered" alt="" src="" style="transform: rotateZ(90deg) scale(1,-1);">
    <div id="info">
        <label id="size"></label> <br>
        <label id="sizePicture"> </label>
    </div>

    <div id = "download">
        <a id="linkDownload" href="" download="pixel.jpeg">.jpeg</a>
<%--        <a id="linkDownloadimg" href="" download="pixel.img">.img</a>--%>
    </div>
</body>
</html>
