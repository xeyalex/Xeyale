package xeyale.balance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xeyale.balance.entity.Income;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
    List<Income> findByIncomeCategoryIdAndDateBetween(Long incomeCategoryId, LocalDate startDate, LocalDate endDate);
    List<Income> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
