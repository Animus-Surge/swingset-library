package xt.surge.swingset.components.physics;

import org.w3c.dom.Element;

import xt.surge.swingset.components.Rectangle;

import java.awt.Point;

/**
 * A Collider is a physics object that detects for collisions. Normally, colliders
 * will stop movement in a certain direction if it detects a collision, though most
 * engines' colliders also have trigger functionality, meaning it will trigger a function
 * if a collision is detected.
 * 
 * @author Surge
 * @version 1.0
 */
public class Collider extends Rectangle {
    
    public boolean isTrigger = false, isColliding = false;

    public Collider() {
        super();
        this.nodeName = "Collider";
    }

    public void setTrigger(boolean tr) {
        isTrigger = tr;
    }

    public boolean pointColliding(Point point) {
        return false;
    }

    public static Collider fromElement(Element elem) {
        return null;
    }

}
