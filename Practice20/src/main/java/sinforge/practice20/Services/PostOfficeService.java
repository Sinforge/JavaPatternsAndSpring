package sinforge.practice20.Services;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sinforge.practice20.Entities.PostOffice;
import sinforge.practice20.Repo.PostOfficeRepo;

import java.util.List;

@Service
@Slf4j
public class PostOfficeService {
    @Autowired
    private PostOfficeRepo postOfficeRepo;

    public PostOfficeService(){}
    public PostOfficeService(PostOfficeRepo postOffice) {
        this.postOfficeRepo = postOffice;
    }

    public void add(String name, String city) {
        log.info("Added new postoffice: " + name + " " + city);
        postOfficeRepo.save(new PostOffice(name, city));

    }
    public void delete(Integer id) {
        log.info("PostOffice with id:" + id + " was deleted");
        postOfficeRepo.deleteById(id);

    }

    public List<PostOffice> getAll() {

        log.info("Method getAll is called");
        return postOfficeRepo.findAll();
    }

    public List<PostOffice> sortByName() {
        log.info("Method sortByName is called");
        return postOfficeRepo.findAll().stream()
                .sorted((p1,p2)-> p1.getName().compareTo(p2.getName())).toList();
    }
    public List<PostOffice> sortByCity() {
        log.info("Method sortByCity is called");

        return postOfficeRepo.findAll().stream()
                .sorted((p1,p2)-> p1.getCityname().compareTo(p2.getCityname())).toList();
    }
}
