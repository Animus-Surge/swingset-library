package xt.surge.swingset.intfs;

import java.awt.Graphics;

public interface Renderable {

    default void render(Graphics g) {
        render(g, 0, 0);
    }
    void render(Graphics g, int xoffset, int yoffset);

}
