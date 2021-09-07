package xt.surge.swingset.renderer;

import java.awt.*;
import javax.swing.*;

public class Window {

    public JFrame frame;
    public JPanel renderPanel;

    public void init(String title, int width, int height, boolean maximized) {
        frame = new JFrame(title);
        if(maximized) {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        frame.setSize(width, height);
        //frame.setIconImage(null); //TODO: Swingset icon, or game icon

        frame.setLocationRelativeTo(null);

        renderPanel = new Renderer();
        renderPanel.setSize(width, height);
        renderPanel.setMinimumSize(new Dimension(width, height));

        frame.add(renderPanel);
        frame.setContentPane(renderPanel);
        frame.pack();

        frame.setVisible(true);

        //Start the render loop
        //Start audio machine

    }

    public Dimension getSize() {
        return frame.getSize();
    }

}
