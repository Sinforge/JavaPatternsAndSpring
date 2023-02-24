package ru.sinforge.mywebapplication;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.sinforge.practice24.Entities.MyUser;
import ru.sinforge.practice24.Entities.PostOffice;
import ru.sinforge.practice24.Repo.PostOfficeRepo;
import ru.sinforge.practice24.Repo.UserRepo;
import ru.sinforge.practice24.Services.MyEmailService;
import ru.sinforge.practice24.Services.PostOfficeService;
import ru.sinforge.practice24.Services.UserService;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PostOfficeServiceTest {

    @Captor
    ArgumentCaptor<PostOffice> captor;

    @Mock
    private PostOfficeRepo postOfficeRepo;
    @Mock
    private MyEmailService emailService;




    @Test
    void addPostOffice() {

        PostOfficeService service = new PostOfficeService(postOfficeRepo, emailService);
        service.add("Telegram", "Kazan");
        Mockito.verify(postOfficeRepo).save(captor.capture());
        PostOffice captured = captor.getValue();
        Assertions.assertEquals("Telegram", captured.getName());
        Assertions.assertEquals("Kazan", captured.getCityname());
    }

    //Delete method of JPA repositories doesnt thrown exception

    @Test
    void getAll() {
        PostOfficeService service = new PostOfficeService(postOfficeRepo, emailService);
        PostOffice[] massive = new PostOffice[] {
                new PostOffice("Vlad", "Moscow"),
                new PostOffice("PochtaRussia", "Ufa"),
                new PostOffice("SuperVlad", "Ryazan")
        };
        Mockito.when(postOfficeRepo.findAll()).thenReturn(List.of(massive));

        Assertions.assertEquals(service.getAll().size(), 3);
    }

    @Test
    void getSortedByCity() {
        PostOfficeService service = new PostOfficeService(postOfficeRepo, emailService);
        PostOffice[] massive = new PostOffice[] {
                new PostOffice("Vlad", "Moscow"),
                new PostOffice("PochtaRussia", "Ufa"),
                new PostOffice("SuperVlad", "Ryazan")
        };
        Mockito.when(postOfficeRepo.findAll()).thenReturn(List.of(massive));

        Assertions.assertEquals(service.getAll()
                .stream()
                .sorted((p1,p2)->
                        p1.getCityname().compareTo(p2.getCityname())).toList()
                .get(0).getName(), "Vlad");
    }
    @Test
    void getSortedByName() {
        PostOfficeService service = new PostOfficeService(postOfficeRepo, emailService);
        PostOffice[] massive = new PostOffice[] {
                new PostOffice("Vlad", "Moscow"),
                new PostOffice("PochtaRussia", "Ufa"),
                new PostOffice("SuperVlad", "Ryazan")
        };
        Mockito.when(postOfficeRepo.findAll()).thenReturn(List.of(massive));

        Assertions.assertEquals(service.getAll()
                .stream()
                .sorted((p1,p2)->
                        p1.getName().compareTo(p2.getName())).toList()
                .get(0).getCityname(), "Ufa");
    }

}
