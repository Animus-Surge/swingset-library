package xt.surge.swingset.components.canvas;

import xt.surge.swingset.components.Node2D;

/**
 * A rectangle is a basic shape that will be used for collisions and rendering.
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

    
    
}
