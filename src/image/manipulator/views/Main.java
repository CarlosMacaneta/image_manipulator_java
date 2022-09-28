package image.manipulator.views;

import image.manipulator.controller.ImageController;
import image.manipulator.model.Image;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Editor");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon();

        try {
            Image img = new Image();
            img.setImgPath("C:\\Users\\dell\\Downloads\\uem.png");
            ImageController ic = new ImageController(img);

            icon.setImage(ic.rotateImage(90));
            label.setIcon(icon);
            label.setBounds(300, 300, icon.getIconWidth(), icon.getIconHeight());

            panel.add(label);
            panel.setBounds(0, 0, 600, 600);
            frame.add(panel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
