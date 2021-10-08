package xt.surge.swingset.resource;

import java.awt.Graphics;

import xt.surge.swingset.components.Node2D;

/**
 * A scene is a group of nodes that collectively form a part of a game. For example,
 * in a normal game, there would be a main menu scene and a game scene, where the
 * game scene would have all the game objects, and the main menu scene has the
 * main menu. Scenes are stored in a custom XML format. Refer to the github wiki
 * page on scenes for more information and how-tos on making scenes.
 * 
 * @author Surge
 * @version 1.0
 */
public class Scene {
    
    /**
     * The scene name
     */
    public final String name;
    /**
     * The path where the scene is saved
     */
    public final String path;
    /**
     * The root node of the scene
     */
    public Node2D rootNode;

    /**
     * Creates a new scene with the specified name and root node.
     * 
     * @param name The scene name
     * @param root The root node of the scene
     */
    public Scene(String name, String scenePath, Node2D root) {
        this.name = name;
        this.rootNode = root;
        this.path = scenePath;
        root.onStart();
    }

    /**
     * Renders the scene
     * 
     * @param g The graphics object to render the scene onto
     */
    public void render(Graphics g) {
        rootNode.render(g);
    }

}
