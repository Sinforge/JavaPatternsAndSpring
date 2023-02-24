package sinforge.practice22.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sinforge.practice22.Entities.Departure;
import sinforge.practice22.Entities.PostOffice;

@Repository
public interface PostOfficeRepo extends JpaRepository<PostOffice, Integer> {
    PostOffice findByCitynameAndName(String Cityname, String Name);

}
