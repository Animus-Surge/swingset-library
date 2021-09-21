package xt.surge.swingset.components.canvas;

import java.awt.Color;
import java.awt.Graphics;
import org.w3c.dom.Element;

import xt.surge.swingset.components.Rectangle;

/**
 * A RectColor is a {@link xt.surge.swingset.components.Rectangle} with render capability.
 * All it is is a solid color that fills a section of the screen. Simple, right?
 * 
 * @author Surge
 * @version 1.0
 */
public class RectColor extends Rectangle {

    /**
     * The color of the node
     */
    public Color color;

    /**
     * Creates a new RectColor. By default, <code>color</code> will be set to white.
     */
    public RectColor() {
        super();
        this.color = Color.WHITE;
        this.nodeName = "RectColor";
    }

    @Override
    public void render(Graphics g, int xoffset, int yoffset) {

        g.setColor(color);
        int gx = (int)transform.x + xoffset;
        int gy = (int)transform.y + yoffset;

        g.fillRect(gx, gy, (int)width, (int)height);

        children.forEach(child -> child.render(g, gx, gy));

        this.script.update();
    }

    /**
     * Sets the color of the RectColor
     * 
     * @param color The color of the RectColor
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Creates a new node based on the XML element provided
     * 
     * @param elem The XML element to convert to a node
     */
    public static RectColor fromElement(Element elem) {
        RectColor n = new RectColor();

        String name = elem.getAttribute("name");
        String posX = elem.getAttribute("x");
        String posY = elem.getAttribute("y");
        String sizeW = elem.getAttribute("width");
        String sizeH = elem.getAttribute("height");
        String red = elem.getAttribute("r");
        String green = elem.getAttribute("g");
        String blue = elem.getAttribute("b");
        String alpha = elem.getAttribute("a");

        if(!name.isEmpty()) n.setName(name);
        if(!posX.isEmpty()) n.setX(Integer.parseInt(posX));
        if(!posY.isEmpty()) n.setY(Integer.parseInt(posY));
        if(!sizeW.isEmpty()) n.setWidth(Integer.parseInt(sizeW));
        if(!sizeH.isEmpty()) n.setHeight(Integer.parseInt(sizeH));

        int r = 0;
        int g = 0;
        int b = 0;
        int a = 255;
        if(!red.isEmpty()) r = Integer.parseInt(red);
        if(!green.isEmpty()) g = Integer.parseInt(green);
        if(!blue.isEmpty()) b = Integer.parseInt(blue);
        if(!alpha.isEmpty()) a = Integer.parseInt(alpha);

        n.setColor(new Color(r, g, b, a));
        return n;
    }
    
}
