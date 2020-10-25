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
        <div style="width: 100%;">
            <div class="picone" style="width: 40%; float: left">
                <img id="myImage" class="pic" src="", alt="LOAD YOUR PHOTO">
            </div >
            <div class="pictwo" style="width: 40%; margin-left: 55%;">
                <img id="pixelizated" class="pic" src="", alt="PIXALIZATED PHOTO">
            </div>
        </div>






<form action="upload" method="post" enctype="multipart/form-data" name="fileinfo" id="submitform">
<%--    <div>--%>
        <label for="fileUploader">Choose images to upload (PNG, JPG)</label>
        <input type="file" id="fileUploader" name="file" accept=".jpg, .jpeg, .png" multiple required>
<%--    </div>--%>
    <div class="preview">
        <p>No files currently selected for upload</p>
    </div>
    <div>
        <button>Submit</button>
    </div>
</form>

<script src="js/script.js"></script>
    <script src="js/response.js"></script>
    </body>
</html>
