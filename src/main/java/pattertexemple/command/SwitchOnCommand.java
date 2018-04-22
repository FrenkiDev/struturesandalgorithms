package pattertexemple.command;

public class SwitchOnCommand implements Command {
    private Cat cats;

    public SwitchOnCommand(Cat cats) {
        this.cats = cats;
    }

    @Override
    public void run() {
        cats.appear();
    }
}
