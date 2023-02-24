package Practice7.Facade;

public class CarFacade {
    private final Engine engine = new Engine();
    private final Key key = new Key();

    public void startCar() {
        key.insertKey();
        key.rotateKey();
        engine.startEngine();
    }
    public void stopCar() {
        key.rotateKey();
        engine.stopEngine();
        key.pullOutKey();
    }

}
