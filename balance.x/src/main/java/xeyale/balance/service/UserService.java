package xeyale.balance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xeyale.balance.entity.User;
import xeyale.balance.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Yeni istifadəçi yaratmaq
    public User createUser(User user) {
        return userRepository.save(user);  // UserRepository vasitəsilə istifadəçi məlumatını saxlama
    }

    // İstifadəçi adı ilə istifadəçi tapmaq
    public User getUserByUsername(String username) {
        // Optional istifadə edirik və tapılmayan halda null qaytarırıq
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.orElse(null);  // İstifadəçi tapılmadıqda null qaytarılır
    }
}
