package xt.surge.swingset.nodesys;

import java.awt.Graphics;
import java.util.ArrayList;

import xt.surge.swingset.intfs.Renderable;
import xt.surge.swingset.structs.Transform;
import xt.surge.swingset.scripting.Script;

import java.awt.Point;

public class Node implements Renderable {

    public Transform transform;

    public ArrayList<Node> children = new ArrayList<>();
    public String name;

    public Point globalPosition;

    public Script script;

    //script - user defined functionality
    //builtin script - basically if a node has default functionality, like changing a sprite texture or executing an action like moving around, this script spot will be populaeted

    public Node() {
        this.name = this.getClass().getName(); //Ease the task of setting names
        transform = new Transform();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void onStart() {
        if(this.script == null) return;
        this.script.start();
    }

    public void onUpdate() {
        if(this.script == null) return;
        this.script.update();
    }

    public void onPhysicsUpdate() {
        if(this.script == null) return;
        this.script.physics();
    }

    public void onInput() {
        if(this.script == null) return;
        //maybe... we'll see
        this.script.input();
    }

    public void addChild(Node node) {
        this.children.add(node);
    }

    public Node getChild(String nodePath) {
        //TODO: iterate over nodes through the slash '/' character
        String n = nodePath.split("/")[0];
        for(Node child : children) {
            if (child.name.equals(n)) return child;
        }
        return null;
    }

    @Override
    public void render(Graphics g) {
        render(g, 0, 0);
    }

    public void setGlobalPosition(int x, int y) {
        globalPosition = new Point(this.transform.position.x + x, this.transform.position.y + y);
    }

    @Override
    public void render(Graphics g, int xoffset, int yoffset) {
        setGlobalPosition(xoffset, yoffset);
        drawChildren(g);
        onUpdate();
    }

    public void drawChildren(Graphics g) {
        children.forEach(child -> child.render(g, globalPosition.x, globalPosition.y));
    }
    
}
