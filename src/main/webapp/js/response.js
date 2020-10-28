var imged = document.getElementById("pixelizated");

$(document).ready(function() {
    $('form').submit(function(event) {
        event.preventDefault();

        // Calling AJAX
        $.ajax({
            url : $(this).attr('action'),
            type : $(this).attr('method'),
            beforeSend: function(request) {
                request.setRequestHeader("Authority", "test");
            },
            data : new FormData(this),
            contentType : false,
            cache : false,
            processData : false,
            dataType: 'json',
            success : function(response) {
                console.log("YES");
                console.log(response);
                console.log(response.base64Image);
                imged.setAttribute("src", "data:image/jpg;base64,"+ response.base64Image)

            }
        });

        return false;
    });

});
