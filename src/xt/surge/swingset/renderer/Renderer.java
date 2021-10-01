package xt.surge.swingset.renderer;

import javax.swing.JPanel;

import xt.surge.swingset.resource.Scene;
import xt.surge.swingset.resource.SceneLoader;
import xt.surge.swingset.util.Constants;
import xt.surge.swingset.util.Logger;

import java.awt.*;

public class Renderer extends JPanel {

    static Renderer instance;
    public static Renderer get() {
        if(instance == null) {
            instance = new Renderer();
        }
        return instance;
    }

    public Scene currentScene;
    
    public Renderer() {

    }

    public void start() {
        currentScene.rootNode.onStart();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        currentScene.render(g);
        repaint();
    }

    public void reloadScene() {
        if(currentScene.path.equals("local")) {
            Constants.MAINLGR.log("Cannot reload a hardcoded scene", Logger.ERROR);
        } else {
            String path = currentScene.path;
            currentScene = SceneLoader.loadScene(path);
        }
    }

    //TODO: Render thread and physics threads

}
