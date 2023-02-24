package sinforge.practice10.Beans;

import org.springframework.stereotype.Component;

@Component("Firefly")
public class Firefly implements Lighter{
    @Override
    public void doLight() {
        System.out.println("Im firefly");
    }
}
