package com.example.msanotheringress.mapper;

import com.example.msanotheringress.dao.entity.PaymentEntity;
import com.example.msanotheringress.model.enums.PaymentStatus;
import com.example.msanotheringress.model.request.CreatePaymentRequest;
import com.example.msanotheringress.model.response.PaymentResponse;

public enum PaymentMapper {
    PAYMENT_MAPPER;

    public PaymentEntity buildPaymentEntity(CreatePaymentRequest payment) {
        return PaymentEntity
                .builder()
                .amount(payment.getAmount())
                .description((payment.getDescription()))
                .status(PaymentStatus.ACTIVE)
                .build();

    }

    public PaymentResponse buildPaymentResponse(PaymentEntity payment){
        return PaymentResponse.builder()
                .id(payment.getId())
                .description(payment.getDescription())
                .amount(payment.getAmount())
                .status(payment.getStatus())
                .build();
    }
}
