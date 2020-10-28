package world.ucode.model;

import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class Pixelizator {

    InputStream fileContent = null;
    String imageStr = null;
    Picures pic = null;
    BufferedImage img = null;
    byte[] bytes = null;


    public Pixelizator(Part filePart) throws IOException {
        fileContent = filePart.getInputStream();
        //byte[] imageBytes = new byte[(int)filePart.getSize()];
        if (fileContent != null) {
          //  fileContent.read(imageBytes, 0, imageBytes.length);
          //  fileContent.close();
            Pixlate();
            imageStr = Base64.encodeBase64String(bytes);
        }
        pic = new Picures();
        pic.setBase64Image(imageStr);
    }

    public Picures getPic() {
        return pic;
    }

    private void Pixlate() throws IOException {
        final int PIX_SIZE = 50;
        img = ImageIO.read(fileContent);


        Raster src = img.getData();


        WritableRaster dest = src.createCompatibleWritableRaster();

        for (int y = 0; y < src.getHeight(); y += PIX_SIZE) {
            for (int x = 0; x < src.getWidth(); x += PIX_SIZE) {
                // Copy the pixel
                double[] pixel = new double[4];
                pixel = src.getPixel(x, y, pixel);
                for (int yd = y; (yd < y + PIX_SIZE) && (yd < dest.getHeight()); yd++) {
                    for (int xd = x; (xd < x + PIX_SIZE) && (xd < dest.getWidth()); xd++) {
                        dest.setPixel(xd, yd, pixel);
                    }
                }
            }
        }
        img.setData(dest);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", baos);
        bytes = baos.toByteArray();
    }
}
