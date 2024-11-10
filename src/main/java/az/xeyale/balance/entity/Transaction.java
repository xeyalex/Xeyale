package az.xeyale.balance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    private String type; // "income" or "expense"

    private LocalDateTime date;

    private String description;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    @PrePersist
    public void prePersist() {
        if (date == null) {
            this.date = LocalDateTime.now();
        }
    }
}
