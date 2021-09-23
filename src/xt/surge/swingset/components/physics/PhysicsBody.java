package xt.surge.swingset.components.physics;

import xt.surge.swingset.components.Node2D;
import xt.surge.swingset.structs.Transform;

public class PhysicsBody extends Node2D {
    
    public PhysicsBody() {
        super();
        this.nodeName = "PhysicsBody";
        this.transform = new Transform();
    }

}
