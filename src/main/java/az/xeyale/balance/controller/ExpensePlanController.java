package az.xeyale.balance.controller;

import az.xeyale.balance.entity.ExpensePlan;
import az.xeyale.balance.service.ExpensePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense-plans")
public class ExpensePlanController {

    @Autowired
    private ExpensePlanService expensePlanService;

    // Yeni xərc planı yaratmaq
    @PostMapping
    public ResponseEntity<ExpensePlan> createExpensePlan(@RequestBody ExpensePlan expensePlan) {
        ExpensePlan createdExpensePlan = expensePlanService.createExpensePlan(expensePlan);
        return ResponseEntity.ok(createdExpensePlan);
    }

    // İstifadəçiyə aid xərc planlarını tapmaq
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ExpensePlan>> getExpensePlansByUserId(@PathVariable Long userId) {
        List<ExpensePlan> expensePlans = expensePlanService.getExpensePlansByUserId(userId);
        return ResponseEntity.ok(expensePlans);
    }

    // Xərc planını yeniləmək
    @PutMapping("/{id}")
    public ResponseEntity<ExpensePlan> updateExpensePlan(@PathVariable Long id, @RequestBody ExpensePlan expensePlan) {
        ExpensePlan updatedExpensePlan = expensePlanService.updateExpensePlan(id, expensePlan);
        return ResponseEntity.ok(updatedExpensePlan);
    }

    // Xərc planını silmək
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpensePlan(@PathVariable Long id) {
        expensePlanService.deleteExpensePlan(id);
        return ResponseEntity.noContent().build();
    }
}
