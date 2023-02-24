package sinforge.practice13.Beans;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class StudentBean {
    @Value("${student.name}")
    private  String name;

    @Value("${student.last_name}")
    private  String lastName;

    @Value("${student.group}")
    private String group;

    @PostConstruct
    public void printStudent() {
        System.out.println(name + " " + lastName + " " +group);
    }


}
