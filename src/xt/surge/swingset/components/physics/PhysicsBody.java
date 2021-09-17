package xt.surge.swingset.components.physics;

import xt.surge.swingset.components.Node2D;
import xt.surge.swingset.structs.Transform;

public class PhysicsBody extends Node2D {
    
    public PhysicsBody() {
        this.nodeName = "PhysicsBody";
        this.transform = new Transform();
    }

    public PhysicsBody(float x, float y) {
        this.nodeName = "PhysicsBody";
        this.transform = new Transform(x, y);
    }

    public PhysicsBody(String name) {
        this.nodeName = name;
        this.transform = new Transform();
    }

    public PhysicsBody(String name, float x, float y) {
        this.nodeName = name;
        this.transform = new Transform(x, y);
    }

}
