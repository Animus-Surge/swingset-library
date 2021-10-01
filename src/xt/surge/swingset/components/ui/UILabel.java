package xt.surge.swingset.components.ui;

import java.awt.Graphics;
import java.awt.Color;

public class UILabel extends UIElement {
    
    public String text;
    public Color color;

    public UILabel() {
        text = "";
        color = Color.white;
        this.nodeName = "UILabel";
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void render(Graphics g, int xoffset, int yoffset) {
        int xo = this.x + xoffset;
        int yo = this.y + yoffset;
        g.setColor(color);
        g.drawString(text, xo, yo);
        super.render(g, xo, yo);
    }

}
