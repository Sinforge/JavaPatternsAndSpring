package Practice8.Mediator;

public class Engine{
    private Mediator mediator;
    private boolean isLaunched = false;

    public void start() {
        isLaunched = true;
        mediator.startDrive();
    }

    public void stop() {
        isLaunched = false;
        mediator.stopDrive();
    }

    public boolean isLaunched() {
        return isLaunched;
    }
}
