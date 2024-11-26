package xeyale.balance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import xeyale.balance.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
