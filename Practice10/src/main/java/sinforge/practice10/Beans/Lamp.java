package sinforge.practice10.Beans;

import org.springframework.stereotype.Component;

@Component("Lamp")
public class Lamp implements Lighter{
    @Override
    public void doLight() {
        System.out.println("Im lamp");
    }
}
