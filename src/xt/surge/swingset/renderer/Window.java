package xt.surge.swingset.renderer;

import java.awt.*;
import javax.swing.*;

import xt.surge.swingset.renderer.events.KeyEvent;
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

        renderPanel = Renderer.get();
        renderPanel.currentScene = scene;
        renderPanel.setSize(width, height);

        frame.addKeyListener(KeyEvent.get());

        frame.add(renderPanel);

        frame.setVisible(true);
        renderPanel.start();

        while(true) {
            renderPanel.repaint(); //TODO: make this not an infinite loop
        }
        //Start audio machine

    }

    public Dimension getSize() {
        return frame.getSize();
    }

}
