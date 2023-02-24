package ru.sinforge.mywebapplication;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sinforge.practice24.Entities.Departure;
import ru.sinforge.practice24.Entities.PostOffice;
import ru.sinforge.practice24.Repo.DepartureRepo;
import ru.sinforge.practice24.Repo.PostOfficeRepo;
import ru.sinforge.practice24.Services.DepartureService;
import ru.sinforge.practice24.Services.MyEmailService;
import ru.sinforge.practice24.Services.PostOfficeService;

import java.util.List;

@ExtendWith(MockitoExtension.class)

public class DepartureServiceTest {

    @Captor
    ArgumentCaptor<Departure> captor;

    @Mock
    private DepartureRepo departureRepo;

    @Mock
    private PostOfficeRepo postOfficeRepo;
    @Mock
    private MyEmailService myEmailService;





    @Test
    void addDeparture() {

        DepartureService service = new DepartureService(departureRepo, postOfficeRepo, myEmailService);
        service.add("Cheel", "04.10.2003", 20);
        Mockito.verify(departureRepo).save(captor.capture());
        Departure captured = captor.getValue();
        Assertions.assertEquals("Cheel", captured.getType());
        Assertions.assertEquals("04.10.2003", captured.getDate());
    }

    //Delete method of JPA repositories doesnt thrown exception

    @Test
    void getAll() {
        DepartureService service = new DepartureService(departureRepo, postOfficeRepo,myEmailService);
        Departure[] massive = new Departure[] {
                new Departure("Aboba", "10.03.2003"),
                new Departure("type2", "20.03.2023")
        };
        Mockito.when(departureRepo.findAll()).thenReturn(List.of(massive));

        Assertions.assertEquals(service.getAll().size(), 2);
    }

    @Test
    void getSortedByType() {
        DepartureService service = new DepartureService(departureRepo, postOfficeRepo,myEmailService);
        Departure[] massive = new Departure[] {
                new Departure("Aboba", "10.03.2003"),
                new Departure("type2", "20.03.2023")
        };
        Mockito.when(departureRepo.findAll()).thenReturn(List.of(massive));

        Assertions.assertEquals(service.getAll()
                .stream()
                .sorted((p1,p2)->
                        p1.getType().compareTo(p2.getType())).toList()
                .get(0).getDate(), "10.03.2003");
    }
    @Test
    void getSortedByDate() {
        DepartureService service = new DepartureService(departureRepo, postOfficeRepo, myEmailService);
        Departure[] massive = new Departure[] {
                new Departure("Aboba", "10.03.2003"),
                new Departure("type2", "20.03.2023")
        };
        Mockito.when(departureRepo.findAll()).thenReturn(List.of(massive));

        Assertions.assertEquals(service.getAll()
                .stream()
                .sorted((p1,p2)->
                        p1.getDate().compareTo(p2.getDate())).toList()
                .get(0).getType(), "Aboba");
    }

}
