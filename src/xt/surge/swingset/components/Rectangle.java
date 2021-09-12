package xt.surge.swingset.components;

import org.w3c.dom.Element;

/**
 * A rectangle is a basic shape that can be used for collisions. By default, this class
 * contains no render functionality. To use render functionality, you should use the
 * {@link xt.surge.swingset.components.canvas.RectColor} or {@link xt.surge.swingset.components.canvas.Sprite}
 * class instead.
 * 
 * @author Surge
 * @version 1.0
 */
public class Rectangle extends Node2D {

    public float width, height;

    public Rectangle() {
        super();
        width = 0;
        height = 0;
    }

    public Rectangle(float x, float y, float width, float height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public Rectangle(String name) {
        super(name);
        width = 0;
        width = 0;
    }

    public Rectangle(float x, float y, float width, float height, String name) {
        super(x, y, name);
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static Rectangle fromElement(Element elem) {
        Rectangle n = new Rectangle();

        String name = elem.getAttribute("name");
        String posX = elem.getAttribute("x");
        String posY = elem.getAttribute("y");
        String sizeW = elem.getAttribute("w");
        String sizeH = elem.getAttribute("h");

        if(!name.isEmpty()) n.setName(name);
        if(!posX.isEmpty()) n.setX(Integer.parseInt(posX));
        if(!posY.isEmpty()) n.setX(Integer.parseInt(posY));
        if(!sizeW.isEmpty()) n.setWidth(Integer.parseInt(sizeW));
        if(!sizeH.isEmpty()) n.setHeight(Integer.parseInt(sizeH));

        return n;
    }

}
