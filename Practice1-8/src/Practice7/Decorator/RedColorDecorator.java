package Practice7.Decorator;

public class RedColorDecorator extends Decorator{
    public RedColorDecorator(Component component) {
        super(component);
    }

    @Override
    public void afterDraw() {
        System.out.println("\033[0;31m" + "Applying red color");
    }
}
