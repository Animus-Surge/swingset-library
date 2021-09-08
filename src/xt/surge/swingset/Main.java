package xt.surge.swingset;

import xt.surge.swingset.renderer.Window;

import static xt.surge.swingset.util.Constants.*;

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

        System.out.println("Swingset V" + VERSION_MAJOR + "." + VERSION_MINOR + "." + VERSION_PATCH);
        new Window().init("Swingset V" + VERSION_MAJOR + "." + VERSION_MINOR + "." + VERSION_PATCH, 800, 600, false);

    }

}