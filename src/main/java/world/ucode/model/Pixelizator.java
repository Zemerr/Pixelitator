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

    private InputStream fileContent = null;
    private String imageStr = null;
    private Picures pic = null;
    private BufferedImage img = null;
    private byte[] bytes = null;
    private int pixsize = 1;
    private String format;


    public Pixelizator(Part filePart, String pixsize, String format) throws IOException {
        fileContent = filePart.getInputStream();
        this.format = format;
        this.pixsize = Integer.parseInt(pixsize);


        if (fileContent != null) {
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
        img = ImageIO.read(fileContent);
        Raster src = img.getData();
        WritableRaster dest = src.createCompatibleWritableRaster();

        for (int y = 0; y < src.getHeight(); y += pixsize) {
            for (int x = 0; x < src.getWidth(); x += pixsize) {
                // Copy the pixel
                double[] pixel = new double[4];
                pixel = src.getPixel(x, y, pixel);
                for (int yd = y; (yd < y + pixsize) && (yd < dest.getHeight()); yd++) {
                    for (int xd = x; (xd < x + pixsize) && (xd < dest.getWidth()); xd++) {
                        dest.setPixel(xd, yd, pixel);
                    }
                }
            }
        }
        img.setData(dest);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, format, baos);
        bytes = baos.toByteArray();
    }
}
