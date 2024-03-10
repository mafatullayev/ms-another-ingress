package com.example.msanotheringress.dao.entity;

import com.example.msanotheringress.model.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

import static jakarta.persistence.EnumType.STRING;
    @Getter
    @Setter
    @EqualsAndHashCode(of = "id")
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "payments")
    @Builder
    public class PaymentEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Enumerated(STRING)
        private PaymentStatus status;

        private BigDecimal amount;

        private String description;
}