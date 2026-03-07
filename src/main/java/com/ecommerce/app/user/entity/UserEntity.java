package com.ecommerce.app.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_user_email", columnNames = "email"),
                @UniqueConstraint(name = "uk_user_cpf", columnNames = "cpf"),
                @UniqueConstraint(name = "uk_user_rg", columnNames = "rg")
        }
)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name must not be blank")
    @Size(max = 80, message = "Name must have at most 80 characters")
    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email must not be blank")
    @Size(max = 80, message = "Email must have at most 80 characters")
    @Column(name = "email", nullable = false, length = 80)
    private String email;

    @CPF(message = "CPF must be valid")
    @NotBlank(message = "CPF must not be blank")
    @Size(min = 11, max = 11, message = "CPF must contain exactly 11 digits")
    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @NotBlank(message = "RG must not be blank")
    @Size(max = 11, message = "RG must contain at most 11 characters")
    @Column(name = "rg", nullable = false, length = 11)
    private String rg;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}