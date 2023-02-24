package ru.sinforge.practice24.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sinforge.practice24.Entities.Departure;
@Repository
public interface DepartureRepo extends JpaRepository<Departure, Integer> {
    Departure findByDateAndType(String Date, String Type);

}
