package xt.surge.swingset.nodesys;

import xt.surge.swingset.structs.Texture;
import xt.surge.swingset.structs.Transform;

import java.awt.Graphics;

import java.awt.Image;

public class Sprite extends Node {
    
    public Texture texture;

    public Sprite() {
        this.name = this.getClass().getName();
        transform = new Transform();
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    @Override
    public void render(Graphics g, int xoffset, int yoffset) {
        setGlobalPosition(xoffset, yoffset);
        Image image = texture.getTexture();
        g.drawImage(image, globalPosition.x, globalPosition.y, (int)(image.getWidth(null) * transform.width), (int)(image.getHeight(null) * transform.height), null);
        drawChildren(g);
        onUpdate();
    }


}
