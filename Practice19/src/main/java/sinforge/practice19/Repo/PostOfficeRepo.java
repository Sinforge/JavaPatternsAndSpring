package sinforge.practice19.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sinforge.practice19.Entities.Departure;
import sinforge.practice19.Entities.PostOffice;

@Repository
public interface PostOfficeRepo extends JpaRepository<PostOffice, Integer> {
    PostOffice findByCitynameAndName(String Cityname, String Name);

}
