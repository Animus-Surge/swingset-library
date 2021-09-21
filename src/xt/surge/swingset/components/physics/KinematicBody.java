package xt.surge.swingset.components.physics;

import xt.surge.swingset.objects.Collider;

public class KinematicBody extends PhysicsBody {

    public Collider collider;

    public KinematicBody() {
        super();
        this.nodeName = "KinematicBody";
    }

    public void move(int x, int y) {
        this.transform.shift(x, y);
    }

}
