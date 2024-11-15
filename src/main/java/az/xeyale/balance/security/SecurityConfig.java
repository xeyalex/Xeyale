package az.xeyale.balance.security;

import az.xeyale.balance.filter.JwtAuthenticationFilter;
import az.xeyale.balance.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public SecurityConfig(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // AuthenticationManager konfiqurasiyası
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

    // SecurityFilterChain konfiqurasiyası
    @Bean
                public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                    http.csrf().disable()
                            .authorizeHttpRequests()
                            .requestMatchers("/auth/**", "/public/**", "/h2-console/**").permitAll()  // Bu URL-lərə icazə verilir
                            .anyRequest().authenticated()  // Digər URL-lər üçün autentifikasiya tələb olunur
                            .and()
                            .headers().frameOptions().disable()  // H2 konsolunun işləməsi üçün lazımdır
                            .and()
                            .addFilterBefore(new JwtAuthenticationFilter(authenticationManager(http), jwtUtil, userService), UsernamePasswordAuthenticationFilter.class);  // JWT doğrulama filtri

                    return http.build();
    }
}
