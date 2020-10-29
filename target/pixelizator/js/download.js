let butjpg = document.getElementById("downjpg");
let butpng = document.getElementById("downpng");
let butbmp = document.getElementById("downbmp");
let imgpix = document.getElementById("pixelizated");

butjpg.style.opacity = 0;
butpng.style.opacity = 0;
butbmp.style.opacity = 0;

butjpg.addEventListener('click', () => {
    document.getElementById("downloadLinkjpg").href = imgpix.src;
    document.getElementById("downloadLinkjpg").click();
})

butpng.addEventListener('click', () => {
    document.getElementById("downloadLinkpng").href = imgpix.src;
    document.getElementById("downloadLinkpng").click();
})

butbmp.addEventListener('click', () => {
    document.getElementById("downloadLinkbmp").href = imgpix.src;
    document.getElementById("downloadLinkbmp").click();
})
