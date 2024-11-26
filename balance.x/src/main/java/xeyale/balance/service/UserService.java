package xeyale.balance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import xeyale.balance.entity.User;
import xeyale.balance.repository.UserRepository;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Yeni istifadəçi yaratmaq
    public User createUser(User user) {
        // Şifrəni şifrələyirik
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // İstifadəçi adı ilə istifadəçi tapmaq
    public User getUserByUsername(String username) {
        // Optional istifadə edərək yoxlamaq
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user.get();  // İstifadəçi tapıldısa, onu qaytarırıq
        } else {
            throw new RuntimeException("User not found");  // Tapılmadıqda səhv atırıq
        }
    }
}
