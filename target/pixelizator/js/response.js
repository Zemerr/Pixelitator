var imged = document.getElementById("pixelizated");

$(document).ready(function() {
    $('form').submit(function(event) {
        event.preventDefault();

        // Calling AJAX
        $.ajax({
            url : $(this).attr('action'),
            type : $(this).attr('method'),
            beforeSend: function(request) {
                let str = document.getElementById('fileUploader').value.split('.');
                request.setRequestHeader("Authority", "test");
                request.setRequestHeader("Size", document.getElementById("inputNumber").value);
                request.setRequestHeader("Format", str[str.length - 1]);

            },
            data : new FormData(this),
            contentType : false,
            cache : false,
            processData : false,
            dataType: 'json',
            success : function(response) {
                imged.setAttribute("src", "data:image/jpg;base64,"+ response.base64Image)
                butjpg.disabled = false;
                butbmp.disabled = false;
                butpng.disabled = false;
                butjpg.style.opacity = 1;
                butpng.style.opacity = 1;
                butbmp.style.opacity = 1;
                console.log("allable");


            }
        });

        return false;
    });

});
