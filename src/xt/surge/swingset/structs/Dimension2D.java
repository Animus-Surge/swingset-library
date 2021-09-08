package xt.surge.swingset.structs;

/**
 * Because the regular {@link java.awt.Dimension} class doesn't support floats, this class is made to support floats.
 * 
 * @author Surge
 * @version 1.0
 */
public class Dimension2D {
    
    /**
     * The size of the dimension
     */
    public float w, h;

    /**
     * Creates a dimension with size 0
     */
    public Dimension2D() {
        w = 0;
        h = 0;
    }

    /**
     * Creates a dimesion with the specified size values.
     * 
     * @param w Width
     * @param h Height
     */
    public Dimension2D(float w, float h) {
        this.w = w;
        this.h = h;
    }

}
