package com.unibanktask.unibank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="accounts")
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @Column(name="balance", columnDefinition = "NUMERIC(10, 2)")
    private BigDecimal balance;

    @Column(name="create_date_time")
    private LocalDateTime createDateTime = LocalDateTime.now();

    @Column(name="is_active")
    private boolean isActive = true;




}
