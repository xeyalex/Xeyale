package xeyale.balance.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BalanceReportDTO {
    private BigDecimal totalIncome;
    private BigDecimal totalExpense;
    private BigDecimal currentBalance;
}