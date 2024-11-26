package xeyale.balance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xeyale.balance.entity.IncomeCategory;
import xeyale.balance.repository.IncomeCategoryRepository;

import java.util.List;

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

    public void deleteCategory(Long id) {
        incomeCategoryRepository.deleteById(id);
    }
}
