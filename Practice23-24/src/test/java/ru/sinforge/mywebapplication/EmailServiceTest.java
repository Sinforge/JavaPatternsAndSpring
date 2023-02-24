package ru.sinforge.mywebapplication;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import ru.sinforge.practice24.Services.MyEmailService;
@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {

    @Mock
    private MyEmailService service;
    @Test
    public void sendEmail() {
        service.send("vlad.vlasov77@mail.ru", "testing", "test successful");
    }
}
