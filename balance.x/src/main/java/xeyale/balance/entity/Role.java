package xeyale.balance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Rol adı

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
