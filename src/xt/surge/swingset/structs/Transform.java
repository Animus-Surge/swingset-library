package xt.surge.swingset.structs;

import java.awt.Dimension;
import java.awt.Point;

/**
 * A transform represents a point in 2D space. It has an X and a Y coordinate.
 */
public class Transform {
    
    public double width, height;
    public Point position;

    /**
     * Creates a new Transform at the origin with a size of 0x0 pixels
     */
    public Transform() {
        this.width = 0;
        this.height = 0;
        this.position = new Point(0, 0);
    }

    /**
     * Creates a new Transform at the specified position with a specified scale
     * 
     * @param position The position of the transform
     * @param scale The scale of the transform
     */
    public Transform(Point position, double width, double height) {
        this.width = width;
        this.height = height;
        this.position = position;
    }

    /**
     * Creates a new Transform using integer values to specify position and scale
     * 
     * @param x x
     * @param y y
     * @param width width
     * @param height height
     */
    public Transform(int x, int y, double width, double height) {
        this.width = width;
        this.height = height;
        this.position = new Point(x, y);
    }

    /**
     * Moves the transform by the specified number of pixels
     * 
     * @param x x
     * @param y y
     */
    public void translate(int x, int y) {
        this.position.move(x, y);
    }

    /**
     * Scales the transform to the new scale specified
     * 
     * @param newWidth the new width of the transform
     * @param newHeight the new height of the transform
     */
    public void resize(double newWidth, double newHeight) {
        this.height = newHeight;
        this.width = newWidth;
    }

}
