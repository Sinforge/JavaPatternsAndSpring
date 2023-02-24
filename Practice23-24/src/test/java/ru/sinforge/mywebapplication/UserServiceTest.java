package ru.sinforge.mywebapplication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.sinforge.practice24.Entities.MyUser;
import ru.sinforge.practice24.Repo.UserRepo;
import ru.sinforge.practice24.Services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Captor
    ArgumentCaptor<MyUser> captor;

    @Mock
    private UserRepo userRepo;
    @Mock
    private BCryptPasswordEncoder encoder;



    public UserServiceTest() {
    }

    @Test
    void addUser() {

        UserService service = new UserService(userRepo, encoder);
        service.addUser("BobaFett", "SuperJorik123");
        Mockito.verify(userRepo).save(captor.capture());
        MyUser captured = captor.getValue();
        Assertions.assertEquals("BobaFett", captured.getUsername());
        Assertions.assertEquals(encoder.encode("SuperJorik123"),
                captured.getPassword());
    }

}
