package xeyale.balance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xeyale.balance.entity.IncomeCategory;

@Repository
public interface IncomeCategoryRepository extends JpaRepository<IncomeCategory, Long> {
}
