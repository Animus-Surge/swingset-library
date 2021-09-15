package xt.surge.swingset;

import static xt.surge.swingset.util.Constants.*;

import xt.surge.swingset.renderer.Window;
import xt.surge.swingset.resource.ImageLoader;
import xt.surge.swingset.resource.Scene;
import xt.surge.swingset.resource.SceneLoader;
import xt.surge.swingset.structs.Texture;
import xt.surge.swingset.components.canvas.RectColor;
import xt.surge.swingset.components.canvas.Sprite;

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

		Texture testTex = ImageLoader.loadImage("../res/textures/tex1.png");

		RectColor bg = new RectColor(Color.black, 0, 0, 800, 600);

		Sprite testSprite = new Sprite(30, 30, testTex);
		testSprite.setScale(0.5f, 0.5f);

		bg.addChild(testSprite);

		Scene scene = SceneLoader.loadScene("../res/scenes/testscene.xml");

		Scene testScene = new Scene("TestScene2", bg);
		 	
		window.init("Swingset Engine | testScene", 800, 600, false, scene);
    }

	static void update() {
		
	}

}