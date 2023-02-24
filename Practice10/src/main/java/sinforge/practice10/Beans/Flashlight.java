package sinforge.practice10.Beans;


import org.springframework.stereotype.Component;

@Component("Flashlight")
public class Flashlight implements Lighter{
    @Override
    public void doLight() {
        System.out.println("In flashlight");
    }
}
