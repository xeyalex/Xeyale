package az.xeyale.balance.repository;

import az.xeyale.balance.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserIdAndDateBetween(Long userId, LocalDateTime startDate, LocalDateTime endDate);
    List<Transaction> findByUserId(Long userId);
}
