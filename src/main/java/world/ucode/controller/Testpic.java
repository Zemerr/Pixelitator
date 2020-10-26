package world.ucode.controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
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

        try
        {
            ImageIcon ii = new ImageIcon("./slack-imgs.png");

            BufferedImage bi = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = (Graphics2D)bi.createGraphics();
            g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY));

            boolean b = g2d.drawImage(ii.getImage(), 0, 0, 50, 50, null);
            System.out.println(b);

            ImageIO.write(bi, "png", new File("apple50.png"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String []args) throws IOException {

        scaleImage();
    }

}
