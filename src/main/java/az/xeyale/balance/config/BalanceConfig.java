package az.xeyale.balance.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BalanceConfig {

    @Value("${balance.expense.limit}")
    private double expenseLimit;

    @Value("${balance.income.limit}")
    private double incomeLimit;

    @Value("${balance.report.date-format}")
    private String reportDateFormat; // Hesabat üçün tarix formatı

    public double getExpenseLimit() {
        return expenseLimit;
    }

    public double getIncomeLimit() {
        return incomeLimit;
    }

    public String getReportDateFormat() {
        return reportDateFormat;
    }
}
