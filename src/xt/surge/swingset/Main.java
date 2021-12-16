package xt.surge.swingset;

import static xt.surge.swingset.util.Constants.*;

import xt.surge.swingset.renderer.Window;
import xt.surge.swingset.resource.ImageLoader;
import xt.surge.swingset.resource.Scene;

import xt.surge.swingset.nodesys.Node;
import xt.surge.swingset.nodesys.Sprite;

import java.awt.*;

/**
 * This is a tester class used in testing the engine. This is not designed
 * to be included in release versions.
 * 
 * @author Surge
 * @version 1.1
 * @since 1.0
 */
public class Main {

	/*
	TODO JAVADOCS need to be created for all methods, and version should be updated to 1.1
	Also add @since 1.0 tag
	*/
    
	/**
	 * Main method. Nothing major here.
	 * 
	 * @param args Command line arguments
	 */
    public static void main(String[] args) {
        MAINLGR.log("Swingset V" + VERSION_MAJOR + "." + VERSION_MINOR + "." + VERSION_PATCH);

		Window window = new Window();

		Sprite sprite = new Sprite();
		sprite.setTexture(ImageLoader.loadImage("../res/textures/tex1.png"));
		sprite.transform.position = new Point(10, 10);
		sprite.transform.resize(0.5, 0.5);

		Scene scene = new Scene("testScene", "local", sprite);
		window.init("Swingset Engine | testScene", 800, 600, false, scene);
    }

}