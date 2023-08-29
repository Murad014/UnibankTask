package com.unibanktask.unibank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    // Actually we do not need column name with annotation, if field is same name with table column name
    // but for accurate I used.
    @Column(name="name", nullable = false)
    private String name;

    @Column(name="surname", nullable = false)
    private String surname;

    @Column(name="pin", nullable = false, unique = true)
    private String pin;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="registration_date")
    private LocalDateTime registrationDate = LocalDateTime.now();

    @Column(name="is_active")
    private boolean isActive = true;


}
