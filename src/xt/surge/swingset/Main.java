package xt.surge.swingset;

import static xt.surge.swingset.util.Constants.*;

import xt.surge.swingset.renderer.Window;
import xt.surge.swingset.resource.Scene;
import xt.surge.swingset.resource.SceneLoader;
import xt.surge.swingset.components.canvas.RectColor;

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

		Scene scene = SceneLoader.loadScene("res/scenes/testscene.xml");

		RectColor root = new RectColor(Color.black, 0, 0, 800, 600);

		RectColor rect1 = new RectColor(Color.red, 30, 30, 100, 100);
		RectColor rect2 = new RectColor(Color.orange, 30, 30, 100, 100);
		RectColor rect3 = new RectColor(Color.yellow, 30, 30, 100, 100);
		RectColor rect4 = new RectColor(Color.green, 30, 30, 100, 100);
		RectColor rect5 = new RectColor(Color.blue, 30, 30, 100, 100);
		RectColor rect6 = new RectColor(Color.magenta, 30, 30, 100, 100);

		rect1.addChild(rect2);
		rect2.addChild(rect3);
		rect3.addChild(rect4);
		rect4.addChild(rect5);
		rect5.addChild(rect6);

		root.addChild(rect1);
		Scene trueScene = new Scene("scene", root);
		 	
		window.init("Swingset Engine | testScene", 800, 600, false, scene);
    }

}