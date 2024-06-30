package xeyale.balance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double totalIncome;  // Ümumi gəlir
    private double totalExpense;  // Ümumi xərc
    private double balance;  // Cari balans

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // İstifadəçi
}
