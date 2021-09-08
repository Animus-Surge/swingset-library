package xt.surge.swingset.components.canvas;

import xt.surge.swingset.components.Node2D;
import xt.surge.swingset.structs.Texture;

import java.awt.Graphics;

/**
 * A Sprite is a render object that renders a texture. Sprites are useful in the sense that you
 * don't need to render a bunch of {@link xt.surge.swingset.components.canvas.RectColor}s at the
 * same time, and that you don't need to manually draw pixels and shapes (like in basic).
 * 
 * @author Surge
 * @version 1.0
 */
public class Sprite extends Node2D {
    
    public Texture texture;
    public float scalex, scaley;

    /**
     * Creates a new Sprite with the specified texture. By default, the position will be at 0, 0 with
     * an image scaling factor of 1 (original size).
     * 
     * @param texture The texture the sprite will render. If null, the sprite will not render anything and simply render its children.
     */
    public Sprite(Texture texture) {
        super();
        this.texture = texture;
        scalex = 1;
        scaley = 1;
    }

    /**
     * Creates a new Sprite with the specified texture at x,y. By default, the image scaling
     * factor will be 1 (original size), but this can be changed through the <code>setScale</code> function.
     */
    public Sprite(float x, float y, Texture texture) {
        super(x, y);
        this.texture = texture;
        scalex = 1;
        scaley = 1;
    }

    public void setScale(float x, float y) {
        this.scalex = x;
        this.scaley = y;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    @Override
    public void render(Graphics g, int xoffset, int yoffset) {
        if(texture != null) { //Avoid a NullPointerException
            g.drawImage(texture.getTexture(), xoffset + (int) this.transform.x, yoffset + (int) this.transform.y, (int)(scalex * texture.getSize().width), (int)(scaley * texture.getSize().height), null);
        }
        children.forEach(child -> child.render(g, xoffset, yoffset));
    }

}
