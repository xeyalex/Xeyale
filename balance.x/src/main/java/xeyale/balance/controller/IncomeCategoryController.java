package xeyale.balance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xeyale.balance.entity.IncomeCategory; // `IncomeCategory` entity istifadə edilir
import xeyale.balance.service.IncomeCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/income-categories")
public class IncomeCategoryController {

    @Autowired
    private IncomeCategoryService incomeCategoryService;

    @PostMapping
    public ResponseEntity<IncomeCategory> createIncomeCategory(@RequestBody IncomeCategory incomeCategory) {
        return new ResponseEntity<>(incomeCategoryService.createCategory(incomeCategory), HttpStatus.CREATED);
    }

    @GetMapping
    public List<IncomeCategory> getAllIncomeCategories() {
        return incomeCategoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeCategory> getIncomeCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(incomeCategoryService.getCategoryById(id).orElseThrow(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncomeCategory> updateIncomeCategory(@PathVariable Long id, @RequestBody IncomeCategory incomeCategory) {
        return new ResponseEntity<>(incomeCategoryService.updateCategory(id, incomeCategory), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncomeCategory(@PathVariable Long id) {
        incomeCategoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
