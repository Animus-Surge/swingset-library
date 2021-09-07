package xt.surge.swingset.components;

import java.awt.Graphics;
import java.util.ArrayList;

import xt.surge.swingset.intfs.Renderable;

public class Node implements Renderable {

    public ArrayList<Node> children = new ArrayList<>();

    //TODO: scripts

    @Override
    public void render(Graphics g, int xoffset, int yoffset) {
        children.forEach(child -> child.render(g, xoffset, yoffset));
    }

}