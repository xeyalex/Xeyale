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
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;  // Gəlir miqdarı
    private LocalDate date;  // Gəlirin tarixi

    @ManyToOne
    @JoinColumn(name = "income_category_id")
    private IncomeCategory incomeCategory;  // Gəlir kateqoriyası

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // İstifadəçi
}
