package pattertexemple.command;

public class SwitchOffCommand implements Command{
    private Cat cats;

    public SwitchOffCommand(Cat cats) {
        this.cats = cats;
    }

    @Override
    public void run() {
        cats.hide();
    }
}
