package az.xeyale.balance.service;

import az.xeyale.balance.entity.ExpensePlan;
import az.xeyale.balance.repository.ExpensePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensePlanService {

    @Autowired
    private ExpensePlanRepository expensePlanRepository;

    // Yeni xərc planı yaratmaq
    public ExpensePlan createExpensePlan(ExpensePlan expensePlan) {
        return expensePlanRepository.save(expensePlan);
    }

    // İstifadəçiyə aid xərc planlarını tapmaq
    public List<ExpensePlan> getExpensePlansByUserId(Long userId) {
        return expensePlanRepository.findByUserId(userId);
    }

    // Xərc planını yeniləmək
    public ExpensePlan updateExpensePlan(Long id, ExpensePlan expensePlan) {
        expensePlan.setId(id);
        return expensePlanRepository.save(expensePlan);
    }

    // Xərc planını silmək
    public void deleteExpensePlan(Long id) {
        expensePlanRepository.deleteById(id);
    }
}
