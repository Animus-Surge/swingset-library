package xt.surge.swingset.components;

import java.awt.Dimension;

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

    public Dimension getSize() {
        return null;
    }
    
}
