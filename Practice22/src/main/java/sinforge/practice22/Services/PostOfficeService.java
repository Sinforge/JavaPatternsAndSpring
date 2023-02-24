package sinforge.practice22.Services;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinforge.practice22.Entities.PostOffice;
import sinforge.practice22.Repo.PostOfficeRepo;

import java.util.List;

@Service
@Slf4j
public class PostOfficeService {
    @Autowired
    private PostOfficeRepo postOfficeRepo;
    @Autowired
    private MyEmailService emailService;

    public PostOfficeService(){}
    public PostOfficeService(PostOfficeRepo postOffice) {
        this.postOfficeRepo = postOffice;
    }


    @Transactional
    public void add(String name, String city) {
        log.info("Added new postoffice: " + name + " " + city);
        emailService.send("vlad.vlasov77@mail.ru", "Creating PostOffice object", "Departure: " +
                name + " " + city + " was created");
        postOfficeRepo.save(new PostOffice(name, city));

    }
    @Transactional
    public void delete(Integer id) {
        log.info("PostOffice with id:" + id + " was deleted");
        postOfficeRepo.deleteById(id);

    }
    @Transactional(readOnly = true)
    public List<PostOffice> getAll() {

        log.info("Method getAll is called");
        return postOfficeRepo.findAll();
    }
    @Transactional(readOnly = true)
    public List<PostOffice> sortByName() {
        log.info("Method sortByName is called");
        return postOfficeRepo.findAll().stream()
                .sorted((p1,p2)-> p1.getName().compareTo(p2.getName())).toList();
    }
    @Transactional(readOnly = true)
    public List<PostOffice> sortByCity() {
        log.info("Method sortByCity is called");

        return postOfficeRepo.findAll().stream()
                .sorted((p1,p2)-> p1.getCityname().compareTo(p2.getCityname())).toList();
    }
}
