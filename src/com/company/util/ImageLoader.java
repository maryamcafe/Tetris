package com.company.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class ImageLoader {

    public static BufferedImage loadImage(String imageName){
        String path = ConfigLoader.getInstance().getImageRepo() + imageName + ".png";
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
