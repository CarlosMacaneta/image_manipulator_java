package image.manipulator.views;

import image.manipulator.model.Image;

import javax.swing.*;
import java.io.IOException;

public class Main extends JPanel {

    public static void main(String[] args) {
        try {
            JFrame frame = new JFrame("Testing img");
            frame.setSize(600,600);

            Image img = new Image();
            img.setImgPath("C:\\Users\\dell\\Downloads\\uem.png");

            ImgEditor editor = new ImgEditor(img);
            editor.rotateImg(25);
            editor.translateImg(300, 100);
            editor.scaleImg(0.25, 0.25);

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
