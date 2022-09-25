package image.manipulator.model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Image implements Serializable {

    private BufferedImage image;
    private String imgPath;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
