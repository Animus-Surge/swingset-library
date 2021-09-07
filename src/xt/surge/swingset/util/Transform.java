package xt.surge.swingset.util;

/**
 * A transform represents a point in 2D space. It has an X and a Y coordinate.
 */
public class Transform {
    
    public float x, y;

    public Transform() {
        x = 0;
        y = 0;
    }

    public Transform(float x, float y) {
        this.x = x;
        this.y = y;
    }

}
