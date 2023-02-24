package sinforge.practice22.jmx;


import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;
import sinforge.practice22.Services.MySchedulerService;

import java.io.IOException;

@Component
@ManagedResource(description = "Reload data from database to files")
public class SchedulerMBean {
    public final MySchedulerService mySchedulerService;


    public SchedulerMBean(MySchedulerService mySchedulerService) {
        this.mySchedulerService = mySchedulerService;
    }

    @ManagedOperation(description = "To reload data")
    public void reloadFiles() throws IOException {
        mySchedulerService.doScheduledTask();
    }
}
