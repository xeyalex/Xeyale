package az.xeyale.balance.controller;

import az.xeyale.balance.entity.Transaction;
import az.xeyale.balance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Tarix aralığında əməliyyatları tapmaq
    @GetMapping("/user/{userId}/range")
    public ResponseEntity<List<Transaction>> getTransactionsByDateRange(
            @PathVariable Long userId,
            @RequestParam String startDate,  // Parametrlər String olaraq alınır
            @RequestParam String endDate) {  // Parametrlər String olaraq alınır

        // Stringləri LocalDateTime formatına çeviririk
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime start = LocalDateTime.parse(startDate, formatter);
        LocalDateTime end = LocalDateTime.parse(endDate, formatter);

        // TransactionService-dən tarix aralığına əsasən əməliyyatları alırıq
        List<Transaction> transactions = transactionService.getTransactionsByUserIdAndDateRange(userId, start, end);
        return ResponseEntity.ok(transactions);
    }

    // İstifadəçiyə aid əməliyyatları tapmaq
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Transaction>> getTransactionsByUserId(@PathVariable Long userId) {
        List<Transaction> transactions = transactionService.getTransactionsByUserId(userId);
        return ResponseEntity.ok(transactions);
    }
}
