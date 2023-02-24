package sinforge.practice19.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sinforge.practice19.Entities.Departure;
@Repository
public interface DepartureRepo extends JpaRepository<Departure, Integer> {
    Departure findByDateAndType(String Date, String Type);

}
