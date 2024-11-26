package xeyale.balance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xeyale.balance.entity.Income;
import xeyale.balance.repository.IncomeRepository;

import java.time.LocalDate;
import java.util.List;

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

    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }
}
