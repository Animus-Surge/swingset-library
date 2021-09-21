package xt.surge.swingset.renderer.events;

import java.awt.event.KeyListener;

import xt.surge.swingset.renderer.Renderer;

import xt.surge.swingset.util.InputEvent;

public class KeyEvent implements KeyListener {

    static KeyEvent instance;
    public static KeyEvent get() {
        if (instance == null) {
            instance = new KeyEvent();
        }
        return instance;
    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
        //unused
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        InputEvent event = new InputEvent(InputEvent.EventType.IE_KEY, e.getKeyCode(), true);
        Renderer.get().currentScene.rootNode.onInput(event);
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        InputEvent event = new InputEvent(InputEvent.EventType.IE_KEY, e.getKeyCode(), true);
        Renderer.get().currentScene.rootNode.onInput(event);
    }
    
}
