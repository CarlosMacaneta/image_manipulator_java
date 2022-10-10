package image.manipulator.controller;

import image.manipulator.model.Image;

import javax.imageio.ImageIO; 
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;


public class ImageController implements Serializable {

    private final BufferedImage bf;

    public ImageController(Image img) throws IOException {
        bf = ImageIO.read(new File(img.getImgPath()));
    }

    public BufferedImage setImageDarker() {
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

    public BufferedImage setImgToNegative() {
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

    public BufferedImage setImgToGrayScale() {
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

    public BufferedImage imageTranslation() {
        BufferedImage mirror = new BufferedImage(bf.getWidth()*2, bf.getHeight(), BufferedImage.TYPE_INT_ARGB);

        for (int j = 0; j < bf.getHeight(); j++) {
            for (int start = 0, end = bf.getWidth() * 2 - 1; start < bf.getWidth(); start++, end--) {
                int pixel = bf.getRGB(start, j);

                mirror.setRGB(start, j, pixel);
                mirror.setRGB(end, j, pixel);
            }
        }
        return mirror;
    }

    public BufferedImage rotateImage(double angDeg) {
        final double rads = Math.toRadians(angDeg);
        final double sin = Math.abs(Math.sin(rads));
        final double cos = Math.abs(Math.cos(rads));

        final int w = (int) Math.floor(bf.getWidth() * cos + bf.getHeight() * sin);
        final int h = (int) Math.floor(bf.getHeight() * cos + bf.getWidth() * sin);

        final BufferedImage rotatedImage = new BufferedImage(w, h, bf.getType());

        final AffineTransform at = new AffineTransform();
        at.translate((double) w / 2, (double) h / 2);
        at.rotate(rads);
        at.translate((double) -bf.getWidth() / 2, (double) -bf.getHeight() / 2);

        final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        rotateOp.filter(bf,rotatedImage);

        return rotatedImage;
    }

    public BufferedImage scaleImage(double sx, double sy) {
        final int w = bf.getWidth();
        final int h = bf.getHeight();

        BufferedImage scaledImage = new BufferedImage((w * 2),(h * 2), BufferedImage.TYPE_INT_ARGB);

        final AffineTransform at = new AffineTransform();
        at.scale(sx, sy);

        final AffineTransformOp ato = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
        scaledImage = ato.filter(bf, scaledImage);

        return scaledImage;
    }

    public void saveImg(BufferedImage img, String filename) throws IOException {
        ImageIO.write(img, "PNG", new File(filename+".png"));
    }
}
