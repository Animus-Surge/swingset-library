package xt.surge.swingset.components.ui;

import xt.surge.swingset.components.Node2D;

import org.w3c.dom.Element;

public class UIElement extends Node2D {
    
    public int x, y;

    public UIElement() {
        super();
        x = 0;
        y = 0;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public static UIElement fromElement(Element elem) {
        return null;
    }

}
