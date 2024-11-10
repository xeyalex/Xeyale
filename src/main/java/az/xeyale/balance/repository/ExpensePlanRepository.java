package az.xeyale.balance.repository;

import az.xeyale.balance.entity.ExpensePlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpensePlanRepository extends JpaRepository<ExpensePlan, Long> {
    List<ExpensePlan> findByUserId(Long userId); // Verilən istifadəçiyə aid xərc planları
}
