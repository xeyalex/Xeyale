package az.xeyale.balance.repository;

import az.xeyale.balance.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByUserId(Long userId); // Verilən istifadəçiyə aid kateqoriyalar
}
