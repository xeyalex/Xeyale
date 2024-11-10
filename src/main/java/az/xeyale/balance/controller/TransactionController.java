package az.xeyale.balance.controller;

import az.xeyale.balance.entity.Transaction;
import az.xeyale.balance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Yeni əməliyyat yaratmaq
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction createdTransaction = transactionService.createTransaction(transaction);
        return ResponseEntity.ok(createdTransaction);
    }

    // İki tarix aralığında əməliyyatları tapmaq
    @GetMapping("/user/{userId}/range")
    public ResponseEntity<List<Transaction>> getTransactionsByDateRange(
            @PathVariable Long userId,
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate) {
        List<Transaction> transactions = transactionService.getTransactionsByUserIdAndDateRange(userId, startDate, endDate);
        return ResponseEntity.ok(transactions);
    }

    // İstifadəçiyə aid əməliyyatları tapmaq
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Transaction>> getTransactionsByUserId(@PathVariable Long userId) {
        List<Transaction> transactions = transactionService.getTransactionsByUserId(userId);
        return ResponseEntity.ok(transactions);
    }
}
