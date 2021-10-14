package xt.surge.swingset.scripting;

import xt.surge.swingset.components.Node2D;

/**
 * A script is a special type of resource that is used for user defined functionality of
 * a node or likewise. Scripts are written in Java and are essentially classes that derive this
 * interface or classes that derive this interface.
 * 
 * Extra scripting interfaces are defined in the {@link xt.surge.swingset.scripting} package, incuding
 * interfaces that allow scripts to use physics and user input, such as a KinematicBody.
 * 
 * This interface is the base interface that includes definitions for the <code>start</code> and
 * <code>update</code> functions.
 * 
 * @author Surge
 * @version 1.0
 */
public class Script {
    
    /**The node the script is attached to */
    public final Node2D node;

    /**
     * Creates a new script. It takes in the node that it will be attached to so the script modify its
     * properties.
     * 
     * @param node The node that the script will be attached to
     */
    public Script(Node2D node) {
        this.node = node;
    }

    /**
     * This is the starting point of everything! On scene load, each node with a script attached will
     * get this function called. This function will only be called <i>once</i>.
     */
    public void start(){}

    /**
     * The update function gets called on each frame. Put things that need to be checked each frame
     * (like collisions or mouse hover checks) here.
     */
    public void update(){}

    //Maybe: create input method to handle direct inputs targeted at this script, otherwise
    //use update() function

}
