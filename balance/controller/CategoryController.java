package az.xeyale.balance.controller;

import az.xeyale.balance.entity.Category;
import az.xeyale.balance.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Yeni kateqoriya yaratmaq
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(createdCategory);
    }

    // İstifadəçiyə aid kateqoriyalar
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Category>> getCategoriesByUserId(@PathVariable Long userId) {
        List<Category> categories = categoryService.getCategoriesByUserId(userId);
        return ResponseEntity.ok(categories);
    }

    // Kateqoriyanı yeniləmək
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(id, category);
        return ResponseEntity.ok(updatedCategory);
    }

    // Kateqoriyanı silmək
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
