package xt.surge.swingset.components.physics;

import xt.surge.swingset.objects.Collider;

public class KinematicBody extends PhysicsBody {

    public Collider collider;

    public KinematicBody(String name) {
        super(name);
    }

    public KinematicBody(float x, float y) {
        super(x, y);
    }

    public KinematicBody(String name, float x, float y) {
        super(name, x, y);
    }

    

}
