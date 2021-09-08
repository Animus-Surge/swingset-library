package xt.surge.swingset.scripting;

/**
 * The PhysicsScript interface defines the function that gets called on each physics cycle.
 * This is intended for use when you have a kinematic body that needs to move somewhere, or
 * collision checks are needed to be performed. Anything that doesn't relate to physics should
 * be handled in the {@link xt.surge.swingset.scripting.Script} or InputScript interface.
 * 
 * @author Surge
 * @version 1.0
 * @see xt.surge.swingset.scripting.Script
 */
public interface PhysicsScript extends Script {
    
    default void physicsUpdate(float delta) {}

}
