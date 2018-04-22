package patternEx;

import pattertexemple.composite.Composite;
import pattertexemple.composite.Leaf;
import pattertexemple.composite.Stick;
import pattertexemple.composite.Tree;

public class TestComposite {
    public static void main(String[] args) {
        Leaf leafs = new Leaf();
        Stick stick = new Stick();
        Tree trees = new Tree();

        Composite composits = new Composite();
        composits.add(leafs);
        composits.add(stick);
        composits.add(trees);

        composits.show();
    }
}
