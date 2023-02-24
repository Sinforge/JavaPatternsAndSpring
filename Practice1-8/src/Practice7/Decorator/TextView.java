package Practice7.Decorator;

public class TextView implements Component{


    @Override
    public void draw() {
        System.out.println("Drawing text");
    }

}
