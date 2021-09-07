package xt.surge.swingset.resource;

import xt.surge.swingset.components.Node;

/**
 * The SceneLoader class handles all loading of scene (*.swsc or files in xml format) files for use in the game. Scene files
 * use XML (Extensible Markup Language) to define all scene nodes and resources used. 
 * 
 * @author Surge
 * @version 1.0
 */
public class SceneLoader {
    
    /**
     * Load a scene from the specified path.<br><br>
     * This method scans the scene file and parses its XML contents to a Node tree.
     * @param path The path of the scene file. Can either begin with the <code>resource:</code> prefix or a direct filepath.
     * @return The node tree of the scene
     */
    public static Node loadScene(String path) {

        return null;
    }

}
