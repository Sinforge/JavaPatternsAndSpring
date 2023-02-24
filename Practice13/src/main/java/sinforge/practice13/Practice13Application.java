package sinforge.practice13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;

@SpringBootApplication
public class Practice13Application {
    @Value("${student.name}")
    private static String name;

    @Value("${student.last_name")
    private static String lastName;

    @Value("${student.group")
    private static String group;

    public static void main(String[] args) {

        SpringApplication.run(Practice13Application.class, args);
    }

}
