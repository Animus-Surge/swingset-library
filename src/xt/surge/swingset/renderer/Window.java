package xt.surge.swingset.renderer;

import java.awt.*;
import javax.swing.*;

import xt.surge.swingset.resource.Scene;

public class Window {

    public JFrame frame;
    public Renderer renderPanel;

    public void init(String title, int width, int height, boolean maximized, Scene scene) {
        frame = new JFrame(title);
        if(maximized) {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        //frame.setIconImage(null); //TODO: Swingset icon, or game icon

        frame.setLocationRelativeTo(null);

        renderPanel = new Renderer();
        renderPanel.currentScene = scene;
        renderPanel.setSize(width, height);

        frame.add(renderPanel);
        //frame.pack();

        frame.setVisible(true);

        //Start the render loop
        //Start audio machine

    }

    public Dimension getSize() {
        return frame.getSize();
    }

}
