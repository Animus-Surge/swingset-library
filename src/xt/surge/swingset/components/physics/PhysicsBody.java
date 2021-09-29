package xt.surge.swingset.components.physics;

import xt.surge.swingset.components.Node2D;

public class PhysicsBody extends Node2D {
    
    public Collider collider;

    public PhysicsBody() {
        super();
        this.nodeName = "PhysicsBody";
    }

    public void setCollider(Collider collider) {
        this.collider = collider;
    }

    

}
