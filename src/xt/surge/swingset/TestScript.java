package xt.surge.swingset;

import xt.surge.swingset.scripting.Script;
import xt.surge.swingset.util.Constants;
import xt.surge.swingset.util.InputEvent;
import xt.surge.swingset.components.Node;

public class TestScript extends Script {
    
    public TestScript(Node node) {
        super(node);
    }

    @Override
    public void start() {
        Constants.MAINLGR.log(node.nodeName);
    }

    @Override
    public void input(InputEvent event) {
        if (event.type == InputEvent.EventType.IE_KEY && event.pressed) {
            Constants.MAINLGR.log("Key " + String.valueOf(event.code) + " was pressed!"); //TODO: create key and mouse button constants
        }
    }

}
