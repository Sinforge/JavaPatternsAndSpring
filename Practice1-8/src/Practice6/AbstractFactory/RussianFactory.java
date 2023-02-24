package Practice6.AbstractFactory;

public class RussianFactory implements PeripheryFactory {
    @Override
    public Mouse createMouse() {
        return new RuMouse();
    }

    @Override
    public Microphone createMicrophone() {
        return new RuMicrophone();
    }

}
