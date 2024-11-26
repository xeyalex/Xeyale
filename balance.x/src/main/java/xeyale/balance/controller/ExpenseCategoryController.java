package xeyale.balance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xeyale.balance.entity.ExpenseCategory;
import xeyale.balance.service.ExpenseCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/expense-categories")
public class ExpenseCategoryController {

    @Autowired
    private ExpenseCategoryService expenseCategoryService;

    @PostMapping
    public ResponseEntity<ExpenseCategory> createExpenseCategory(@RequestBody ExpenseCategory expenseCategory) {
        return new ResponseEntity<>(expenseCategoryService.createCategory(expenseCategory), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ExpenseCategory> getAllExpenseCategories() {
        return expenseCategoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseCategory> getExpenseCategoryById(@PathVariable Long id) {
        return expenseCategoryService.findById(id)
                .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseCategory> updateExpenseCategory(@PathVariable Long id, @RequestBody ExpenseCategory expenseCategory) {
        return new ResponseEntity<>(expenseCategoryService.updateCategory(id, expenseCategory), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpenseCategory(@PathVariable Long id) {
        expenseCategoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
