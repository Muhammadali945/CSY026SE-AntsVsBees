package core;

/**
 * @author Muhammad
 * Creates a water place in the tunnel. Only water safe ants can be placed in this place.
 */

public class Water extends Place{
    public Water(String name, Place exit) {
        super(name, exit);
    }
}
