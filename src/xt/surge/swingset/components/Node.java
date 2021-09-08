package xt.surge.swingset.components;

import java.awt.Graphics;
import java.util.ArrayList;

import xt.surge.swingset.intfs.Renderable;

/**
 * The Node is the most basic component that is available to be used in scenes. By default, all
 * root nodes in a scene is a regular Node, but this doesn't have to be the case. It can be changed
 * to any class that extends Node or any of its subclasses.
 * 
 * @author Surge
 * @version 1.0
 */
public class Node implements Renderable {

    /**
     * The list of children the node has
     */
    public ArrayList<Node> children = new ArrayList<>();

    /**
     * Unique identifier for the node. Used for the removeChild function primarily, though has
     * other uses.
     */
    public String nodeName;

    /**
     * The parent node of the node. Defaults to null. Adding this node as a child to another node sets this
     * variable.
     */
    public Node parent;
    
    /**
     * Creates a node of specified type with the nodeName being the classname
     */
    public Node() {
        this.nodeName = "Node";
    }

    /**
     * Creates a node of specified type with the nodeName being specified
     * 
     * @param name The string in which to name the node
     */
    public Node(String name) {
        this.nodeName = name;
    }

    //TODO: scripts

    /**
     * Sets the name of the node
     * 
     * @param name The new name of the node
     */
    public final void setName(String name) {
        this.nodeName = name;
    }

    /**
     * Adds a child node to the node.
     * 
     * @param child The node to add as a child of this node
     */
    public final void addChild(Node child) {
        children.add(child);
    }

    /**
     * Removes a child node of specified name.
     * 
     * @param nodeName The name of the child node to remove
     */
    public final void removeChild(String nodeName) {
        children.forEach(child -> {
            if(child.nodeName == nodeName) {
                children.remove(child);
                return;
            }
            //TODO: log that the child node of this node with name nodeName doesn't exist
        });
    }

    @Override
    public void render(Graphics g, int xoffset, int yoffset) {
        children.forEach(child -> child.render(g, xoffset, yoffset));
    }

}