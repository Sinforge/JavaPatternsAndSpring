package sinforge.practice18.Services;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sinforge.practice18.Entities.PostOffice;
import sinforge.practice18.Repo.PostOfficeRepo;

import java.util.List;

@Service
public class PostOfficeService {
    @Autowired
    private PostOfficeRepo postOfficeRepo;

    public PostOfficeService(){}
    public PostOfficeService(PostOfficeRepo postOffice) {
        this.postOfficeRepo = postOffice;
    }

    public void add(String name, String city) {
        postOfficeRepo.save(new PostOffice(name, city));

    }
    public void delete(Integer id) {
        postOfficeRepo.deleteById(id);

    }

    public List<PostOffice> getAll() {
        return postOfficeRepo.findAll();
    }

    public List<PostOffice> sortByName() {
        return postOfficeRepo.findAll().stream()
                .sorted((p1,p2)-> p1.getName().compareTo(p2.getName())).toList();
    }
    public List<PostOffice> sortByCity() {
        return postOfficeRepo.findAll().stream()
                .sorted((p1,p2)-> p1.getCityname().compareTo(p2.getCityname())).toList();
    }
}
