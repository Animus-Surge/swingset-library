package xt.surge.swingset.renderer.events;

import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseMotionListener;

import xt.surge.swingset.util.InputManager;

public class MouseEvent implements MouseListener, MouseWheelListener, MouseMotionListener {

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        InputManager.mouseScrolled(e.getWheelRotation()); //TODO - figure this class out    
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        //unused, not needed. Should be handled in client.
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        InputManager.mouseDown(e.getButton());
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        InputManager.mouseUp(e.getButton());
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // unused
        
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // unused
        
    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        // unused, should be handled in the client
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        InputManager.mouseMoved(e.getX(), e.getY());
    }
    
}
