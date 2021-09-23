package xt.surge.swingset.renderer;

import javax.swing.JPanel;

import xt.surge.swingset.resource.Scene;

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

    public Renderer(Scene scene) {
        this.currentScene = scene;
    }

    @Override
    public void paintComponent(Graphics g) {
        currentScene.render(g);
    }

}
