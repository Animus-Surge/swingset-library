package xt.surge.swingset.components;

import java.awt.Graphics;
import java.util.ArrayList;

public class Node implements Renderable {

    public ArrayList<Node> children = new ArrayList<>();

    @Override
    public void render(Graphics g) {
        render(g, 0, 0);
    }

    @Override
    public void render(Graphics g, int xoffset, int yoffset) {
        children.forEach(child -> {
            child.render(g, 0, 0);
        });
    }

}