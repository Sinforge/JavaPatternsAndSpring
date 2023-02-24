package ru.sinforge.practice24.Services;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sinforge.practice24.Entities.MyUser;
import ru.sinforge.practice24.Repo.UserRepo;

@Service
public class UserService implements UserDetailsService {
    private final UserRepo repo;
    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepo repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = (BCryptPasswordEncoder) encoder;
    }

    public boolean addUser(String userName, String Password){
        if(repo.findByUsername(userName) != null) {
            return false;
        }
        MyUser user = new MyUser();
        user.setUsername(userName);
        user.setPassword(encoder.encode(Password));
        repo.save(user);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByUsername(username);
    }
}
