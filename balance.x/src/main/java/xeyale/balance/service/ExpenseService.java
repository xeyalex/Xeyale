package xeyale.balance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xeyale.balance.entity.Expense;
import xeyale.balance.repository.ExpenseRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> getExpensesByCategoryAndDateRange(Long categoryId, LocalDate startDate, LocalDate endDate) {
        return expenseRepository.findByExpenseCategoryIdAndDateBetween(categoryId, startDate, endDate);
    }

    public List<Expense> getExpensesByDateRange(LocalDate startDate, LocalDate endDate) {
        return expenseRepository.findByDateBetween(startDate, endDate);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
