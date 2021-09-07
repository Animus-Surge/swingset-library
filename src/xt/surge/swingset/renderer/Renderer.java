package xt.surge.swingset.renderer;

import javax.swing.JPanel;

import java.awt.*;

public class Renderer extends JPanel {

    public Scene currentScene;
    
    public Renderer() {
        //Load default scene

    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 600);
    }

}
