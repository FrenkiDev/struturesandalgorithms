package pattertexemple.command;

public class Selector {
    Command up, down;

    public Selector(Command up, Command down) {
        this.up = up;
        this.down = down;
    }

    public void switchOn(){
        up.run();
    }
    public void switchOff(){
        down.run();
    }
}
