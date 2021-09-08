package xt.surge.swingset.intfs;

/**
 * This interface defines the functions if a node type should by default have clickable
 * mechanics. This can still be overridden by an attached function, but it is advisable not to.
 * Input events can be handled through user code as well.
 * 
 * @author Surge
 * @version 1.0
 */
public interface Clickable {
    
    void mousePressed();
    void mouseReleased();

    void mouseEnter();
    void mouseExit();

}
