package pattertexemple.bridge.shape;

import pattertexemple.bridge.colore.IPalette;

public class Square extends Drawer {
    public Square(IPalette palette) {
        super(palette);
    }

    @Override
    public void draweShape(String color) {
        switch(color){
            case ("#FF0000"):{palette.setColor("Red");}break;
            case ("#00FF00"):{palette.setColor("Green");}break;
            default : {
                System.out.println("Undefined color");
            }
        }
    }
}
