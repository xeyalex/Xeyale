package az.xeyale.balance.service;

import az.xeyale.balance.entity.Role;  // Role entity-ni import edirik
import az.xeyale.balance.entity.User;
import az.xeyale.balance.repository.RoleRepository;  // RoleRepository-ni import edirik
import az.xeyale.balance.repository.UserRepository;
import az.xeyale.balance.security.JwtUtil;  // JwtUtil sinifini import edirik
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;  // Şifrəni şifrələmək üçün import
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;  // RoleRepository-i inject edirik

    @Autowired
    private PasswordEncoder passwordEncoder;  // PasswordEncoder-i inject edirik

    @Autowired
    private JwtUtil jwtUtil;  // JwtUtil sinifini inject edirik

    // loadUserByUsername metodu (autentifikasiya üçün)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    // Token əsasında autentifikasiya yaratmaq
    public Authentication getAuthentication(String token) {
        String username = jwtUtil.extractUsername(token);  // Tokeni yoxlayırıq
        UserDetails userDetails = loadUserByUsername(username);  // User məlumatını alırıq
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    // Yeni istifadəçi yaratmaq üçün metod
    public User createUser(User user) {
        // Şifrəni şifrələyirik
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // İstifadəçiyə "USER" rolunu təyin edirik
        Role userRole = roleRepository.findByName("ROLE_USER");
        if (userRole == null) {
            userRole = new Role("ROLE_USER");
            roleRepository.save(userRole);
        }
        user.setRoles(Collections.singleton(userRole));  // USER rolunu təyin edirik

        // Yeni istifadəçini bazaya əlavə edirik
        return userRepository.save(user);
    }

    // İstifadəçini username-ə görə tapmaq
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }

    // Yeni istifadəçi əlavə etmək
    public void save(User user) {
        userRepository.save(user);
    }
}
