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

    public Color color;

    public RectColor() {
        super();
        this.color = Color.WHITE;
    }

    public RectColor(Color color) {
        super();
        this.color = color;
    }

    public RectColor(Color color, float x, float y, float w, float h) {
        super(x, y, w, h);
        this.color = color;
    }

    @Override
    public void render(Graphics g, int xoffset, int yoffset) {

        g.setColor(color);
        int gx = (int)transform.x + xoffset;
        int gy = (int)transform.y + yoffset;

        g.fillRect(gx, gy, (int)width, (int)height);

        children.forEach(child -> child.render(g, gx, gy));

    }

    public void setColor(Color color) {
        this.color = color;
    }

    public static RectColor fromElement(Element elem) {
        RectColor n = new RectColor();

        String name = elem.getAttribute("name");
        String posX = elem.getAttribute("x");
        String posY = elem.getAttribute("y");
        String sizeW = elem.getAttribute("w");
        String sizeH = elem.getAttribute("h");
        String red = elem.getAttribute("r");
        String green = elem.getAttribute("g");
        String blue = elem.getAttribute("b");
        String alpha = elem.getAttribute("a");

        if(!name.isEmpty()) n.setName(name);
        if(!posX.isEmpty()) n.setX(Integer.parseInt(posX));
        if(!posY.isEmpty()) n.setX(Integer.parseInt(posY));
        if(!sizeW.isEmpty()) n.setWidth(Integer.parseInt(sizeW));
        if(!sizeH.isEmpty()) n.setHeight(Integer.parseInt(sizeH));

        if(!red.isEmpty() && !green.isEmpty() && !blue.isEmpty() && !alpha.isEmpty()) 
            n.setColor(new Color(
                        Integer.parseInt(red),
                        Integer.parseInt(green),
                        Integer.parseInt(blue),
                        Integer.parseInt(alpha)
            ));

        return n;
    }
    
}
