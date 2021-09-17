package xt.surge.swingset;

import xt.surge.swingset.scripting.Script;
import xt.surge.swingset.util.Constants;
import xt.surge.swingset.components.Node;

public class TestScript extends Script {
    
    public TestScript(Node node) {
        super(node);
    }

    @Override
    public void start() {
        Constants.MAINLGR.log(node.nodeName);
    }

}
