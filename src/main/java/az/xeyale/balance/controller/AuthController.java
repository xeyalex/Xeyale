package az.xeyale.balance.controller;

import az.xeyale.balance.security.JwtUtil;
import az.xeyale.balance.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        // Login logic burada olacaq. İstifadəçi adı və şifrəni yoxlayacağıq.
        // Əgər düzgün məlumatlar daxil edilsə, JWT token-i yaradılacaq.
        String token = jwtUtil.generateToken(loginRequest.getUsername());
        return ResponseEntity.ok(token);  // Token geri qaytarılır
    }
}
