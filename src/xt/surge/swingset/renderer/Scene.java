package xt.surge.swingset.renderer;

import xt.surge.swingset.components.Node;

public class Scene {
    
    public final String name;
    public Node rootNode;

    public Scene(String name, Node root) {
        this.name = name;
        this.rootNode = root;
    }

}
