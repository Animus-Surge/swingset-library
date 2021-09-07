package xt.surge.swingset.components.canvas;

import xt.surge.swingset.components.Node2D;
import xt.surge.swingset.util.Texture;

import java.awt.Graphics;

public class Sprite extends Node2D {
    
    public Texture texture;

    public Sprite(Texture texture) {
        super();
        this.texture = texture;
    }

    public Sprite(float x, float y, Texture texture) {
        super(x, y);
        this.texture = texture;
    }

    @Override
    public void render(Graphics g, int xoffset, int yoffset) {
        
    }

}
