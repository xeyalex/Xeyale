package xeyale.balance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()  // CSRF qorumasını deaktiv edin
                .authorizeHttpRequests()  // Burada `authorizeHttpRequests()` istifadə edilir
                .requestMatchers("/api/users/register", "/api/users/login", "/register", "/login").permitAll()  // Bu yolları açıq saxlayın
                .anyRequest().authenticated()  // Digər sorğular autentifikasiya tələb edir
                .and()
                .httpBasic();  // Basic Authentication istifadə edin

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
