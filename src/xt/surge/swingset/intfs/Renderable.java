package xt.surge.swingset.intfs;

import java.awt.Graphics;

/**
 * The renderable interface defines an object that is able to be rendered. By default, all
 * node types implement this interface to allow easy rendering of the entire scene (without
 * a bunch of checks).
 * 
 * @author Surge
 * @version 1.0
 */
public interface Renderable {

    /**
     * Renders this object.
     * 
     * @param g The graphics object to render this object on
     */
    default void render(Graphics g) {
        render(g, 0, 0);
    }

    /**
     * Renders this object with an offset. Used with child nodes that aren't at 0,0
     * 
     * @param g The graphics object to render this object on
     * @param xoffset The x offset to render this object
     * @param yoffset The y offset to render this object
     */
    void render(Graphics g, int xoffset, int yoffset);

}
