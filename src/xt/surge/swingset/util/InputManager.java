package xt.surge.swingset.util;

public final class InputManager {
    
    //Key Handlers

    public static boolean[] keys = new boolean[65536];

    public static void keyPress(int keycode) {
        keys[keycode] = true;
    }

    public static void keyRelease(int keycode) {
        keys[keycode] = false;
    }

    public static boolean isKeyPressed(int keycode) {
        return keys[keycode];
    }

    //Mouse Handlers

    public static int mouseX = 0, mouseY = 0;
    public static int pendingScrollClicks = 0;

    public static boolean[] mouseButtons = new boolean[4];

    public static void mouseMoved(int x, int y) {
        mouseX = x;
        mouseY = y;
    }

    public static void mouseScrolled(int clicks) {
        pendingScrollClicks = clicks;
    }

    public static void mouseDown(int button) {
        mouseButtons[button] = true;
    }

    public static void mouseUp(int button) {
        mouseButtons[button] = false;
    }
    
}
