package xt.surge.swingset.renderer;

import xt.surge.swingset.components.Node;

import java.awt.Graphics;

public class Scene {
    
    public final String name;
    public Node rootNode;

    public Scene(String name, Node root) {
        this.name = name;
        this.rootNode = root;
    }

    public void render(Graphics g) {
        rootNode.render(g);
    }

}
