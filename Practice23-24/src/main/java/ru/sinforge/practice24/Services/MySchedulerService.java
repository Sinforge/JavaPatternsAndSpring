package ru.sinforge.practice24.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.sinforge.practice24.Entities.Departure;
import ru.sinforge.practice24.Entities.PostOffice;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class MySchedulerService{
    @Autowired
    private DepartureService departureService;
    @Autowired
    private PostOfficeService postOfficeService;
    private final Path departureSrc = Path.of("C:\\Users\\vladv\\OneDrive\\Рабочий стол\\DirForDatabase\\departure.txt");
    private final Path postofficeSrc = Path.of("C:\\Users\\vladv\\OneDrive\\Рабочий стол\\DirForDatabase\\postoffice.txt");

    @Scheduled(cron = "0 0/30 * * * ?")
    public void doScheduledTask() throws IOException {
        if(Files.exists(departureSrc)) {
            Files.delete(departureSrc);
        }
        if(Files.exists(postofficeSrc)) {
            Files.delete(postofficeSrc);
        }
        List<Departure> departureList = departureService.getAll();
        List<PostOffice> postOfficeList = postOfficeService.getAll();

        StringBuilder departuresData = new StringBuilder();
        StringBuilder postofficeData = new StringBuilder();
        for(Departure d : departureList) {
            departuresData.append(d.getId()).append(" ").append(d.getType()).append(" ").append(d.getDate()).append("\n");
        }
        for(PostOffice p : postOfficeList) {
            postofficeData.append(p.getId()).append(" ").append(p.getName()).append(" ").append(p.getCityname()).append("\n");
        }
        FileWriter fileWriter = new FileWriter("C:\\Users\\vladv\\OneDrive\\Рабочий стол\\DirForDatabase\\departure.txt");
        fileWriter.write(departuresData.toString());
        fileWriter.close();

        FileWriter fileWriter1 = new FileWriter("C:\\Users\\vladv\\OneDrive\\Рабочий стол\\DirForDatabase\\postoffice.txt");
        fileWriter1.write(postofficeData.toString());
        fileWriter.close();

    }
}
