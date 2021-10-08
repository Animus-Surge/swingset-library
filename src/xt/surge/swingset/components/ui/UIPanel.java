package xt.surge.swingset.components.ui;

import java.awt.Graphics;
import java.awt.Color;

public class UIPanel extends UIElement {
    
    public int width, height;

    public Color bgColor = new Color(255, 255, 255, 64);
    public Color borderColor = Color.white;

    public UIPanel() {
        super();
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

    
}
