package az.xeyale.balance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount; // Pul miqdarı

    private String type; // "income" (gəlir) və ya "expense" (xərc)

    private LocalDateTime date; // Əməliyyatın tarixi

    private String description; // Əməliyyatın təsviri

    @ManyToOne
    private Category category; // Əməliyyatın aid olduğu kateqoriya

    @ManyToOne
    private User user; // Əməliyyatı həyata keçirən istifadəçi

    // Əgər tarix təyin edilməyibsə, bu metod avtomatik olaraq tarixi təyin edir
    @PrePersist
    public void prePersist() {
        if (date == null) {
            this.date = LocalDateTime.now(); // Tarix təyin olunmadıqda indiki tarixi istifadə et
        }
    }
}
