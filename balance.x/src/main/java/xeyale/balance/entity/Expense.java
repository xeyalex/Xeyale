package xeyale.balance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;  // Xərc miqdarı
    private LocalDate date;  // Xərclənən tarix

    @ManyToOne
    @JoinColumn(name = "expense_category_id")
    private ExpenseCategory expenseCategory;  // Xərc kateqoriyası

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // İstifadəçi
}
