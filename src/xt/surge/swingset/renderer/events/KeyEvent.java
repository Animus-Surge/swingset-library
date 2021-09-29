package xt.surge.swingset.renderer.events;

import java.awt.event.KeyListener;

import xt.surge.swingset.util.InputManager;

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
        InputManager.keyPress(e.getKeyCode());
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        InputManager.keyRelease(e.getKeyCode());
    }
    
}
