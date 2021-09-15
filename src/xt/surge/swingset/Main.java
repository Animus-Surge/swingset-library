package xt.surge.swingset;

import static xt.surge.swingset.util.Constants.*;
import xt.surge.swingset.util.Constants;

import xt.surge.swingset.renderer.Window;
import xt.surge.swingset.resource.ImageLoader;
import xt.surge.swingset.resource.Scene;
import xt.surge.swingset.resource.SceneLoader;
import xt.surge.swingset.scripting.Script;
import xt.surge.swingset.structs.Texture;
import xt.surge.swingset.components.canvas.RectColor;
import xt.surge.swingset.components.canvas.Sprite;
import xt.surge.swingset.components.Node;

import java.awt.Color;
/**
 * This is a tester class used in testing the engine. This is not designed
 * to be included in release versions.
 * 
 * @author Surge
 * @version 1.0
 */
public class Main {

    
	/**
	 * Main method. Nothing major here.
	 * 
	 * @param args Command line arguments
	 */
    public static void main(String[] args) {
        MAINLGR.log("Swingset V" + VERSION_MAJOR + "." + VERSION_MINOR + "." + VERSION_PATCH);

		Window window = new Window();

		Node node = new Node("root");
		node.script = new Script(node) {
			@Override
			public void start() {
				Constants.MAINLGR.log(node.nodeName);
				Constants.MAINLGR.log("Hello from start method!");
			}
			@Override
			public void update() {

			}
		};

		Scene scene = new Scene("testScene", node);
		 	
		window.init("Swingset Engine | testScene", 800, 600, false, scene);
    }

	static void update() {
		
	}

}