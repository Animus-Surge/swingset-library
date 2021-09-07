package xt.surge.swingset.util;

import java.awt.Image;

/**
 * A texture is an image that gets rendered onto the screen. Useful for {@link xt.surge.swingset.components.canvas.Sprite}s and TexBoxes.
 * 
 * @author Surge
 * @version 1.0
 */
public class Texture {
    
    private Image image;

    public Texture(Image image) {
        this.image = image;
    }

    public Image getTexture() {
        return image;
    }

}
