package xt.surge.swingset.components.canvas;

import java.awt.Graphics;

import org.w3c.dom.Element;

import xt.surge.swingset.components.Node2D;
import xt.surge.swingset.structs.Texture;
import xt.surge.swingset.util.Constants;
import xt.surge.swingset.resource.ImageLoader;

/**
 * A Sprite is a render object that renders a texture. Sprites are useful in the sense that you
 * don't need to render a bunch of {@link xt.surge.swingset.components.canvas.RectColor}s at the
 * same time, and that you don't need to manually draw pixels and shapes (like in basic).
 * 
 * @author Surge
 * @version 1.1
 */
public class Sprite extends Node2D {
    
    public Texture texture;
    public float scalex, scaley;

    /**
     * Creates a new Sprite with the specified texture. By default, the position will be at 0, 0 with
     * an image scaling factor of 1 (original size).
     */
    public Sprite() {
        super();
        this.nodeName = "Sprite";
        scalex = 1;
        scaley = 1;
    }

    /**
     * Sets the scaling factor of the sprite. Could also be called size. A value of 1 will
     * render the texture at full size, so if a texture was 800x600 pixels, and the sprite's
     * scaling factor was (1, 1), the texture will be rendered at 800x600 pixels.
     * 
     * @param x The x scaling factor
     * @param y The y scaling factor
     */
    public void setScale(float x, float y) {
        this.scalex = x;
        this.scaley = y;
    }

    /**
     * Sets the texture of the sprite.
     * 
     * @param texture The texture of the sprite
     */
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

    /**
     * Creates a new node based on the XML element provided
     * 
     * @param elem The XML element to convert to a node
     */
    public static Sprite fromElement(Element elem) {
        String texpath = elem.getAttribute("texture");
        String x = elem.getAttribute("x");
        String y = elem.getAttribute("y");
        String sx = elem.getAttribute("sx");
        String sy = elem.getAttribute("sy");

        Texture tx;

        Constants.RESLGR.log(texpath);

        if(texpath.startsWith("res:")) { //load a resource from the sceneloader
            //TODO
            tx = ImageLoader.loadImage(texpath.substring(4));
        } else {
            tx = ImageLoader.loadImage(texpath);
        }

        float scalex = 1;
        float scaley = 1;

        Sprite spr = new Sprite();
        spr.setTexture(tx);
        spr.setName(elem.getAttribute("name"));
        if(!x.isEmpty()) spr.transform.x = Integer.parseInt(x);
        if(!y.isEmpty()) spr.transform.y = Integer.parseInt(y);
        if(!sx.isEmpty()) scalex = Float.parseFloat(sx);
        if(!sy.isEmpty()) scaley = Float.parseFloat(sy);

        spr.setScale(scalex, scaley);

        return spr;
    }

}
