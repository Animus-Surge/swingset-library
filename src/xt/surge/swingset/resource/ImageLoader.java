package xt.surge.swingset.resource;

import xt.surge.swingset.util.Texture;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;

public class ImageLoader {
    
    //TODO: image caching

    private static HashMap<String, Texture> cache;

    public static Texture loadImage(String path) {
        if(cache.containsKey(path)) return cache.get(path);
        try {
            BufferedImage img = ImageIO.read(new File(path));
            Texture tex = new Texture(img);
            cache.put(path, tex);
            return tex;
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
