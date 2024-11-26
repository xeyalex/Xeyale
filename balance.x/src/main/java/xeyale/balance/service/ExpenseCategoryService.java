package xeyale.balance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xeyale.balance.entity.ExpenseCategory;
import xeyale.balance.repository.ExpenseCategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseCategoryService {

    @Autowired
    private ExpenseCategoryRepository expenseCategoryRepository;

    public List<ExpenseCategory> getAllCategories() {
        return expenseCategoryRepository.findAll();
    }

    public ExpenseCategory createCategory(ExpenseCategory category) {
        return expenseCategoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        expenseCategoryRepository.deleteById(id);
    }

    public Optional<ExpenseCategory> findById(Long id) {
        return expenseCategoryRepository.findById(id);
    }

    public ExpenseCategory updateCategory(Long id, ExpenseCategory expenseCategory) {
        if (expenseCategoryRepository.existsById(id)) {
            expenseCategory.setId(id);  // id-nin təkrar yazılmaması üçün
            return expenseCategoryRepository.save(expenseCategory);
        } else {
            throw new RuntimeException("ExpenseCategory not found");
        }
    }
}
