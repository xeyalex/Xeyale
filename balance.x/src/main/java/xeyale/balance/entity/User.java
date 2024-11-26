package xeyale.balance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user")  // Cədvəl adı dəyişdirildi
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_roles",  // Ara cədvəl adı
            joinColumns = @JoinColumn(name = "user_id"),  // 'user_id' ilə əlaqələndiriləcək
            inverseJoinColumns = @JoinColumn(name = "role_id")  // 'role_id' ilə əlaqələndiriləcək
    )
    private Set<Role> roles = new HashSet<>();
}
