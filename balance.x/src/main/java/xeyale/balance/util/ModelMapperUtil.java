package xeyale.balance.util;

import xeyale.balance.entity.Expense;
import xeyale.balance.model.ExpenseResponse;

public class ModelMapperUtil {

    public static ExpenseResponse mapToExpenseResponse(Expense expense) {
        return new ExpenseResponse(
                expense.getExpenseCategory() != null ? expense.getExpenseCategory().getName() : null, // ExpenseCategory-dən name alınır
                expense.getAmount(),
                expense.getDate()
        );
    }
}
