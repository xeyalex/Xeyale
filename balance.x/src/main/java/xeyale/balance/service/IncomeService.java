package xeyale.balance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xeyale.balance.entity.Income;  // `Income` entity istifadə edilir
import xeyale.balance.repository.IncomeRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    public Income createIncome(Income income) {
        return incomeRepository.save(income);
    }

    public List<Income> getIncomesByCategoryAndDateRange(Long categoryId, LocalDate startDate, LocalDate endDate) {
        return incomeRepository.findByIncomeCategoryIdAndDateBetween(categoryId, startDate, endDate);
    }

    public List<Income> getIncomesByDateRange(LocalDate startDate, LocalDate endDate) {
        return incomeRepository.findByDateBetween(startDate, endDate);
    }

    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    public Optional<Income> getIncomeById(Long id) {
        return incomeRepository.findById(id);
    }

    public Income updateIncome(Long id, Income income) {
        if (incomeRepository.existsById(id)) {
            income.setId(id);  // id-nin təkrar yazılmaması üçün
            return incomeRepository.save(income);
        } else {
            throw new RuntimeException("Income not found");
        }
    }

    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }
}
