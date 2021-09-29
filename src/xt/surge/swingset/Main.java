package xt.surge.swingset;

import static xt.surge.swingset.util.Constants.*;

import xt.surge.swingset.renderer.Window;
import xt.surge.swingset.resource.Scene;
import xt.surge.swingset.components.canvas.*;
import xt.surge.swingset.components.ui.UIPanel;

import java.awt.Color;

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

		RectColor background = new RectColor();
		background.setColor(Color.black);
		background.setWidth(800);
		background.setHeight(600);
		//*
		UIPanel panel = new UIPanel();
		panel.setPosition(100, 100);
		panel.setSize(100, 100);
		background.addChild(panel); //TODO: add a specific rendering and input layer for the UI
		//*/
		Scene scene = new Scene("testScene", background);
		 	
		window.init("Swingset Engine | testScene", 800, 600, false, scene);
    }

}