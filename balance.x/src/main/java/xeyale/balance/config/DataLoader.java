package xeyale.balance.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xeyale.balance.entity.Role;
import xeyale.balance.entity.User;
import xeyale.balance.repository.RoleRepository;
import xeyale.balance.repository.UserRepository;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Demo rollarını əlavə etmək
        Role userRole = new Role();
        userRole.setName("USER");
        roleRepository.save(userRole);

        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        roleRepository.save(adminRole);

        // Demo istifadəçi yaratmaq
        User user = new User();
        user.setUsername("user");
        user.setPassword("userpass");
        user.setRoles(Set.of(userRole));  // USER rolunu əlavə etmək
        userRepository.save(user);

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("adminpass");
        admin.setRoles(Set.of(adminRole));  // ADMIN rolunu əlavə etmək
        userRepository.save(admin);
    }
}
