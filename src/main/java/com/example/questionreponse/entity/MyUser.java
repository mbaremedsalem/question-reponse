package com.example.questionreponse.entity;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.CascadeType;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, updatable = true)
    private String password;
    @Column(unique = true)
    private String nni;
    @Column(unique = true)
    private String phoneNumber;
    private String address;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Question> questions;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Answer> answers;
    @ManyToOne(optional = true)
    private Role role;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    
}
