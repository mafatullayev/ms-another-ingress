package com.example.msanotheringress.dao.repository;

import com.example.msanotheringress.dao.entity.PaymentEntity;
import com.example.msanotheringress.model.enums.PaymentStatus;

import java.util.Optional;

public interface PaymentRepository {
    Optional<PaymentEntity> findByIdAndStatusNot(Long id, PaymentStatus status);
}