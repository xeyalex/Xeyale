package az.xeyale.balance.service;

import az.xeyale.balance.entity.Transaction;
import az.xeyale.balance.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // Yeni əməliyyat əlavə etmək
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // İki tarix aralığında əməliyyatları tapmaq
    public List<Transaction> getTransactionsByUserIdAndDateRange(Long userId, LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.findByUserIdAndDateBetween(userId, startDate, endDate);
    }

    // İstifadəçiyə aid əməliyyatları tapmaq
    public List<Transaction> getTransactionsByUserId(Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    // Əməliyyatı ID ilə tapmaq
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    // Əməliyyatı yeniləmək
    public Transaction updateTransaction(Long id, Transaction transaction) {
        Optional<Transaction> existingTransaction = transactionRepository.findById(id);
        if (existingTransaction.isPresent()) {
            transaction.setId(id);  // Mövcud ID-ni təyin et
            return transactionRepository.save(transaction);
        } else {
            throw new RuntimeException("Transaction not found with id " + id);  // Əməliyyat tapılmadıqda səhv mesajı
        }
    }

    // Əməliyyatı silmək
    public void deleteTransaction(Long id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Transaction not found with id " + id);  // Əməliyyat tapılmadıqda səhv mesajı
        }
    }
}
