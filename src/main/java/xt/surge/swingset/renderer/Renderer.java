package xt.surge.swingset.renderer;

import javax.swing.JPanel;

import xt.surge.swingset.resource.Scene;

import java.awt.*;

public class Renderer extends JPanel {

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
