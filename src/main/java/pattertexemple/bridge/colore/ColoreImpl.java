package pattertexemple.bridge.colore;

public class ColoreImpl implements IPalette {
    @Override
    public void setColor(String color) {
        System.out.println("Shape color " + color);
    }
}
