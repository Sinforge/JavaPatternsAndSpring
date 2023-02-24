package sinforge.practice20.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories(basePackages = {
        "sinforge.practice20.Repo"
})
@EnableAspectJAutoProxy
@ComponentScan
public class DbConfig {}
