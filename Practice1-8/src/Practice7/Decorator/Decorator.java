package Practice7.Decorator;

public abstract class Decorator implements Component{
    private Component component;
    public Decorator(Component component){
        this.component = component;
    }

    abstract public void afterDraw();

    @Override
    public void draw() {
        component.draw();
        afterDraw();
    }
}
