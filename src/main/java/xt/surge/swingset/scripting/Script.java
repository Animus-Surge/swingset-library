package xt.surge.swingset.scripting;

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
public interface Script {
    
    /**
     * This is the starting point of everything! On scene load, each node with a script attached will
     * get this function called. This function will only be called <i>once</i>.
     */
    default void start(){}

    /**
     * The update function gets called on each frame. Put things that need to be checked each frame
     * (like collisions or mouse hover checks) here.
     */
    default void update(){}

}
