package az.xeyale.balance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String type; // "income" or "expense"

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "category")
    private List<Transaction> transactions;
}
