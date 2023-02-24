package sinforge.practice18.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinforge.practice18.Entities.Departure;
import sinforge.practice18.Repo.DepartureRepo;
import sinforge.practice18.Repo.PostOfficeRepo;


import java.util.List;

@Service
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
        departureRepo.save(departure);

    }
    public void delete(Integer id) {
        departureRepo.deleteById(id);
    }

    public List<Departure> getAll() {
        return departureRepo.findAll();
    }
    public List<Departure> sortByType() {
        return departureRepo.findAll().stream()
                .sorted((d1,d2)-> d1.getType().compareTo(d2.getType())).toList();
    }
    public List<Departure> sortByDate() {
        return departureRepo.findAll().stream()
                .sorted((d1,d2)-> d1.getDate().compareTo(d2.getDate())).toList();
    }



}
