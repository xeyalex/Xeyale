package az.xeyale.balance.controller;

import az.xeyale.balance.entity.User;
import az.xeyale.balance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;  // PasswordEncoder-in inject edilməsi

    // Yeni istifadəçi yaratmaq
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        // İstifadəçi artıq varsa, qeydiyyatdan keçirməyi önləyirik
        if (userService.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already taken");
        }

        // Yeni istifadəçi yaratmaq üçün UserService-i istifadə edirik
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    // İstifadəçini username və şifrə ilə login etmək
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        // İstifadəçini tapırıq
        User existingUser = userService.findByUsername(user.getUsername());

        // İstifadəçi tapılmadıqda
        if (existingUser == null) {
            return ResponseEntity.status(401).body("User not found");
        }

        // Şifrəni yoxlayırıq
        if (passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            // Şifrə doğrudursa, istifadəçini təsdiqləyirik
            return ResponseEntity.ok("Login successful");
        } else {
            // Şifrə yanlışdırsa
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
