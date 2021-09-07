package xt.surge.swingset.resource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;

public class ImageLoader {
    
    //TODO: image caching

    private static HashMap<String, BufferedImage> cache;

    public static BufferedImage loadImage(String path) {
        if(cache.containsKey(path)) return cache.get(path);
        try {
            BufferedImage img = ImageIO.read(new File(path));
            cache.put(path, img);
            return img;
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
