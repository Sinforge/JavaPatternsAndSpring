package ru.sinforge.mywebapplication;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sinforge.practice24.Services.MySchedulerService;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class SchedulerServiceTest {

    @Mock
    private MySchedulerService service;

    @Test
    public void runScheduler() {
        try {
            service.doScheduledTask();

        }
        catch (IOException ex) {
            System.out.println("Something wrong...");
        }
    }
}
