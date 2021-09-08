package xt.surge.swingset;

import xt.surge.swingset.renderer.Window;

/**
 * This is a tester class used in testing the engine. This is not designed
 * to be included in release versions.
 * 
 * @author Surge
 * @version 1.0
 */
public class Main {

    public static final int VERSION_MAJOR = 0; //TODO: define these values in a constants class
    public static final int VERSION_MINOR = 1;
    public static final int VERSION_PATCH = 0;

    public static void main(String[] args) {

        System.out.println("Swingset V" + VERSION_MAJOR + "." + VERSION_MINOR + "." + VERSION_PATCH);
        new Window().init("Swingset V" + VERSION_MAJOR + "." + VERSION_MINOR + "." + VERSION_PATCH, 800, 600, false);

    }

}