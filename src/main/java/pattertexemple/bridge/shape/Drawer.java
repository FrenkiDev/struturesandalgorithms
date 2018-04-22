package pattertexemple.bridge.shape;

import pattertexemple.bridge.colore.IPalette;

public abstract class Drawer {
    protected IPalette palette;

    protected Drawer(IPalette palette) {
        this.palette = palette;
    }

    public abstract void draweShape(String color);
}
