package image.manipulator.controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;


public class ImageController implements Serializable {

    //private ;

    public BufferedImage setImageDarker(BufferedImage bf) {
        for (int i = 0; i < bf.getWidth(); i++) {
            for (int j = 0; j < bf.getHeight(); j++) {
                Color oldColor = new Color(bf.getRGB(i, j));
                Color newColor = new Color(
                        oldColor.getRed()/2,
                        oldColor.getGreen()/2,
                        oldColor.getBlue()/2
                );
                bf.setRGB(i, j, newColor.getRGB());
            }
        }
        return bf;
    }

    public BufferedImage setImgToNegative(BufferedImage bf) {
        for (int i = 0; i < bf.getWidth(); i++) {
            for (int j = 0; j < bf.getHeight(); j++) {
                Color oldColor = new Color(bf.getRGB(i, j));
                Color newColor = new Color(
                        255 - oldColor.getRed(),
                        255 - oldColor.getGreen(),
                        255 - oldColor.getBlue()
                );
                bf.setRGB(i, j, newColor.getRGB());
            }
        }
        return bf;
    }

    public BufferedImage setImgToGrayScale(BufferedImage bf) {
        for (int i = 0; i < bf.getWidth(); i++) {
            for (int j = 0; j < bf.getHeight(); j++) {
                Color oldColor = new Color(bf.getRGB(i, j));

                int avg = (oldColor.getRed() + oldColor.getGreen() + oldColor.getBlue())/3;

                Color newColor = new Color(avg, avg, avg);
                bf.setRGB(i, j, newColor.getRGB());
            }
        }

        return bf;
    }

    public BufferedImage imageTranslation(BufferedImage bf) {
        BufferedImage mirror = new BufferedImage(bf.getWidth()*2, bf.getHeight(), BufferedImage.TYPE_INT_ARGB);

        for (int j = 0; j < bf.getHeight(); j++) {
            for (int start = 0, end = bf.getWidth() * 2 - 1; start < bf.getWidth(); start++, end--) {
                int pixel = bf.getRGB(start, j);

                mirror.setRGB(start, j, pixel);
                mirror.setRGB(end, j, pixel);
            }
        }
        
        bf = mirror;
        
        return bf;
    }

    /*public BufferedImage rotateImage(double angDeg) {
        int widthOfImage = bf.getWidth();
        int heightOfImage = bf.getHeight();
        int typeOfImage = bf.getType();

        BufferedImage newImageFromBuffer = new BufferedImage(widthOfImage, heightOfImage, typeOfImage);

        Graphics2D graphics2D = newImageFromBuffer.createGraphics();

        graphics2D.rotate(Math.toRadians(angDeg), (double) widthOfImage / 2,  (double) heightOfImage / 2);
        graphics2D.drawImage(bf, null, 0, 0);

        bf = null;
        bf = newImageFromBuffer;
        return bf;
        //return bf;
    }*/

    public BufferedImage rotateImage(
            BufferedImage bf,
            double angDeg,
            int tx,
            int ty
    ) {
        int widthOfImage = bf.getWidth();
        int heightOfImage = bf.getHeight();
        int typeOfImage = bf.getType();

        BufferedImage newImageFromBuffer = new BufferedImage(widthOfImage, heightOfImage, typeOfImage);

        /*Graphics2D g2d = newImageFromBuffer.createGraphics();

        g2d.translate(tx/2, ty/2);
        g2d.rotate(Math.toRadians(angDeg*3.6));
        g2d.drawImage(bf, -widthOfImage/2, -heightOfImage/2, null);
        g2d.dispose();*/

        AffineTransform transform = new AffineTransform();
        transform.rotate(Math.toRadians(angDeg), (double) bf.getWidth()/2, (double) bf.getHeight()/2);
        double offset = (double)(bf.getWidth()-bf.getHeight())/2;
        transform.translate(offset,offset);

        AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
        op.filter(bf, newImageFromBuffer);

        return newImageFromBuffer;
    }

    public BufferedImage scaleImage(BufferedImage bf, double sx, double sy) {
        final int w = bf.getWidth();
        final int h = bf.getHeight();

        BufferedImage scaledImage = new BufferedImage((int)sx,(int)sy, bf.getType());
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(bf, 0, 0,w, h, null);
        g2d.dispose();

        bf = scaledImage;
        
        return bf;
    }

    /**
     * Crop Image method
     * @param bf
     * @param x - the X coordinate of the upper-left corner of the specified rectangular region
     * @param y - the Y coordinate of the upper-left corner of the specified rectangular region
     * @param w - the width of the specified rectangular region
     * @param h - the height of the specified rectangular region
     * @param image - original image
     * @return
     */
    public BufferedImage cropImg(BufferedImage bf, int x, int y, int w, int h, BufferedImage image) {
        try {
            bf = image.getSubimage(x, y, w, h);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return bf;
    }

    public void saveImg(BufferedImage img, String filename) throws IOException {
        ImageIO.write(img, "PNG", new File(filename+".png"));
    }
}
