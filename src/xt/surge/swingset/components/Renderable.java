package xt.surge.swingset.components;

import java.awt.Graphics;

public interface Renderable {
    
    void render(Graphics g);
    void render(Graphics g, int xoffset, int yoffset);

}
