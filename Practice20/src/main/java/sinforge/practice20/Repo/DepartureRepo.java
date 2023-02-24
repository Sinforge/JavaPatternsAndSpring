package sinforge.practice20.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sinforge.practice20.Entities.Departure;
@Repository
public interface DepartureRepo extends JpaRepository<Departure, Integer> {
    Departure findByDateAndType(String Date, String Type);

}
