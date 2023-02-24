package sinforge.practice10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sinforge.practice10.Beans.*;

@SpringBootApplication
public class Practice10Application {

    public static void main(String[] args) {

        SpringApplication.run(Practice10Application.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Lighter lighter = context.getBean(Firefly.class);
        lighter.doLight();

        lighter = context.getBean(Lamp.class);
        lighter.doLight();

        lighter = context.getBean(Flashlight.class);
        lighter.doLight();
    }

}
