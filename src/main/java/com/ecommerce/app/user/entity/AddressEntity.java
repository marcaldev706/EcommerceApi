package com.ecommerce.app.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Street must not be blank")
    @Size(max = 80, message = "Street must have at most 80 characters")
    @Column(name = "street", nullable = false, length = 80)
    private String street;

    @NotBlank(message = "Zip-Code must not be blank")
    @Size(max = 10, message = "Zip-Code must have at most 10 characters")
    @Column(name = "zip_code", nullable = false, length = 10)
    private String zipCode;

    @NotBlank(message = "Neighborhood must not be blank")
    @Size(max = 80, message = "Neighborhood must have at most 80 characters")
    @Column(name = "neighborhood", nullable = false, length = 80)
    private String neighborhood;

    @NotNull(message = "Number must not be null")
    @Column(name = "number", nullable = false)
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private UserEntity user;
}
