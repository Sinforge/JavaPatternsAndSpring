package ru.sinforge.practice24.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sinforge.practice24.Entities.MyUser;

@Repository
public interface UserRepo extends JpaRepository<MyUser, Integer> {

    MyUser findByUsername(String Username);
}
