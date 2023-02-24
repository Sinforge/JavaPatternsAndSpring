package sinforge.practice21.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinforge.practice21.Entities.Departure;
import sinforge.practice21.Repo.DepartureRepo;
import sinforge.practice21.Repo.PostOfficeRepo;


import java.util.List;

@Service
@Slf4j
public class DepartureService {
    @Autowired
    private DepartureRepo departureRepo;
    @Autowired
    private PostOfficeRepo postOfficeRepo;
    @Autowired
    private MyEmailService emailService;

    public DepartureService(){}

    public DepartureService(DepartureRepo repo, PostOfficeRepo postOfficeRepo) {
        this.departureRepo = repo;
        this.postOfficeRepo = postOfficeRepo;
    }

    @Transactional
    public void add(String type, String date, int officeId) {
        Departure departure = new Departure();
        departure.setOffice(postOfficeRepo.findById(officeId).get());
        departure.setDate(date);
        departure.setType(type);
        emailService.send("vlad.vlasov77@mail.ru", "Creating departure object", "Departure: " +
                type + " " + date + " was created");
        log.info("Added new departure: " + type + " " + date);

        departureRepo.save(departure);

    }
    @Transactional
    public void delete(Integer id) {

        departureRepo.deleteById(id);
        log.info("Departure with id:" + id + " was deleted");
    }

    @Transactional(readOnly = true)
    public List<Departure> getAll() {
        log.info("Method getAll is called");
        return departureRepo.findAll();
    }
    @Transactional(readOnly=true)

    public List<Departure> sortByType() {
        log.info("Method sortByType is called");
        return departureRepo.findAll().stream()
                .sorted((d1,d2)-> d1.getType().compareTo(d2.getType())).toList();
    }
    @Transactional(readOnly = true)
    public List<Departure> sortByDate() {
        log.info("Method sortByType is called");
        return departureRepo.findAll().stream()
                .sorted((d1,d2)-> d1.getDate().compareTo(d2.getDate())).toList();
    }



}
