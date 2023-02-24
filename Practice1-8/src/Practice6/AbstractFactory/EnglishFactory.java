package Practice6.AbstractFactory;

public class EnglishFactory implements PeripheryFactory {
    @Override
    public Mouse createMouse() {
        return new EnMouse();
    }

    @Override
    public Microphone createMicrophone() {
        return new EnMicrophone();
    }
}
