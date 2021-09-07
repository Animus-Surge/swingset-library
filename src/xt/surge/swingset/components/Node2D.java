package xt.surge.swingset.components;

import xt.surge.swingset.util.Transform;

import java.awt.Point;

public class Node2D extends Node {

    protected Transform transform;

    public Node2D() {
        this.transform = new Transform();
    }

    public Node2D(float x, float y) {
        this.transform = new Transform(x, y);
    }

    public Point getPosition() {
        return null;
    }

}
