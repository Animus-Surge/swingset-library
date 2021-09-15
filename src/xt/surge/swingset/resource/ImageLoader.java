package xt.surge.swingset.resource;

import javax.imageio.ImageIO;

import xt.surge.swingset.structs.Texture;
import xt.surge.swingset.util.Constants;
import xt.surge.swingset.util.Logger;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;

/**
 * The ImageLoader class handles all image files and caches them for later use. Instead of
 * constantly loading the images each time it is used, it checks an inernal HashMap to see
 * if the image has been loaded, and if it has, it returns the cached instance, and if not
 * it only then loads the image.
 * 
 * <strong>NOTE</strong>: The current method of error handling will crash the program. This is a work in progress.
 * 
 * @version 1.0
 * @author Surge
 */
public class ImageLoader {
    
    //TODO: image caching

    private static HashMap<String, Texture> cache = new HashMap<>();

    public static Texture loadImage(String path) {
        Constants.RESLGR.log("Path: " + path + " In cache: " + String.valueOf(cache.containsKey(path)));
        if(cache.containsKey(path)) return cache.get(path);
        try {
            BufferedImage img = ImageIO.read(new File(path));
            Texture tex = new Texture(img);
            cache.put(path, tex);
            return tex;
        } catch(IOException e) {
            Constants.RESLGR.logException(e, false, false);
            Constants.RESLGR.log("Path: " + path, Logger.TRACE);
            return null;
        }
    }
}
