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
public class ExpensePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double plannedAmount;  // Planlaşdırılan məbləğ
    private LocalDate startDate;  // Başlanğıc tarixi
    private LocalDate endDate;    // Bitmə tarixi

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // İstifadəçi
}
