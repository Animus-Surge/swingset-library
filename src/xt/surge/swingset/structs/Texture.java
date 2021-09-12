package xt.surge.swingset.structs;

import java.awt.image.BufferedImage;
import java.awt.Dimension;

/**
 * A texture is an image that gets rendered onto the screen. Useful for {@link xt.surge.swingset.components.canvas.Sprite}s and TexBoxes.
 * 
 * @author Surge
 * @version 1.0
 */
public class Texture {
    
    private BufferedImage image;
    private Dimension size;

    public Texture(BufferedImage image) {
        this.image = image;

        this.size = new Dimension(image.getWidth(), image.getHeight());
    }

    public Dimension getSize() {return size;}

    public BufferedImage getTexture() {
        return image;
    }

}
