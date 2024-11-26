package xeyale.balance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xeyale.balance.entity.ExpensePlan;

@Repository
public interface ExpensePlanRepository extends JpaRepository<ExpensePlan, Long> {
}
