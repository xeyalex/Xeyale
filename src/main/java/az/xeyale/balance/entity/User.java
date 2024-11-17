package az.xeyale.balance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "app_user")  // 'user' adı problemi yaratdığından, burada 'app_user' istifadə edirik
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)  // Email sahəsinin nullable olmasını təmin edirik
    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // İstifadəçi rolları ilə əlaqə
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles", // Bu, istifadəçi və rolu birləşdirən əlaqə cədvəli olacaq
            joinColumns = @JoinColumn(name = "user_id"), // istifadəçi cədvəli
            inverseJoinColumns = @JoinColumn(name = "role_id") // rol cədvəli
    )
    private Set<Role> roles = new HashSet<>();

    // Default constructor for JPA
    public User() {
        // Default constructor for JPA
    }

    // Constructor with username, password, and email
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // PrePersist method to set createdAt and updatedAt before persisting the entity
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // PreUpdate method to update the updatedAt timestamp before updating the entity
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
