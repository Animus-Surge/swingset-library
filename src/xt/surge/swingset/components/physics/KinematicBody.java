package xt.surge.swingset.components.physics;

import xt.surge.swingset.util.Constants;
import xt.surge.swingset.util.Logger;

public class KinematicBody extends PhysicsBody {

    public KinematicBody() {
        super();
        this.nodeName = "KinematicBody";
    }

    @Override
    public void onStart() {
        super.onStart();
        if(collider == null) 
            Constants.MAINLGR.log("Collider is null. No physics will be processed. (" + this.nodeName + ")", Logger.WARNING);
    }

    public void move(int x, int y) {
        this.transform.shift(x, y);
    }

    //TODO: XML element handling

}
