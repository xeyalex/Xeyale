package az.xeyale.balance.controller;

import az.xeyale.balance.entity.User;
import az.xeyale.balance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // Qeydiyyat formu üçün POST metodu
    @PostMapping("/register")
    public String registerUser(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword) {

        // Şifrələrin uyğunluğunu yoxlamaq
        if (!password.equals(confirmPassword)) {
            return "redirect:/register?error"; // Qeydiyyat səhifəsinə qayıt, əgər şifrələr uyğun deyilsə
        }

        // Yeni istifadəçi yaratmaq
        User user = new User(username, email, password); // Burada User modelini istifadə edirik
        userService.save(user); // UserService sinifi istifadəçi məlumatlarını saxlayacaq

        return "redirect:/login"; // Qeydiyyat bitdikdən sonra login səhifəsinə yönləndir
    }

    // Giriş formu üçün POST metodu (JWT tokeni yaratmaq üçün istifadə edilə bilər)
    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        // Burada istifadəçi doğrulaması və token yaratma prosesi ola bilər
        // Token yaratmaq üçün JWT istifadə edəcəyik
        return "redirect:/dashboard"; // Giriş uğurlu olduqda istifadəçi ana səhifəyə yönləndirilir
    }
}
