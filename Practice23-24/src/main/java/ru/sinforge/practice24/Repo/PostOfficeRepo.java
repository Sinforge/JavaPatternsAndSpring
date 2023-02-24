package ru.sinforge.practice24.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sinforge.practice24.Entities.PostOffice;

@Repository
public interface PostOfficeRepo extends JpaRepository<PostOffice, Integer> {
    PostOffice findByCitynameAndName(String Cityname, String Name);

}
