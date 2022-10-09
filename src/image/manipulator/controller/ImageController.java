package image.manipulator.controller;

import image.manipulator.model.Image;

import javax.imageio.ImageIO; 
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Carlos Macaneta
 */
public class ImageController implements Serializable {

    private BufferedImage bf;

    public ImageController(Image img) throws IOException {
        bf = ImageIO.read(new File(img.getImgPath()));
    }

    public void loadImg(Image img) throws IOException {
        bf = ImageIO.read(new File(img.getImgPath()));
    }

    public void setImageDarker() {
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
    }

    public void setImgToNegative() {
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
    }

    public void setImgToGrayScale() {
        for (int i = 0; i < bf.getWidth(); i++) {
            for (int j = 0; j < bf.getHeight(); j++) {
                Color oldColor = new Color(bf.getRGB(i, j));

                int avg = (oldColor.getRed() + oldColor.getGreen() + oldColor.getBlue())/3;

                Color newColor = new Color(avg, avg, avg);
                bf.setRGB(i, j, newColor.getRGB());
            }
        }
    }



    public void saveImg(String filename) throws IOException {
        ImageIO.write(bf, "JPG", new File(filename+".jpg"));
    }
}
