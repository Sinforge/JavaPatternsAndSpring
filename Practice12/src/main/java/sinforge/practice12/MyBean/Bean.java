package sinforge.practice12.MyBean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class Bean {
    @Autowired
    private ApplicationArguments applicationArguments;

    private boolean isExist = false;

    @PostConstruct
    public void init() throws IOException {
        String dataFile1 = null;
        try {
            dataFile1 = new String(Files.readAllBytes(Path.of(applicationArguments.getSourceArgs()[0])));
            isExist = true;
        } catch (IOException e) {
            dataFile1 = null;
        }
        finally {
            File file = new File(applicationArguments.getSourceArgs()[1]);
            FileWriter writer = new FileWriter (file);
            writer.write(dataFile1 ==null ? "null" : dataFile1.hashCode() + "");
            writer.flush();
            writer.close();
        }


    }

    @PreDestroy
    public void destroy() {
        if(isExist) {
            File file = new File(applicationArguments.getSourceArgs()[0]);
            file.delete();
        }

    }

}
