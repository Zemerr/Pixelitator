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
    </head>
    <body>
        <div class="head">
            <h1 style="color:#d7782f;">PIXELIZATOR ONLINE</h1>
        </div>
        <div style="width: 100%;">
            <div class="picone" style="width: 40%; float: left">
                <img id="myImage" class="pic" src="", alt="LOAD YOUR PHOTO">

            </div >
            <div class="pictwo" style="width: 40%; margin-left: 55%;">
            </div>
        </div>






<form action="upload" method="post" enctype="multipart/form-data" name="fileinfo">
    <div>
        <label for="image_uploads">Choose images to upload (PNG, JPG)</label>
        <input type="file" id="image_uploads" name="file" accept=".jpg, .jpeg, .png" multiple>
    </div>
    <div class="preview">
        <p>No files currently selected for upload</p>
    </div>
    <div>
        <button>Submit</button>
    </div>
</form>

<script src="js/script.js"></script>
    </body>
</html>
