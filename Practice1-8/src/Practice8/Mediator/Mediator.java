package Practice8.Mediator;

public class Mediator {
    private Engine engine;
    private Key key;
    private Car car;

    public void rotateKey() {
        if (engine.isLaunched()) {
            engine.stop();
        }
        else {
            engine.start();
        }
    }

    public void startDrive() {
        car.startDrive();
    }
    public void stopDrive() {
        car.stopDrive();
    }
}
