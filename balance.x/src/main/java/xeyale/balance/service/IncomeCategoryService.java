package xeyale.balance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xeyale.balance.entity.IncomeCategory;  // `IncomeCategory` entity istifadə edilir
import xeyale.balance.repository.IncomeCategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeCategoryService {

    @Autowired
    private IncomeCategoryRepository incomeCategoryRepository;

    public List<IncomeCategory> getAllCategories() {
        return incomeCategoryRepository.findAll();
    }

    public IncomeCategory createCategory(IncomeCategory category) {
        return incomeCategoryRepository.save(category);
    }

    public Optional<IncomeCategory> getCategoryById(Long id) {
        return incomeCategoryRepository.findById(id);
    }

    public IncomeCategory updateCategory(Long id, IncomeCategory incomeCategory) {
        if (incomeCategoryRepository.existsById(id)) {
            incomeCategory.setId(id);  // id-nin təkrar yazılmaması üçün
            return incomeCategoryRepository.save(incomeCategory);
        } else {
            throw new RuntimeException("IncomeCategory not found");
        }
    }

    public void deleteCategory(Long id) {
        incomeCategoryRepository.deleteById(id);
    }
}
