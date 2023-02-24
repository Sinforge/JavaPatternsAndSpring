package Practice6.FactoryMethod;

public class RuMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Щелчок");
    }

    @Override
    public void dbclick() {
        System.out.println("Двойной щелчок");
    }
}
