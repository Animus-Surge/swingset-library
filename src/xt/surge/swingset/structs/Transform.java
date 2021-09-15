package xt.surge.swingset.structs;

/**
 * A transform represents a point in 2D space. It has an X and a Y coordinate.
 */
public class Transform {
    
    /**
     * The coordinates of the transform
     */
    public float x, y;

    /**
     * Creates a transform at the origin
     */
    public Transform() {
        x = 0;
        y = 0;
    }

    /**
     * Creates a transform at the specified coordinates
     */
    public Transform(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Shifts the transform by the specified number of units
     * 
     * @param x How far left or right the shift should be
     * @param y How far up or down the shift would be (Flipped, as in negative values go up and positive values go down)
     */
    public void shift(float x, float y) {
        this.x += x;
        this.y += y;
    }

}
