package Practice7.Decorator;

public class Test {
    public static void main(String[] args) {
        Component textView = new TextView();
        textView.draw();
        System.out.println("------------");
        textView = new RedColorDecorator(textView);
        textView.draw();
    }
}
