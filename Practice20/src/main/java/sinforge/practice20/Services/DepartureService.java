package sinforge.practice20.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinforge.practice20.Entities.Departure;
import sinforge.practice20.Repo.DepartureRepo;
import sinforge.practice20.Repo.PostOfficeRepo;


import java.util.List;

@Service
@Slf4j
public class DepartureService {
    @Autowired
    private DepartureRepo departureRepo;
    @Autowired
    private PostOfficeRepo postOfficeRepo;

    public DepartureService(){}

    public DepartureService(DepartureRepo repo, PostOfficeRepo postOfficeRepo) {
        this.departureRepo = repo;
        this.postOfficeRepo = postOfficeRepo;
    }

    public void add(String type, String date, int officeId) {
        Departure departure = new Departure();
        departure.setOffice(postOfficeRepo.findById(officeId).get());
        departure.setDate(date);
        departure.setType(type);
        log.info("Added new departure: " + type + " " + date);
        departureRepo.save(departure);

    }
    public void delete(Integer id) {

        departureRepo.deleteById(id);
        log.info("Departure with id:" + id + " was deleted");
    }

    public List<Departure> getAll() {
        log.info("Method getAll is called");
        return departureRepo.findAll();
    }
    public List<Departure> sortByType() {
        log.info("Method sortByType is called");
        return departureRepo.findAll().stream()
                .sorted((d1,d2)-> d1.getType().compareTo(d2.getType())).toList();
    }
    public List<Departure> sortByDate() {
        log.info("Method sortByType is called");
        return departureRepo.findAll().stream()
                .sorted((d1,d2)-> d1.getDate().compareTo(d2.getDate())).toList();
    }



}
