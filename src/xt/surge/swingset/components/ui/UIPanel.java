package xt.surge.swingset.components.ui;

import java.awt.Graphics;
import java.awt.Color;

public class UIPanel extends UIElement {
    
    public int width, height;

    public Color bgColor = new Color(255, 255, 255, 64);
    public Color borderColor = Color.white;

    public UIPanel() {
        width = 0;
        height = 0;
        this.nodeName = "UIPanel";
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setBackgroundColor(Color color) {
        this.bgColor = color;
    }

    public void setBorderColor(Color color) {
        this.borderColor = color;
    }

    @Override
    public void render(Graphics g, int xoffset, int yoffset) {
        g.setColor(bgColor);
        g.fillRect(x, y, width, height);
        g.setColor(borderColor);
        g.drawRect(x, y, width, height);

        super.render(g, xoffset, yoffset);
    }
}
