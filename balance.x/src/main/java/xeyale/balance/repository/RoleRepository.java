package xeyale.balance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xeyale.balance.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);  // Rol adına görə axtarış
}
