package image.manipulator.views;

import image.manipulator.model.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImgEditor extends JPanel {

    private BufferedImage bf;
    private double angDeg;
    private double sx = 1;
    private double sy = 1;
    private int tx = this.getSize().width/2;
    private int ty = this.getSize().height/2;

    public ImgEditor(Image img) throws IOException {
        bf = ImageIO.read(new File(img.getImgPath()));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.translate(tx, ty);
        g2d.rotate(Math.toRadians(angDeg));
        g2d.scale(sx, sy);
        g2d.drawImage(bf, -bf.getWidth()/2, -bf.getHeight()/2, null);
    }

    public void rotateImg(int angDeg) {
         this.angDeg = angDeg * 3.6;
         repaint();
    }

    public void scaleImg(double x, double y) {
        sx = x;
        sy = y;
    }

    public void translateImg(int x, int y) {
        tx = x;
        ty = y;
    }
}
