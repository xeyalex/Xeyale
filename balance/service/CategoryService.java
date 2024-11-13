package az.xeyale.balance.service;

import az.xeyale.balance.entity.Category;
import az.xeyale.balance.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Yeni kateqoriya yaratmaq
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Kateqoriyanı tapmaq (istifadəçi ID-sinə görə)
    public List<Category> getCategoriesByUserId(Long userId) {
        return categoryRepository.findByUserId(userId);
    }

    // Kateqoriyanı tapmaq (ID ilə)
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    // Kateqoriyanı yeniləmək
    public Category updateCategory(Long id, Category category) {
        // Məlumatları yoxlamaq və yeniləmək
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            category.setId(id);  // Mövcud ID-ni təyin et
            return categoryRepository.save(category);
        } else {
            throw new RuntimeException("Category not found with id " + id); // Uygun səhv mesajı
        }
    }

    // Kateqoriyanı silmək
    public void deleteCategory(Long id) {
        // Kateqoriya olub olmadığını yoxlamaq
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Category not found with id " + id); // Uygun səhv mesajı
        }
    }
}
