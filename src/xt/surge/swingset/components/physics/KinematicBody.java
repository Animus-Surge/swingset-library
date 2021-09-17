package xt.surge.swingset.components.physics;

import xt.surge.swingset.objects.Collider;

public class KinematicBody extends PhysicsBody {

    public Collider collider;

    public KinematicBody() {
        super();
        this.nodeName = "KinematicBody";
    }

    public KinematicBody(String name) {
        super(name);
    }

    public KinematicBody(float x, float y) {
        super(x, y);
        this.nodeName = "KinematicBody";
    }

    public KinematicBody(String name, float x, float y) {
        super(name, x, y);
    }

    public void move(float x, float y) {
        this.transform.shift(x, y);
    }

}
