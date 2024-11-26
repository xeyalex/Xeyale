package xeyale.balance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xeyale.balance.entity.Expense;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByExpenseCategoryIdAndDateBetween(Long expenseCategoryId, LocalDate startDate, LocalDate endDate);
    List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
