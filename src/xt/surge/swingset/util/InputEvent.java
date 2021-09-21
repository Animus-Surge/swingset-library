package xt.surge.swingset.util;

public final class InputEvent {
    
    public enum EventType {
        IE_KEY(0),
        IE_MOUSE_BUTTON(1)

        ;

        int id;
        EventType(int id) {
            this.id = id;
        }
    }

    public EventType type;
    public int code;
    public boolean pressed;

    public InputEvent(EventType type, int code, boolean pressed) {
        this.type = type;
        this.code = code;
        this.pressed = pressed;
    }
}
