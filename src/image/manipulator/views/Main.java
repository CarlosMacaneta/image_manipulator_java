package image.manipulator.views;

import image.manipulator.model.Image;

import javax.swing.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Main extends JPanel {

    public static void main(String[] args) {
        try {
            JFrame frame = new JFrame("Testing img");
            frame.setSize(600,600);
            
            Image img = new Image();
            img.setImgPath("C:\\Users\\Jaime Rungo\\Pictures\\R.jpg");
            BufferedImage originalImg = ImageIO.read(
                new File("C:\\Users\\Jaime Rungo\\Pictures\\12.jpg"));
            
            ImgEditor editor = new ImgEditor(img);
            //editor.rotateImg(25);
            //editor.translateImg(300, 100);
            //editor.scaleImg(0.25, 0.25);
            BufferedImage newImage = editor.cropImg(1000, 1000, 1000, 1000, originalImg);
            img.saveImage(newImage, "C:\\Users\\Jaime Rungo\\Pictures\\1255.jpg");
            
           // img.saveImage(editor.cropImg(20, 50, 20, 50, originalImg), "C:\\Users\\Jaime Rungo\\Pictures\\f.jpg");
            frame.add(editor);
            frame.setVisible(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*try {
            Image img = new Image();
            img.setImgPath("C:\\Users\\dell\\Pictures\\20201212_120405.jpg");
            ImageController ic = new ImageController(img);

            ic.setImgToGrayScale();
            ic.saveImg("C:\\Users\\dell\\Pictures\\20201212_120405_copy");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
