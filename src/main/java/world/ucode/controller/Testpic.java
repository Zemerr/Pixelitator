package world.ucode.controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class Testpic {


    public static void scaleImage() throws IOException {

        File file = new File("./slack-imgs.png");
        //BufferedImage image = ImageIO.read(file);


//        BufferedImage img = ImageIO.read(file);
//        final int PIX_SIZE = 10;
//        // loop through the image and produce squares pixelSize*pixelSize
//        for(int w = 0 ; w < img.getWidth() ; w+=PIX_SIZE) {
//            for(int h = 0 ; h < img.getHeight() ; h+=PIX_SIZE) {
//                Color pixelColor = new Color(img.getRGB(w, h));
//                Graphics graphics = img.getGraphics();
//                graphics.setColor(pixelColor);
//                graphics.fillRect(w, h, PIX_SIZE, PIX_SIZE);
//            }
//        }
//        ImageIO.write(img, "png", new File("apple50.png"));

//        try
//        {
//            ImageIcon ii = new ImageIcon("./slack-imgs.png");
//
//            BufferedImage bi = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
//            Graphics2D g2d = (Graphics2D)bi.createGraphics();
//            g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,
//                    RenderingHints.VALUE_RENDER_QUALITY));
//
//            boolean b = g2d.drawImage(ii.getImage(), 0, 0, 50, 50, null);
//            System.out.println(b);
//
//            ImageIO.write(bi, "png", new File("apple50.png"));
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }

        final int PIX_SIZE = 10;

// Read the file as an Image
        BufferedImage img = ImageIO.read(new File("./slack-imgs.png"));

// Get the raster data (array of pixels)
        Raster src = img.getData();

// Create an identically-sized output raster
        WritableRaster dest = src.createCompatibleWritableRaster();

// Loop through every PIX_SIZE pixels, in both x and y directions
        for(int y = 0; y < src.getHeight(); y += PIX_SIZE) {
            for(int x = 0; x < src.getWidth(); x += PIX_SIZE) {

                // Copy the pixel
                double[] pixel = new double[4];
                pixel = src.getPixel(x, y, pixel);

                // "Paste" the pixel onto the surrounding PIX_SIZE by PIX_SIZE neighbors
                // Also make sure that our loop never goes outside the bounds of the image
                for(int yd = y; (yd < y + PIX_SIZE) && (yd < dest.getHeight()); yd++) {
                    for(int xd = x; (xd < x + PIX_SIZE) && (xd < dest.getWidth()); xd++) {
                        dest.setPixel(xd, yd, pixel);
                    }
                }
            }
        }

// Save the raster back to the Image
        img.setData(dest);
        ImageIO.write(img, "png", new File("apple50.png"));
    }

    public static void main(String []args) throws IOException {

        scaleImage();
    }

}
