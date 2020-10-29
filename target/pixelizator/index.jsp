<%--
  Created by IntelliJ IDEA.
  User: ostanislav
  Date: 10/19/20
  Time: 10:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <title>Pixelizator</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    </head>
    <body>
        <div class="head">
            <h1 style="color:#d7782f;">PIXELIZATOR ONLINE</h1>
        </div>
        <form action="upload" method="post" enctype="multipart/form-data" name="fileinfo" id="submitform" class="forform">
            <div>
                <label class="forformelem " name="UPLOAD" for="fileUploader">Choose images to upload (PNG, JPG)</label>
                <input type="file" value="upload" id="fileUploader" name="file" accept=".jpg, .jpeg, .png">
            </div>
            <br>
            <div>
                <input type="range" class="choiceNumber" id="inputNumber" min="1" max="100"  value="10">
            </div>

            <p class="text">Block size: </p>
            <p class="text" id="outNumber">10</p>
            <div>
                <button class="button">Submit</button>
            </div>
        </form>
        <div style="width: 100%;">
            <div class="picone" style="width: 30%; float: left">
                <img id="myImage" class="pic" src="", alt="LOAD YOUR PHOTO">
            </div >
            <div id="myImagepix" class="pictwo" style="width: 30%; margin-left: 60%;">
                <img id="pixelizated" class="pic" src="", alt="PIXALIZATED PHOTO">
            </div>
        </div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div class="forform">
            <a href="#" id="downloadLinkjpg" download="pixImage.jpg"></a>
            <button disabled="disabled" id="downjpg" class="button">Download<br>JPG</button>

            <a href="#" id="downloadLinkpng" download="pixImage.png"></a>
            <button disabled="disabled" id="downpng" class="button">Download<br>PNG</button>

            <a href="#" id="downloadLinkbmp" download="pixImage.bmp"></a>
            <button disabled="disabled" id="downbmp" class="button">Download<br>BMP</button>
        </div>




        <script src="js/script.js"></script>
        <script src="js/response.js"></script>
        <script src="js/download.js"></script>
    </body>
</html>
