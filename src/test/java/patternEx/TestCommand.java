package patternEx;

import pattertexemple.command.*;

public class TestCommand {
    public static void main(String[] args) {
        Cat cats = new Cat();

        Command up = new SwitchOnCommand(cats);
        Command down = new SwitchOffCommand(cats);

        Selector selectCom = new Selector(up, down);
        selectCom.switchOn();
        selectCom.switchOff();
    }
}
