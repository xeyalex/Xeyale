package xeyale.balance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xeyale.balance.entity.ExpensePlan;
import xeyale.balance.service.ExpensePlanService;

@RestController
@RequestMapping("/api/expense-plans")
public class ExpensePlanController {

    @Autowired
    private ExpensePlanService expensePlanService;

    // Create a new Expense Plan
    @PostMapping
    public ResponseEntity<ExpensePlan> createExpensePlan(@RequestBody ExpensePlan plan) {
        ExpensePlan createdPlan = expensePlanService.createPlan(plan);
        return new ResponseEntity<>(createdPlan, HttpStatus.CREATED);
    }

    // Delete an existing Expense Plan by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpensePlan(@PathVariable Long id) {
        expensePlanService.deletePlan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
