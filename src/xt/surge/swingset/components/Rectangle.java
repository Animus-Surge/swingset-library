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

    /**
     * Width and height values
     */
    public float width, height;

    /**
     * Creates a new Rectangle
     */
    public Rectangle() {
        super();
        this.nodeName = "Rectangle";
        width = 0;
        height = 0;
    }

    /**
     * Sets the width of the Rectangle
     * 
     * @param width new width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Sets the height of the rectangle
     * 
     * @param height new height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Creates a new Rectangle based on the XML element provided
     * 
     * @param elem The XML element to convert to a node
     */
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
