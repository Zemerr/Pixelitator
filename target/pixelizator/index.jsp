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
    <title>File Upload</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
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

<script src="./script.js"></script>
</body>
</html>
