package sinforge.practice21.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories(basePackages = {
        "sinforge.practice21.Repo"
})
@EnableAspectJAutoProxy
@ComponentScan
public class DbConfig {}
