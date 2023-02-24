package sinforge.practice18.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sinforge.practice18.Entities.Departure;
import sinforge.practice18.Entities.PostOffice;

@Repository
public interface PostOfficeRepo extends JpaRepository<PostOffice, Integer> {
    PostOffice findByCitynameAndName(String Cityname, String Name);

}
