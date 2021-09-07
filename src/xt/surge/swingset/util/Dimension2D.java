package xt.surge.swingset.util;

/**
 * Because the regular {@link java.awt.Dimension} class doesn't support floats, this class is made to support floats.
 */
public class Dimension2D {
    
    public float w, h;

    public Dimension2D() {
        w = 0;
        h = 0;
    }

    public Dimension2D(float w, float h) {
        this.w = w;
        this.h = h;
    }

}
