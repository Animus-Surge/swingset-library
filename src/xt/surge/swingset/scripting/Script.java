package xt.surge.swingset.scripting;

import xt.surge.swingset.nodesys.Node;

/**
 * A script is a class that gets instantiated whenever a node
 * needs to have custom functonality. This can either be builtin
 * functionality or user-defined functionality.
 * 
 * @since 1.1
 * @version 1.1
 */
public abstract class Script {
    
    /**
     * Represents the node that the script is attached to
     */
    public Node node;

    /**
     * Creates a new Script that is attached to the specified node.
     * 
     * TODO: make it so scripts can be attached to multiple nodes using a builtin final call function
     * 
     * @param node The node the script is attached to
     */
    public Script(Node node) {
        this.node = node;
    }

    /**
     * Called when the script is first initialized
     */
    public void start() {}
    /**
     * Called every frame
     */
    public void update() {}
    /**
     * Called at a specific interval, used for physics
     */
    public void physics() {}
    /**
     * Called every time an input action occurs
     */
    public void input() {}

}
