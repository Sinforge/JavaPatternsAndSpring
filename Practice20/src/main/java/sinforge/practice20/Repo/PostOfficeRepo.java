package sinforge.practice20.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sinforge.practice20.Entities.Departure;
import sinforge.practice20.Entities.PostOffice;

@Repository
public interface PostOfficeRepo extends JpaRepository<PostOffice, Integer> {
    PostOffice findByCitynameAndName(String Cityname, String Name);

}
