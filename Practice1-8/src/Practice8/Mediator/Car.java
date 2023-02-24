package Practice8.Mediator;

public class Car {
    private boolean isDriving = false;
    public void startDrive() {
        isDriving = true;
    }
    public void stopDrive() {
        isDriving = false;
    }
    public boolean isDriving() {
        return isDriving;
    }
}
