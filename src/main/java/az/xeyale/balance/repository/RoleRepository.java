package az.xeyale.balance.repository;

import az.xeyale.balance.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);  // Rolun adına görə axtarış edəcəyik
}
