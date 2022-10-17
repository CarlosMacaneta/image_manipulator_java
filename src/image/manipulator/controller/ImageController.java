package image.manipulator.controller;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
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

    public BufferedImage imageMirror(BufferedImage bf) {
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

    public BufferedImage translate(BufferedImage bf, double tx, double ty) {
        final int w = bf.getWidth();
        final int h = bf.getHeight();

        BufferedImage translate = new BufferedImage(w,h, bf.getType());
        Graphics2D g2d = translate.createGraphics();

        final AffineTransform at = new AffineTransform();
        at.translate(tx, ty);

        final AffineTransformOp translateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        translateOp.filter(bf,translate);

        g2d.drawImage(bf, (int) tx, (int) ty, null);
        g2d.dispose();

        return translate;
    }

    public BufferedImage rotateImage(BufferedImage bf, double angDeg) {
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

    public BufferedImage scaleImage(BufferedImage bf, double sx, double sy) {
        final int w = bf.getWidth();
        final int h = bf.getHeight();

        BufferedImage scaledImage = new BufferedImage(w,h, bf.getType());
        Graphics2D g2d = scaledImage.createGraphics();

        AffineTransform at = new AffineTransform();
        at.translate((double) w / 2, (double) h / 2);
        at.scale(sx, sy);
        at.translate((double) -bf.getWidth() / 2, (double) -bf.getHeight() / 2);
        g2d.setTransform(at);

        g2d.drawImage(bf, 0, 0, null);
        g2d.dispose();

        return scaledImage;
    }

    /**
     * Crop Image method
     * @param bf - image
     * @param x - the X coordinate of the upper-left corner of the specified rectangular region
     * @param y - the Y coordinate of the upper-left corner of the specified rectangular region
     * @param w - the width of the specified rectangular region
     * @param h - the height of the specified rectangular region
     * @return edited bf
     */
    public BufferedImage cropImg(BufferedImage bf, int x, int y, int w, int h) {
        try {
            bf = bf.getSubimage(x, y, w, h);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return bf;
    }
}
