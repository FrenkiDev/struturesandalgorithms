package patternEx;

import pattertexemple.bridge.colore.ColoreImpl;
import pattertexemple.bridge.shape.Drawer;
import pattertexemple.bridge.shape.Square;

public class TestBridge {
    public static void main(String[] args) {
        Drawer drawers = new Square(new ColoreImpl());
        drawers.draweShape("#FF0000");
    }
}
