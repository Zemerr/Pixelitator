var input = document.querySelector('input');
// var preview = document.querySelector('.preview');
var img = document.getElementById("myImage");
input.addEventListener('change', updateImageDisplay);

//input.style.opacity = 0;




function updateImageDisplay() {

    butjpg.disabled = true;
    butbmp.disabled = true;
    butpng.disabled = true;
    butjpg.style.opacity = 0;
    butpng.style.opacity = 0;
    butbmp.style.opacity = 0;
    imged.setAttribute("src", "#");

    var curFiles = input.files;
    if(curFiles.length === 0) {

    } else {
        for(var i = 0; i < curFiles.length; i++) {
            if(validFileType(curFiles[i])) {
                img.src = window.URL.createObjectURL(curFiles[i]);
            }
        }
    }
}

var fileTypes = [
    'image/jpeg',
    'image/pjpeg',
    'image/png'
]

function validFileType(file) {
    for(var i = 0; i < fileTypes.length; i++) {
        if(file.type === fileTypes[i]) {
            return true;
        }
    }

    return false;
}

function returnFileSize(number) {
    if(number < 1024) {
        return number + 'bytes';
    } else if(number > 1024 && number < 1048576) {
        return (number/1024).toFixed(1) + 'KB';
    } else if(number > 1048576) {
        return (number/1048576).toFixed(1) + 'MB';
    }
}

// function updateImageDisplay() {
//     butjpg.disabled = true;
//     butbmp.disabled = true;
//     butpng.disabled = true;
//     butjpg.style.opacity = 0;
//     butpng.style.opacity = 0;
//     butbmp.style.opacity = 0;
//     imged.setAttribute("src", null);
//     console.log("notallable");
//
// }

document.getElementById("inputNumber").addEventListener('mousemove', function () {
    document.getElementById("outNumber").textContent = document.getElementById("inputNumber").value
})