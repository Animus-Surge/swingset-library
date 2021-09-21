package xt.surge.swingset;

import static xt.surge.swingset.util.Constants.*;

import xt.surge.swingset.renderer.Window;
import xt.surge.swingset.resource.Scene;
import xt.surge.swingset.components.canvas.*;

import java.awt.Color;
/**
 * This is a tester class used in testing the engine. This is not designed
 * to be included in release versions.
 * 
 * @author Surge
 * @version 1.0
 */
public class Main {

	/*
	TODO: Rework ALL nodes' constructors to not require any parameters. Should
	TODO only need to use helper methods to set all values to simplify code and make it
	TODO more readable.

	TODO JAVADOCS need to be created for all methods, and version should be updated to 1.1
	*/
    
	/**
	 * Main method. Nothing major here.
	 * 
	 * @param args Command line arguments
	 */
    public static void main(String[] args) {
        MAINLGR.log("Swingset V" + VERSION_MAJOR + "." + VERSION_MINOR + "." + VERSION_PATCH);

		Window window = new Window();

		RectColor node = new RectColor(Color.blue, 10, 10, 100, 100);
		node.script = new TestScript(node);

		Scene scene = new Scene("testScene", node);
		 	
		window.init("Swingset Engine | testScene", 800, 600, false, scene);
    }

	static void update() {
		
	}

}