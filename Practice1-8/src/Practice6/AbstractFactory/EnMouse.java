package Practice6.AbstractFactory;

public class EnMouse implements Mouse{
    @Override
    public void click() {
        System.out.println("Click");
    }

    @Override
    public void dbclick() {
        System.out.println("Double click");
    }
}
