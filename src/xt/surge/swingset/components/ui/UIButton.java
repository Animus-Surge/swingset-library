package xt.surge.swingset.components.ui;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.function.Consumer;

public class UIButton extends UIPanel {
    
    public Consumer<Object> onClick;

    public UIButton() {
        super();
        this.nodeName = "UIButton";
    }

    public void setOnClick(Consumer<Object> onClick) {
        this.onClick = onClick;
    }

    public boolean hovered(Point p) {
        return new Rectangle(x, y, width, height).contains(p);
    }

}
