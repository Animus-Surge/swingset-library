package xt.surge.swingset.components;

import java.awt.Graphics;
import java.util.ArrayList;

import org.w3c.dom.Element;

import xt.surge.swingset.intfs.Renderable;
import xt.surge.swingset.scripting.Script;
import xt.surge.swingset.util.InputEvent;
import xt.surge.swingset.util.Logger;
import xt.surge.swingset.util.Constants;

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

    public Script script;

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

    /**
     * Gets called once the scene is loaded
     */
    public final void onStart() { 
        if(script != null)
            script.start();
    }

    public final void onInput(InputEvent event) {
        Constants.MAINLGR.log("Input event recieved.", Logger.DEBUG);
        if(script != null)
            script.input(event);
    }

    @Override
    public void render(Graphics g, int xoffset, int yoffset) {
        children.forEach(child -> child.render(g, xoffset, yoffset));
        if(script != null)
            script.update();
    }

    /**
     * Creates a new node based on the XML element provided
     * 
     * @param elem The XML element to convert to a node
     */
    public static Node fromElement(Element elem) {
        Node n = new Node();

        String name = elem.getAttribute("name");
        if(!name.isEmpty()) n.setName(name);

        return n;
    }

}