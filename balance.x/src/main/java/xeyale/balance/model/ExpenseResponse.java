package xeyale.balance.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ExpenseResponse {
    private String category;
    private double amount;
    private LocalDate date;
}
