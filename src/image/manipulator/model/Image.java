package image.manipulator.model;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image implements Serializable {

    private BufferedImage image;
    private int width;
    private int heigth;
    private String imgPath;

    public BufferedImage getImage() {
        try {
            image = ImageIO.read(new File(imgPath));            
        } catch (Exception e) {
            System.out.println(e);
        }
        
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }
    
    public void saveImage(BufferedImage imageN, String path){
        try {
            ImageIO.write(imageN, "jpg", new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
   
    
}
